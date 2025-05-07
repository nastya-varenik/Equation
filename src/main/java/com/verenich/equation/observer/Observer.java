package com.verenich.equation.observer;

import com.verenich.equation.entity.QuadraticEquation;

public interface Observer {
    void update(QuadraticEquation equation);
}
