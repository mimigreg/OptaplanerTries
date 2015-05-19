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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attraction that = (Attraction) o;

        if (sessionCapacity != that.sessionCapacity) return false;
        if (sessionDuration != that.sessionDuration) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + sessionCapacity;
        result = 31 * result + sessionDuration;
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        return result;
    }
}
