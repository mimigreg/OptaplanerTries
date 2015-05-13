package fr.michot.funfair.app;

import fr.michot.funfair.domain.DayPlanning;
import fr.michot.funfair.domain.FunSession;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import java.io.StringWriter;
import java.util.List;

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
        for (int i = 0; i < funSessions.size(); i++) {
            FunSession funSession =  funSessions.get(i);
            sw.write(funSession.toString()+"\n");
        }

        return sw.toString();
    }
}
