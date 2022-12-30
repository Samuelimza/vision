package com.simul.vision.events;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EventHandler {

    public static EventHandler instance;

    private Map<Class<? extends AppEvent>, List<EventSubscriber>> subscriberMap;

    public static EventHandler getInstance() {
        if (instance == null) {
            instance = new EventHandler();
        }

        return instance;
    }

    private EventHandler() {
        this.subscriberMap = new LinkedHashMap<>();
    }

    public void subscribe(EventSubscriber subscriber) {
        if (subscriber == null) {
            return;
        }

        Class<? extends AppEvent> classOfEvent = subscriber.getEventClass();

        List<EventSubscriber> subscribers = subscriberMap.getOrDefault(classOfEvent, new ArrayList<>());
        subscribers.add(subscriber);

        subscriberMap.put(classOfEvent, subscribers);
    }

    public void fireEvent(AppEvent event) {
        if (event == null) {
            return;
        }

        List<EventSubscriber> subscribers = subscriberMap.get(event.getClass());
        for (EventSubscriber subscriber : subscribers) {
            subscriber.handleEvent(event);
        }
    }
}
