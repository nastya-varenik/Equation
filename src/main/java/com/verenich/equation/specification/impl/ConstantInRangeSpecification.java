package com.verenich.equation.specification.impl;

import com.verenich.equation.entity.QuadraticEquation;
import com.verenich.equation.specification.EquationSpecification;

public class ConstantInRangeSpecification implements EquationSpecification {
    @Override
    public boolean specified(QuadraticEquation equation) {
        double c = equation.getC();
        return c >= -10 && c <= 10;
    }
}
