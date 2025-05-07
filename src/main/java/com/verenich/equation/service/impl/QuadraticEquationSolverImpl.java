package com.verenich.equation.service.impl;

import com.verenich.equation.entity.QuadraticEquation;
import com.verenich.equation.service.EquationSolver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class QuadraticEquationSolverImpl implements EquationSolver {
    private static final Logger logger = LogManager.getLogger(QuadraticEquationSolverImpl.class);

    @Override
    public List<Double> findRoots(QuadraticEquation eq) {
        logger.info("Solving the equation: {}x^2 + {}x + {}", eq.getA(), eq.getB(), eq.getC());
        double a = eq.getA(), b = eq.getB(), c = eq.getC();
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            logger.info("No roots.");
            return List.of();
        } else if (discriminant == 0) {
            return List.of(-b / (2 * a));
        } else {
            double sqrtD = Math.sqrt(discriminant);
            return List.of((-b + sqrtD) / (2 * a), (-b - sqrtD) / (2 * a));
        }
    }
}
