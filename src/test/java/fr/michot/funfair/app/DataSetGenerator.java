package fr.michot.funfair.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.michot.funfair.domain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/05/2015.
 */
public class DataSetGenerator {
    private static final int MINUTES_IN_HOUR = 60;

    public static DayPlanning generateTotalDataSetFromTotalJson(String totalJsonFile) throws IOException {
        return getObjectFromJsonFile(totalJsonFile, DayPlanning.class);
    }

    public static DayPlanning generateTotalDataSet(String attractionListJsonFile, int numberVisitors, int maxGroupSize, int openHour, int closeHour, int periodSizeInMin) throws IOException {
        // Loading attraction
        DayPlanning dayPlanning = getObjectFromJsonFile(attractionListJsonFile, DayPlanning.class);

        // Generating visitors
        dayPlanning.setVisitorGroupList(generateRandomVisitorGroups(numberVisitors, maxGroupSize, dayPlanning.getAttractionList()));

        // Generating periods
        dayPlanning.setPeriodList(generatePeriods(openHour,closeHour,periodSizeInMin));

        return dayPlanning;
    }

    private static List<Period> generatePeriods(int openHour, int closeHour, int periodSizeInMin) {
        List<Period> periods = new ArrayList<Period>();
        long periodId = 0L;
        // Generating periods
        for (int minutesFromMidnight = (openHour*MINUTES_IN_HOUR); minutesFromMidnight < (closeHour*MINUTES_IN_HOUR); minutesFromMidnight+=periodSizeInMin) {
            Period period = new Period();
            period.setDurationInMinutes(periodSizeInMin);
            period.setId(++periodId);
            String startHour = writeInHourTheMinutesFromMidnight(minutesFromMidnight);
            String endHour = writeInHourTheMinutesFromMidnight(minutesFromMidnight+periodSizeInMin);
            period.setPeriodDescription(startHour + " - " + endHour);
            periods.add(period);
        }
        return periods;
    }

    private static String writeInHourTheMinutesFromMidnight(int minutesFromMidnight) {
        return ((int) Math.floor(minutesFromMidnight / 60))+"H"+((minutesFromMidnight%60>9)?(minutesFromMidnight%60):("0"+minutesFromMidnight%60));
    }

    private static List<VisitorGroup> generateRandomVisitorGroups(int numberVisitors, int maxGroupSize, List<Attraction> attractions) {
        // Generating groups
        List <VisitorGroup> visitorGroups= new ArrayList<VisitorGroup>();

        long groupId =1L;
        long visitorId=0L;
        long visitorWishId=0L;
        long randomizedGroupSize = new Double(1+ Math.random()*maxGroupSize).longValue();
        VisitorGroup visitorGroup = initiateNewEmptyVisitorGroup(groupId);

        while(visitorId<=numberVisitors) {
            Visitor visitor = new Visitor();
            visitor.setFirstName("G:"+groupId+"/S:"+randomizedGroupSize);
            visitor.setFamilyName("ID:"+(++visitorId));
            visitor.setId(visitorId);
            List visitorList = visitorGroup.getVisitorList();
            visitorList.add(visitor);
            if(visitorList.size()==randomizedGroupSize) {
                visitorGroups.add(visitorGroup);
                visitorGroup = initiateNewEmptyVisitorGroup(++groupId);
                randomizedGroupSize = new Double(1+ Math.random()*maxGroupSize).longValue();
            }
            VisitorWish visitorWish = new VisitorWish();
            visitorWish.setId(++visitorWishId);
            visitorWish.setAttraction(attractions.get((int) (visitorId % attractions.size())));
            visitorWish.setWishWeight(1);
            visitorGroup.getVisitorWishList().add(visitorWish);
        }
        return visitorGroups;
    }

    private static VisitorGroup initiateNewEmptyVisitorGroup(long groupId) {
        VisitorGroup visitorGroup = new VisitorGroup();
        visitorGroup.setId(groupId);
        visitorGroup.setVisitorList(new ArrayList<Visitor>());
        visitorGroup.setVisitorWishList(new ArrayList<VisitorWish>());
        return visitorGroup;
    }

    private static <T> T getObjectFromJsonFile(String fileName, Class<T> valueType ) throws IOException {
        // LoadJsonFile
        InputStream confFile = ClassLoader.getSystemResourceAsStream(fileName);

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
        return objectMapper.readValue(jsonData, valueType);
    }
}
