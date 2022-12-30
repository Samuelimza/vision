package com.simul.vision.events;

import com.simul.vision.utils.ListUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
Event subscription is currently supported for one event type.
Event types are separated for different applications, hence events from
one application will not be listened for in another application.
 */
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

    public boolean subscribe(EventSubscriber subscriber) {
        if (subscriber == null) {
            return false;
        }

        Class<? extends AppEvent> classOfEvent = subscriber.getEventClass();

        List<EventSubscriber> subscribers = subscriberMap.getOrDefault(classOfEvent, new ArrayList<>());
        subscribers.add(subscriber);

        subscriberMap.put(classOfEvent, subscribers);
        return true;
    }

    public boolean fireEvent(AppEvent event) {
        if (event == null) {
            return false;
        }

        List<EventSubscriber> subscribers = subscriberMap.get(event.getClass());
        if (ListUtils.isInValid(subscribers)) {
            return false;
        }

        boolean allSubscribersFired = true;
        for (EventSubscriber subscriber : subscribers) {
            try {
                subscriber.handleEvent(event);
            } catch (Exception e) {
                System.out.println("Exception in event handling");
                e.printStackTrace();
                allSubscribersFired = false;
            }
        }

        return allSubscribersFired;
    }
}
