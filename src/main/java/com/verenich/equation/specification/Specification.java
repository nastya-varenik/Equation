package com.verenich.equation.specification;

public interface Specification<T> {
    boolean isSatisfiedBy(T item);
}
