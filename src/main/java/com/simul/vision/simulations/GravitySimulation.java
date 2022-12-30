package com.simul.vision.simulations;

import com.simul.vision.controllers.GravitySimController;
import com.simul.vision.events.AppEvent;
import com.simul.vision.events.EventHandler;
import com.simul.vision.events.GravitySimEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;

public class GravitySimulation extends Simulation {

    private final GravitySimController controller;
    private final int WIDTH;
    private final int HEIGHT;

    private int[] pixelsBuffer;

    public GravitySimulation(GravitySimController controller) {
        this.controller = controller;
        EventHandler.getInstance().subscribe(this);

        WIDTH = (int) controller.canvas.getWidth();
        HEIGHT = (int) controller.canvas.getHeight();
        setup();
    }

    private void setup() {
        pixelsBuffer = new int[WIDTH * HEIGHT];
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

    }

    @Override
    protected void render() {
        Canvas canvas = controller.canvas;
        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (int i = 0; i < pixelsBuffer.length; i++) {
            pixelsBuffer[i] = (i % 256) | ((i % 256) << 8) | ((i % 256) << 16) | (0xff << 24);
        }

        PixelWriter pixelWriter = gc.getPixelWriter();
        pixelWriter.setPixels(0, 0, 300, 300, PixelFormat.getIntArgbInstance(), pixelsBuffer, 0, 300);
    }

}
