package fr.michot.funfair.domain;

/**
 * Copyright SMABTP
 * Created by A14830 on 12/05/2015.
 */
public class VisitorWish {
    protected Long id;
    private int wishWeight;
    private Attraction attraction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWishWeight() {
        return wishWeight;
    }

    public void setWishWeight(int wishWeight) {
        this.wishWeight = wishWeight;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    @Override
    public String toString() {
        return attraction + " " + "*****".substring(5-wishWeight);
    }
}
