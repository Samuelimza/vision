package com.simul.vision.graphics;

import com.simul.vision.controllers.SimController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Screen {

    private final Canvas canvas;
    private final GraphicsContext context;
    private final int height;
    private final int width;

    public Screen(SimController controller) {
        this.canvas = controller.fetchCanvas();

        context = canvas.getGraphicsContext2D();
        width = (int) canvas.getWidth();
        height = (int) canvas.getHeight();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void clear() {
        context.clearRect(0, 0, width, height);
    }

    public void drawCircle(int x, int y, int r, Color color) {
        context.setFill(color);
        context.fillOval(x - r, y - r, 2 * r, 2 * r);
    }

}
