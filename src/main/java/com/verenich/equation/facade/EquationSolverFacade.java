package com.verenich.equation.facade;

import com.verenich.equation.creator.EquationCreator;
import com.verenich.equation.creator.impl.EquationCreatorImpl;
import com.verenich.equation.entity.QuadraticEquation;
import com.verenich.equation.io.FileParser;
import com.verenich.equation.io.LineParser;
import com.verenich.equation.pool.Warehouse;
import com.verenich.equation.repository.EquationRepository;
import com.verenich.equation.service.EquationSolver;
import com.verenich.equation.service.impl.QuadraticEquationSolverImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class EquationSolverFacade {
    private static final Logger logger = LogManager.getLogger(EquationSolverFacade.class);

    private final FileParser fileParser;
    private final LineParser lineParser;
    private final EquationCreator equationCreator;
    private final EquationSolver solver;
    private final EquationRepository repository;
    private final Warehouse warehouse;

    public EquationSolverFacade() {
        this.fileParser = new FileParser();
        this.lineParser = new LineParser();
        this.equationCreator = new EquationCreatorImpl();
        this.solver = new QuadraticEquationSolverImpl();
        this.repository = new EquationRepository();
        this.warehouse = Warehouse.getInstance();
    }

    public void processEquations(String filePath) {
        List<String> lines = fileParser.readLinesFromFile(filePath);

        for (String line : lines) {
            Optional<double[]> coefficientsOpt = lineParser.parseLine(line);
            if (coefficientsOpt.isPresent()) {
                double[] coeffs = coefficientsOpt.get();
                Optional<QuadraticEquation> equationOpt = equationCreator.createEquation(coeffs[0], coeffs[1], coeffs[2]);
                if (equationOpt.isPresent()) {
                    QuadraticEquation eq = equationOpt.get();
                    repository.add(eq);
                    logger.info("Equation: {}x^2 + {}x + {}", eq.getA(), eq.getB(), eq.getC());
                    List<Double> roots = solver.findRoots(eq);
                    warehouse.addEquation(eq, roots.stream().mapToDouble(Double::doubleValue).toArray());
                    logger.info("Roots: {}", roots.isEmpty() ? "No real roots" : roots);
                }
            } else {
                logger.warn("Skipping invalid line: {}", line);
            }
        }

        if (repository.getAll().isEmpty()) {
            logger.warn("No valid quadratic equations found in the file.");
        }
    }

    public EquationRepository getRepository() {
        return repository;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
}
