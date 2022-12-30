package com.simul.vision.simulations;

import com.simul.vision.event.EventSubscriber;

public abstract class Simulation<T> implements EventSubscriber {

    private final T controller;

    public Simulation(T controller) {
        this.controller = controller;
    }

    public void run() {
    }

}
