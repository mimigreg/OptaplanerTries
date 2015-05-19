package fr.michot.funfair.domain;

/**
 * Copyright SMABTP
 * Created by A14830 on 12/05/2015.
 */
public class Period {
    protected Long id;
    private String startDateTimeString;
    private int periodIndex;
    private int dayIndex;
    private int durationInMinutes; // in minutes

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDateTimeString() {
        return startDateTimeString;
    }

    public void setStartDateTimeString(String startDateTimeString) {
        this.startDateTimeString = startDateTimeString;
    }

    public int getPeriodIndex() {
        return periodIndex;
    }

    public void setPeriodIndex(int periodIndex) {
        this.periodIndex = periodIndex;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String toString() {
        return startDateTimeString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Period period = (Period) o;

        if (dayIndex != period.dayIndex) return false;
        if (durationInMinutes != period.durationInMinutes) return false;
        if (periodIndex != period.periodIndex) return false;
        if (id != null ? !id.equals(period.id) : period.id != null) return false;
        if (startDateTimeString != null ? !startDateTimeString.equals(period.startDateTimeString) : period.startDateTimeString != null)
            return false;

        return true;
    }

}
