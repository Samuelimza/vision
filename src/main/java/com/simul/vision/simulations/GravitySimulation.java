package com.simul.vision.simulations;

import com.simul.vision.controllers.GravitySimController;
import com.simul.vision.events.AppEvent;
import com.simul.vision.events.EventHandler;
import com.simul.vision.events.GravitySimEvent;
import com.simul.vision.graphics.Screen;
import javafx.scene.paint.Color;

public class GravitySimulation extends Simulation {

    private final GravitySimController controller;
    private Screen screen;

    private int upsCounter = 0;

    public GravitySimulation(GravitySimController controller) {
        this.controller = controller;
        EventHandler.getInstance().subscribe(this);

        screen = new Screen(controller);
        setup();
    }

    private void setup() {
    }

    @Override
    public void handleEvent(AppEvent event) {
        if (!(event instanceof GravitySimEvent gravitySimEvent)) {
            return;
        }

        switch (gravitySimEvent.getType()) {
            case STOP:
                System.out.println("Stop received for Gravity sim");
                break;
            default:
                return;
        }
    }

    @Override
    public Class<? extends AppEvent> getEventClass() {
        return GravitySimEvent.class;
    }

    @Override
    protected void update() {
        upsCounter++;
    }

    @Override
    protected void render() {
        screen.clear();
        screen.drawCircle(0, 0, 20, Color.YELLOW);
        screen.drawCircle(screen.getWidth(), screen.getHeight(), 20, Color.YELLOW);
        screen.drawCircle(upsCounter % 100, 60, 30, Color.BLUE);
    }

}
