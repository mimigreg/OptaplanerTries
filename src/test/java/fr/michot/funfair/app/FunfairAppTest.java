package fr.michot.funfair.app;

import fr.michot.funfair.domain.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FunfairAppTest {

    DayPlanning dayPlanning;

    @org.junit.Before
    public void setUp() throws Exception {
        // Load dataset
        System.out.println("Generating dataset");
        //this.dayPlanning = DataSetGenerator.generateTotalDataSetFromTotalJson("dataset.json");
        this.dayPlanning = DataSetGenerator.generateTotalDataSet("attractionList.json", 60000, 1, 9, 22, 20);

        System.out.println("Preparing problem");
        // Set a non ordonated session list
        ArrayList<FunSession> funSessions = new ArrayList<FunSession>();
        for(VisitorGroup visitorGroup: dayPlanning.getVisitorGroupList()) {
            for (VisitorWish visitorWish : visitorGroup.getVisitorWishList()) {
                FunSession funSession = new FunSession();
                funSession.setAttraction(visitorWish.getAttraction());
                funSession.setVisitorGroup(visitorGroup);
                funSessions.add(funSession);
            }
        }
        this.dayPlanning.setFunSessionList(funSessions);
        System.out.println("Ready to test");
    }

    @Test
    @Ignore
    public void testMain() throws Exception {
        assertNotNull("Fail : dayPlanning not initialized",dayPlanning);
        FunfairApp.main(null);
    }

    @Test
    public void testSolveProblem() throws Exception {
        assertNotNull("Fail : dayPlanning not initialized",dayPlanning);
        dayPlanning = FunfairApp.solveProblem(dayPlanning);
        assertNotNull(dayPlanning.getFunSessionList());

        System.out.println(FunfairApp.toDisplayString(dayPlanning));
        System.out.println("Hard : "+dayPlanning.getScore().getHardScore()+" Soft : "+dayPlanning.getScore().getSoftScore());
    }

    @Test
    public void testToDisplayString() throws Exception {
        assertNotNull("Fail : dayPlanning not initialized",dayPlanning);

    }
}