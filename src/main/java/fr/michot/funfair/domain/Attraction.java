package fr.michot.funfair.domain;

/**
 * Copyright SMABTP
 * Created by A14830 on 12/05/2015.
 */
public class Attraction {
    protected Long id;
    private String name;
    private int sessionCapacity;
    private int sessionDuration;
    private Long longitude;
    private Long latitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSessionCapacity() {
        return sessionCapacity;
    }

    public void setSessionCapacity(int sessionCapacity) {
        this.sessionCapacity = sessionCapacity;
    }

    public int getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(int sessionDuration) {
        this.sessionDuration = sessionDuration;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return name;
    }
}
