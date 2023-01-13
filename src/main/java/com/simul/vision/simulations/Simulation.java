package com.simul.vision.simulations;

import com.simul.vision.RunnableTask;
import com.simul.vision.events.EventSubscriber;

/*
Design decision of a simulation:
  -- Simulation start with a controller having a drawable canvas.
  -- it creates a screen out of it.
  -- Rendering inside the simulation is handled by the screen.
  -- Fetching inputs is done directly from the controller.
 */
public abstract class Simulation implements RunnableTask, EventSubscriber {

    private boolean running = false;
    private Thread thread;

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                updates++;
                delta--;

                render();
                frames++;
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }
        }
    }

    @Override
    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected abstract void update();

    protected abstract void render();
}
