package com.verenich.equation.service;

import com.verenich.equation.entity.QuadraticEquation;
import java.util.List;

public interface EquationSolver {
    List<Double> findRoots(QuadraticEquation eq);
}
