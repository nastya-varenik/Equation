package com.verenich.equation.specification;

import com.verenich.equation.entity.QuadraticEquation;

public interface EquationSpecification {
    boolean specified(QuadraticEquation equation);
}
