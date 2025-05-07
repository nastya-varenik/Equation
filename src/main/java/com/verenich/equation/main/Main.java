package com.verenich.equation.main;

import com.verenich.equation.facade.EquationSolverFacade;

public class Main {
    public static void main(String[] args) {
        EquationSolverFacade facade = new EquationSolverFacade();
        facade.processEquations("data/equations.txt");
    }
}
