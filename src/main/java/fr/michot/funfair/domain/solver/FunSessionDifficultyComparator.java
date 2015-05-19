package fr.michot.funfair.domain.solver;

import fr.michot.funfair.domain.FunSession;

import java.io.Serializable;
import java.util.Comparator;

import fr.michot.funfair.domain.VisitorGroup;
import org.apache.commons.lang.builder.CompareToBuilder;

/**
 * Copyright SMABTP
 * Created by A14830 on 13/05/2015.
 */
public class FunSessionDifficultyComparator implements Comparator<FunSession>, Serializable
    {
        public int compare(FunSession a, FunSession b) {
        VisitorGroup aGroup = a.getVisitorGroup();
            VisitorGroup bGroup  = b.getVisitorGroup();
        return new CompareToBuilder()
                .append(aGroup.getVisitorList().size(), bGroup.getVisitorList().size())
//                .append(aGroup.getVisitorWishList(), bGroup.getVisitorWishList())
                .append(a.getId(), b.getId())
                .toComparison();
    }

    }