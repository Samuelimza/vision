package com.simul.vision.events;

public interface EventSubscriber {

    Class<? extends AppEvent> getEventClass();

    void handleEvent(AppEvent event);

}
