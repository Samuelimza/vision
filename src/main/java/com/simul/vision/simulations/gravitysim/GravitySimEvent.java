package com.simul.vision.simulations.gravitysim;

import com.simul.vision.event.AppEvent;

public class GravitySimEvent implements AppEvent {

    public static final GravitySimEvent STOP_EVENT = new GravitySimEvent(GravitySimEventType.STOP);

    private final GravitySimEventType type;

    public GravitySimEvent(GravitySimEventType type) {
        this.type = type;
    }

    public GravitySimEventType getType() {
        return type;
    }

}
