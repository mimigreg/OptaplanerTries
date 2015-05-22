package fr.michot.funfair.domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Copyright SMABTP
 * Created by A14830 on 12/05/2015.
 */
@PlanningSolution()
public class DayPlanning implements Solution<HardSoftScore> {

    private List<Visitor> visitorList;
    private List<VisitorGroup> visitorGroupList;
    private List<Attraction> attractionList;
    private List<Period> periodList;
   // private List<VisitorWish> visitorWishList;

    private List<FunSession> funSessionList;

    private HardSoftScore score;

    public List<Visitor> getVisitorList() {
        return visitorList;
    }

    public void setVisitorList(List<Visitor> visitorList) {
        this.visitorList = visitorList;
    }

    public List<VisitorGroup> getVisitorGroupList() {
        return visitorGroupList;
    }

    public void setVisitorGroupList(List<VisitorGroup> visitorGroupList) {
        this.visitorGroupList = visitorGroupList;
    }

    public List<Attraction> getAttractionList() {
        return attractionList;
    }

    public void setAttractionList(List<Attraction> attractionList) {
        this.attractionList = attractionList;
    }

    @ValueRangeProvider(id = "periodRange")
    public List<Period> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<Period> periodList) {
        this.periodList = periodList;
    }

    @PlanningEntityCollectionProperty
    public List<FunSession> getFunSessionList() {
        return funSessionList;
    }

    public void setFunSessionList(List<FunSession> funSessionList) {
        this.funSessionList = funSessionList;
    }

//    public List<VisitorWish> getVisitorWishList() {
//        return visitorWishList;
//    }
//
//    public void setVisitorWishList(List<VisitorWish> visitorWishList) {
//        this.visitorWishList = visitorWishList;
//    }
//
    @Override
    public HardSoftScore getScore() {
        return score;
    }

    @Override
    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    public Collection<? extends Object> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
//        facts.addAll(visitorWishList);
        facts.addAll(visitorGroupList);
        facts.addAll(attractionList);
        facts.addAll(periodList);

        return facts;
    }

}
