package com.simul.vision.simulations;

import com.simul.vision.controllers.GravitySimController;
import com.simul.vision.events.AppEvent;
import com.simul.vision.events.EventHandler;
import com.simul.vision.events.GravitySimEvent;

public class GravitySimulation extends Simulation {

    private boolean stopped = false;

    public GravitySimulation(GravitySimController controller) {
        super(controller);
        EventHandler.getInstance().subscribe(this);
    }

    @Override
    public void run() {
        System.out.println("Started gravity simulation");
    }

    @Override
    public void handleEvent(AppEvent event) {
        if (!(event instanceof GravitySimEvent gravitySimEvent)) {
            return;
        }

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
