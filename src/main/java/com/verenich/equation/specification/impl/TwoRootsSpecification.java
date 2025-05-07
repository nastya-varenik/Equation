package com.verenich.equation.specification.impl;

import com.verenich.equation.entity.QuadraticEquation;
import com.verenich.equation.entity.EquationState;
import com.verenich.equation.specification.EquationSpecification;

public class TwoRootsSpecification implements EquationSpecification {
    @Override
    public boolean specified(QuadraticEquation equation) {
        return equation.getState() == EquationState.TWO_REAL_ROOTS;
    }
}
