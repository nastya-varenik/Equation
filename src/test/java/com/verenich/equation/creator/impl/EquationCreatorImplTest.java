package com.verenich.equation.creator.impl;

import com.verenich.equation.entity.QuadraticEquation;
import com.verenich.equation.creator.EquationCreator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

public class EquationCreatorImplTest {
    private EquationCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new EquationCreatorImpl();
    }

    @Test
    public void testCreateEquation_ValidCoefficients() {
        // Проверяем создание уравнения с валидными коэффициентами
        double a = 1, b = -5, c = 6;
        Optional<QuadraticEquation> equationOpt = creator.createEquation(a, b, c);

        // Проверяем, что Optional не пустой и уравнение создано правильно
        Assert.assertTrue(equationOpt.isPresent());
        QuadraticEquation equation = equationOpt.get();
        Assert.assertEquals(equation.getA(), a);
        Assert.assertEquals(equation.getB(), b);
        Assert.assertEquals(equation.getC(), c);
    }

    @Test
    public void testCreateEquation_ZeroA() {
        // Проверяем создание уравнения с нулевым коэффициентом 'a'
        double a = 0, b = 5, c = 6;
        Optional<QuadraticEquation> equationOpt = creator.createEquation(a, b, c);

        // Проверяем, что уравнение не создано, так как коэффициент 'a' не может быть равен нулю
        Assert.assertFalse(equationOpt.isPresent());
    }

    @Test
    public void testCreateEquation_ZeroB() {
        // Проверяем создание уравнения с нулевым коэффициентом 'b'
        double a = 1, b = 0, c = -4;
        Optional<QuadraticEquation> equationOpt = creator.createEquation(a, b, c);

        // Проверяем, что Optional не пустой и уравнение создано правильно
        Assert.assertTrue(equationOpt.isPresent());
        QuadraticEquation equation = equationOpt.get();
        Assert.assertEquals(equation.getA(), a);
        Assert.assertEquals(equation.getB(), b);
        Assert.assertEquals(equation.getC(), c);
    }

    @Test
    public void testCreateEquation_ZeroC() {
        // Проверяем создание уравнения с нулевым коэффициентом 'c'
        double a = 2, b = -3, c = 0;
        Optional<QuadraticEquation> equationOpt = creator.createEquation(a, b, c);

        // Проверяем, что Optional не пустой и уравнение создано правильно
        Assert.assertTrue(equationOpt.isPresent());
        QuadraticEquation equation = equationOpt.get();
        Assert.assertEquals(equation.getA(), a);
        Assert.assertEquals(equation.getB(), b);
        Assert.assertEquals(equation.getC(), c);
    }

    @Test
    public void testCreateEquation_InvalidCoefficients() {
        // Проверяем создание уравнения с невалидными коэффициентами (например, 'a' равен нулю)
        double a = 0, b = 0, c = 0;
        Optional<QuadraticEquation> equationOpt = creator.createEquation(a, b, c);

        // Уравнение не должно быть создано, так как коэффициент 'a' равен нулю
        Assert.assertFalse(equationOpt.isPresent());
    }

    @Test
    public void testCreateEquation_NegativeCoefficients() {
        // Проверяем создание уравнения с отрицательными коэффициентами
        double a = -1, b = 3, c = -2;
        Optional<QuadraticEquation> equationOpt = creator.createEquation(a, b, c);

        // Проверяем, что Optional не пустой и уравнение создано правильно
        Assert.assertTrue(equationOpt.isPresent());
        QuadraticEquation equation = equationOpt.get();
        Assert.assertEquals(equation.getA(), a);
        Assert.assertEquals(equation.getB(), b);
        Assert.assertEquals(equation.getC(), c);
    }
}
