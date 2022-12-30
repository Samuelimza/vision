package com.simul.vision.simulations;

import com.simul.vision.controllers.FxController;
import com.simul.vision.events.EventSubscriber;

public abstract class Simulation implements EventSubscriber {

    private final FxController controller;

    public Simulation(FxController controller) {
        this.controller = controller;
    }

    public void run() {
    }

}
