package com.verenich.equation.entity;

public class QuadraticEquation {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public EquationState getState() {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return EquationState.NO_REAL_ROOTS;
        } else if (discriminant == 0) {
            return EquationState.ONE_REAL_ROOT;
        } else {
            return EquationState.TWO_REAL_ROOTS;
        }
    }

    public int getRootCount() {
        double discriminant = getDiscriminant();
        if (discriminant > 0) {
            return 2; // два корня
        } else if (discriminant == 0) {
            return 1; // один корень
        } else {
            return 0; // нет корней
        }
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QuadraticEquation other = (QuadraticEquation) obj;
        return (a == other.a &&
                b == other.b &&
                c == other.c);
    }

    @Override
    public int hashCode() {
        int result = 17;
        long temp;

        temp = Double.doubleToLongBits(a);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuadraticEquation {");
        sb.append("a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append('}');
        return sb.toString();
    }
}
