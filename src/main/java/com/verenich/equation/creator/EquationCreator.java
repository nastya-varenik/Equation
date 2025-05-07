package com.verenich.equation.creator;
import com.verenich.equation.entity.QuadraticEquation;
import java.util.Optional;

public interface EquationCreator {
    Optional<QuadraticEquation> createEquation(double a, double b, double c);
}
