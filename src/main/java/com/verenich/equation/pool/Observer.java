package com.verenich.equation.pool;

import com.verenich.equation.entity.QuadraticEquation;

public interface Observer {
    void update(QuadraticEquation equation);
}
