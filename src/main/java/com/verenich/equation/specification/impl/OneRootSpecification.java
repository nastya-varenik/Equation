package com.verenich.equation.specification.impl;

import com.verenich.equation.entity.QuadraticEquation;
import com.verenich.equation.entity.EquationState;
import com.verenich.equation.specification.EquationSpecification;

public class OneRootSpecification implements EquationSpecification {
    @Override
    public boolean specified(QuadraticEquation equation) {
        return equation.getState() == EquationState.ONE_REAL_ROOT;
    }
}
