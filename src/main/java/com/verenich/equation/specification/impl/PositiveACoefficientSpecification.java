package com.verenich.equation.specification.impl;

import com.verenich.equation.entity.QuadraticEquation;
import com.verenich.equation.specification.EquationSpecification;

public class PositiveACoefficientSpecification implements EquationSpecification {
    @Override
    public boolean specified(QuadraticEquation equation) {
        return equation.getA() > 0;
    }
}
