package com.verenich.equation.validator.impl;

import com.verenich.equation.entity.QuadraticEquation;
import com.verenich.equation.validator.EquationValidator;

public class EquationValidatorImpl implements EquationValidator {
    @Override
    public boolean isValid(QuadraticEquation eq) {
        return eq.getA() != 0;
    }
}
