package com.simul.vision.simulations.gravitysim;

import com.simul.vision.controllers.GravityController;
import com.simul.vision.event.AppEvent;
import com.simul.vision.event.EventHandler;
import com.simul.vision.simulations.Simulation;

public class GravitySimulation extends Simulation<GravityController> {

    private boolean stopped = false;

    public GravitySimulation(GravityController controller) {
        super(controller);
        EventHandler.getInstance().subscribe(this);
    }

    @Override
    public void run() {
        System.out.println("Started gravity simulation");
    }

    @Override
    public void handleEvent(AppEvent event) {
        if (!(event instanceof GravitySimEvent)) {
            return;
        }

        GravitySimEvent gravitySimEvent = (GravitySimEvent) event;

        switch (gravitySimEvent.getType()) {
            case STOP:
                handleStop();
                break;
            default:
                return;
        }
    }

    @Override
    public Class<? extends AppEvent> getEventClass() {
        return GravitySimEvent.class;
    }

    private void handleStop() {
        stopped = !stopped;
        System.out.println("Sim stopped: " + stopped);
    }

}
