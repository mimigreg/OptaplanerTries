package fr.michot.funfair.domain;

/**
 * Copyright SMABTP
 * Created by A14830 on 12/05/2015.
 */

import fr.michot.funfair.domain.solver.FunSessionDifficultyComparator;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity(difficultyComparatorClass = FunSessionDifficultyComparator.class)
public class FunSession {
    protected Long id;
    protected Period period;
    protected Attraction attraction;
    protected VisitorGroup visitorGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PlanningVariable(valueRangeProviderRefs = {"periodRange"})
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    public VisitorGroup getVisitorGroup() {
        return visitorGroup;
    }

    public void setVisitorGroup(VisitorGroup visitorGroup) {
        this.visitorGroup = visitorGroup;
    }

    @Override
    public String toString() {
        return "FunSession{" +
                "period=" + period +
                ", attraction=" + attraction +
                ", visitorGroup=" + visitorGroup +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunSession that = (FunSession) o;

        if (attraction != null ? !attraction.equals(that.attraction) : that.attraction != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (period != null ? !period.equals(that.period) : that.period != null) return false;
        if (visitorGroup != null ? !visitorGroup.equals(that.visitorGroup) : that.visitorGroup != null) return false;

        return true;
    }

}
