package com.verenich.equation.observer.impl;

import com.verenich.equation.entity.QuadraticEquation;
import com.verenich.equation.observer.Observer;
import com.verenich.equation.service.EquationSolver;
import com.verenich.equation.service.impl.QuadraticEquationSolverImpl;
import com.verenich.equation.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EquationObserverImpl implements Observer {
    private static final Logger logger = LogManager.getLogger(EquationObserverImpl.class);
    private final EquationSolver solver = new QuadraticEquationSolverImpl();
    private final Warehouse warehouse = Warehouse.getInstance();

    @Override
    public void update(QuadraticEquation equation) {
        logger.info("Equation updated: {}x^2 + {}x + {}", equation.getA(), equation.getB(), equation.getC());

        List<Double> roots = solver.findRoots(equation);
        warehouse.addEquation(equation, roots.stream().mapToDouble(Double::doubleValue).toArray());

        logger.info("Updated roots: {}", roots.isEmpty() ? "No real roots" : roots);
    }
}
