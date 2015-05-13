package fr.michot.funfair.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright SMABTP
 * Created by A14830 on 12/05/2015.
 */
public class VisitorGroup {
    protected Long id;
    private List<Visitor> visitorList;
    private List<VisitorWish> visitorWishList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Visitor> getVisitorList() {
        return visitorList==null?new ArrayList<Visitor>():visitorList;
    }

    public void setVisitorList(List<Visitor> visitorList) {
        this.visitorList = visitorList;
    }

    public List<VisitorWish> getVisitorWishList() {
        return visitorWishList==null?new ArrayList<VisitorWish>():visitorWishList;
    }

    public void setVisitorWishList(List<VisitorWish> visitorWishList) {
        this.visitorWishList = visitorWishList;
    }

    @Override
    public String toString() {
        return visitorList+", ";
    }
}
