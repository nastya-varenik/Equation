package com.verenich.equation.pool;

import com.verenich.equation.entity.QuadraticEquation;

import java.util.Comparator;

public class EquationComparator {

    public static Comparator<QuadraticEquation> byA() {
        return Comparator.comparingDouble(QuadraticEquation::getA);
    }

    public static Comparator<QuadraticEquation> byB() {
        return Comparator.comparingDouble(QuadraticEquation::getB);
    }

    public static Comparator<QuadraticEquation> byC() {
        return Comparator.comparingDouble(QuadraticEquation::getC);
    }

    public static Comparator<QuadraticEquation> byDiscriminant() {
        return Comparator.comparingDouble(QuadraticEquation::getDiscriminant);
    }

    public static Comparator<QuadraticEquation> byRootCount() {
        return (e1, e2) -> Integer.compare(e1.getRootCount(), e2.getRootCount());
    }
}
