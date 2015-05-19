package fr.michot.funfair.app;

import fr.michot.funfair.domain.DayPlanning;
import fr.michot.funfair.domain.FunSession;
import fr.michot.funfair.domain.Visitor;
import fr.michot.funfair.domain.VisitorGroup;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import java.io.StringWriter;
import java.util.*;

/**
 * Copyright SMABTP
 * Created by A14830 on 12/05/2015.
 */
public class FunfairApp {
    public static final String SOLVER_CONFIG = "fr/michot/funfair/solver/funfairSolverConfig.xml";

    public static void main(String[] args) {
        // Load a problem
        DayPlanning  unsolvedDayPlanning = new DayPlanning();

        // Solve a problem
        DayPlanning  solvedDayPlanning = solveProblem(unsolvedDayPlanning);

        // Display the result
        System.out.println("\nSolved dayPlaning :\n" + toDisplayString(solvedDayPlanning));
    }

    public static final DayPlanning solveProblem(DayPlanning unsolvedDayPlanning) {
        // Build the Solver
        SolverFactory solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
        Solver solver = solverFactory.buildSolver();

        // Solve the problem
        solver.solve(unsolvedDayPlanning);
        DayPlanning solvedDayPlanning = (DayPlanning) solver.getBestSolution();

        return solvedDayPlanning;
    }

    public static final String toDisplayString(DayPlanning solvedDayPlanning) {
        StringWriter sw = new StringWriter();

        List<FunSession> funSessions = solvedDayPlanning.getFunSessionList();
        Map<String,List<Visitor>> attractionsPlaning = new HashMap();
        for (FunSession funSession : funSessions) {
            String timedAttraction = funSession.getAttraction().getName() + "\t\t" + funSession.getPeriod().getStartDateTimeString()+ "\t\t capacity : " + funSession.getAttraction().getSessionCapacity();
            List<Visitor> visitorGroups = attractionsPlaning.get(timedAttraction);
            if(visitorGroups == null) visitorGroups = new ArrayList<Visitor>();
            visitorGroups.addAll(funSession.getVisitorGroup().getVisitorList());
            attractionsPlaning.put(timedAttraction,visitorGroups);
        }

        for (String timedAttraction : attractionsPlaning.keySet()) {
            sw.append(timedAttraction + " \t\t" );
            sw.append(" Used : "+attractionsPlaning.get(timedAttraction).size());
            boolean isFirst = true;
            for(Visitor visitor : attractionsPlaning.get(timedAttraction)) {
                sw.append((isFirst?"\t":", ")+ visitor.toString());
                isFirst = false;
            }
            sw.append("\n");
        }

        return sw.toString();
    }
}
