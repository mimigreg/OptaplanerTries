package fr.michot.funfair.domain;

/**
 * Copyright SMABTP
 * Created by A14830 on 12/05/2015.
 */
public class Visitor {
    protected Long id;
    private String firstName;
    private String familyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String toString() {
        return firstName  + " " + familyName;
    }
}
