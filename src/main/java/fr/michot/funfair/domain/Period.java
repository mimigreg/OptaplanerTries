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
    private int duration; // in minutes

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return startDateTimeString;
    }
}
