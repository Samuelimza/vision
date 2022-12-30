package com.simul.vision.event;

public interface EventSubscriber {

    Class<? extends AppEvent> getEventClass();

    void handleEvent(AppEvent event);

}
