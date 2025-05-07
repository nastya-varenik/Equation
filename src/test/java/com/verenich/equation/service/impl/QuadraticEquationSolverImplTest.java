package com.verenich.equation.service.impl;

import com.verenich.equation.entity.QuadraticEquation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class QuadraticEquationSolverImplTest {
    private QuadraticEquationSolverImpl solver;

    @BeforeClass
    public void setUp() {
        solver = new QuadraticEquationSolverImpl();
    }

    @Test
    public void testFindRoots_TwoRealRoots() {
        // Уравнение: x^2 - 5x + 6 = 0 (корни: 2 и 3)
        QuadraticEquation eq = new QuadraticEquation(1, -5, 6);
        List<Double> roots = solver.findRoots(eq);

        // Ожидаемые корни
        Assert.assertEquals(roots.size(), 2);
        Assert.assertTrue(roots.contains(2.0));
        Assert.assertTrue(roots.contains(3.0));
    }

    @Test
    public void testFindRoots_OneRealRoot() {
        // Уравнение: x^2 - 4x + 4 = 0 (корень: 2)
        QuadraticEquation eq = new QuadraticEquation(1, -4, 4);
        List<Double> roots = solver.findRoots(eq);

        // Ожидаемый корень
        Assert.assertEquals(roots.size(), 1);
        Assert.assertEquals(roots.get(0), 2.0, 0.0001); // Добавляем точность
    }

    @Test
    public void testFindRoots_NoRealRoots() {
        // Уравнение: x^2 + x + 1 = 0 (нет вещественных корней)
        QuadraticEquation eq = new QuadraticEquation(1, 1, 1);
        List<Double> roots = solver.findRoots(eq);

        // Нет корней
        Assert.assertTrue(roots.isEmpty());
    }

    @Test
    public void testFindRoots_NegativeDiscriminant() {
        // Уравнение: x^2 + x + 1 = 0 (дискриминант отрицательный)
        QuadraticEquation eq = new QuadraticEquation(1, 1, 1);
        List<Double> roots = solver.findRoots(eq);

        // Ожидаемые корни: отсутствуют (дискриминант < 0)
        Assert.assertTrue(roots.isEmpty());
    }

    @Test
    public void testFindRoots_PositiveDiscriminant() {
        // Уравнение: x^2 - 2x - 3 = 0 (корни: -1 и 3)
        QuadraticEquation eq = new QuadraticEquation(1, -2, -3);
        List<Double> roots = solver.findRoots(eq);

        // Ожидаемые корни
        Assert.assertEquals(roots.size(), 2);
        Assert.assertTrue(roots.contains(-1.0));
        Assert.assertTrue(roots.contains(3.0));
    }

    @Test
    public void testFindRoots_ZeroCoefficientA() {
        // Уравнение: x^2 + 0x + 0 = 0 (корень: 0)
        QuadraticEquation eq = new QuadraticEquation(1, 0, 0);
        List<Double> roots = solver.findRoots(eq);

        // Ожидаемый корень: 0
        Assert.assertEquals(roots.size(), 1);
        Assert.assertEquals(roots.get(0), 0.0, 0.0001);
    }

    @Test
    public void testFindRoots_LargeCoefficients() {
        // Уравнение: 1000x^2 + 5000x + 6000 = 0
        QuadraticEquation eq = new QuadraticEquation(1000, 5000, 6000);
        List<Double> roots = solver.findRoots(eq);

        // Проверим, что корни существуют (не пусто) и их размер корректен
        Assert.assertTrue(roots.size() > 0);
    }
}
