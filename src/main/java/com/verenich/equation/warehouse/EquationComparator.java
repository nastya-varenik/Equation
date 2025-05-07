package com.verenich.equation.warehouse;

import com.verenich.equation.entity.QuadraticEquation;

import java.util.Comparator;

public class EquationComparator {

    private enum ComparatorType {
        BY_A(Comparator.comparingDouble(QuadraticEquation::getA)),
        BY_B(Comparator.comparingDouble(QuadraticEquation::getB)),
        BY_C(Comparator.comparingDouble(QuadraticEquation::getC)),
        BY_DISCRIMINANT(Comparator.comparingDouble(QuadraticEquation::getDiscriminant)),
        BY_ROOT_COUNT(Comparator.comparingInt(QuadraticEquation::getRootCount));

        private final Comparator<QuadraticEquation> comparator;

        ComparatorType(Comparator<QuadraticEquation> comparator) {
            this.comparator = comparator;
        }

        public Comparator<QuadraticEquation> getComparator() {
            return comparator;
        }
    }

    public static Comparator<QuadraticEquation> byA() {
        return ComparatorType.BY_A.getComparator();
    }

    public static Comparator<QuadraticEquation> byB() {
        return ComparatorType.BY_B.getComparator();
    }

    public static Comparator<QuadraticEquation> byC() {
        return ComparatorType.BY_C.getComparator();
    }

    public static Comparator<QuadraticEquation> byDiscriminant() {
        return ComparatorType.BY_DISCRIMINANT.getComparator();
    }

    public static Comparator<QuadraticEquation> byRootCount() {
        return ComparatorType.BY_ROOT_COUNT.getComparator();
    }
}
