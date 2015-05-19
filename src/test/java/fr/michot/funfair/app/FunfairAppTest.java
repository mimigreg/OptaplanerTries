package fr.michot.funfair.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.michot.funfair.domain.*;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FunfairAppTest {

    DayPlanning dayPlanning;

    @org.junit.Before
    public void setUp() throws Exception {
        // LoadConfFile
        InputStream confFile = ClassLoader.getSystemResourceAsStream("dataset.json");

        //read json file data to String
        InputStreamReader ir = new InputStreamReader(confFile);
        BufferedReader br = new BufferedReader(ir);
        StringWriter sr = new StringWriter();
        while (br.ready()) {
            sr.write(br.readLine());
        }
        byte[] jsonData = sr.toString().getBytes();

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        //convert json string to object
        this.dayPlanning = objectMapper.readValue(jsonData, DayPlanning.class);


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
    }

    @org.junit.Test
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