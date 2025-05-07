package com.verenich.equation.warehouse;

import com.verenich.equation.entity.QuadraticEquation;
import com.verenich.equation.observer.Observer;
import com.verenich.equation.service.EquationSolver;
import com.verenich.equation.service.impl.QuadraticEquationSolverImpl;

import java.util.HashMap;
import java.util.Map;

public class Warehouse implements Observer {
    private static Warehouse instance;
    private final Map<QuadraticEquation, double[]> equationData;
    private final EquationSolver solver;

    private Warehouse() {
        this.equationData = new HashMap<>();
        this.solver = new QuadraticEquationSolverImpl();
    }

    // сортировки через класс компоратора

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void addEquation(QuadraticEquation equation, double[] roots) {
        equationData.put(equation, roots);
    }

    public void updateData(QuadraticEquation equation) {
        double[] roots = solver.findRoots(equation).stream().mapToDouble(Double::doubleValue).toArray();
        equationData.put(equation, roots);
    }

    public double[] getRoots(QuadraticEquation equation) {
        return equationData.get(equation);
    }

    @Override
    public void update(QuadraticEquation equation) {
        updateData(equation);
    }
}
