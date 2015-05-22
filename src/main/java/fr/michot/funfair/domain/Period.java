package fr.michot.funfair.domain;

/**
 * Copyright SMABTP
 * Created by A14830 on 12/05/2015.
 */
public class Period {
    protected Long id;
    private String periodDescription;
    private int periodIndex;
    private int durationInMinutes; // in minutes

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodDescription() {
        return periodDescription;
    }

    public void setPeriodDescription(String periodDescription) {
        this.periodDescription = periodDescription;
    }

    public int getPeriodIndex() {
        return periodIndex;
    }

    public void setPeriodIndex(int periodIndex) {
        this.periodIndex = periodIndex;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String toString() {
        return periodDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Period period = (Period) o;

        if (durationInMinutes != period.durationInMinutes) return false;
        if (periodIndex != period.periodIndex) return false;
        if (id != null ? !id.equals(period.id) : period.id != null) return false;
        if (periodDescription != null ? !periodDescription.equals(period.periodDescription) : period.periodDescription != null)
            return false;

        return true;
    }

}
