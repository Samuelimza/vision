package com.simul.vision.events;

import com.simul.vision.events.enums.GravitySimEventType;
import org.junit.Test;

public class EventHandlerTest {

    @Test
    public void testSubscription() {
        boolean subscribed = EventHandler.getInstance().subscribe(null);
        assert !subscribed;

        EventSubscriber subscriber = new EventSubscriber() {
            @Override
            public Class<? extends AppEvent> getEventClass() {
                return GravitySimEvent.class;
            }

            @Override
            public void handleEvent(AppEvent event) {
            }
        };

        subscribed = EventHandler.getInstance().subscribe(subscriber);
        assert subscribed;
    }

    @Test
    public void testEventFiring() {
        boolean allSubscribersFired = EventHandler.getInstance().fireEvent(null);
        assert !allSubscribersFired;

        allSubscribersFired = EventHandler.getInstance().fireEvent(new GravitySimEvent(GravitySimEventType.STOP));
        assert !allSubscribersFired;

        EventSubscriber successSubscriber = new EventSubscriber() {
            @Override
            public Class<? extends AppEvent> getEventClass() {
                return GravitySimEvent.class;
            }

            @Override
            public void handleEvent(AppEvent event) {
            }
        };
        EventHandler.getInstance().subscribe(successSubscriber);

        allSubscribersFired = EventHandler.getInstance().fireEvent(new GravitySimEvent(GravitySimEventType.STOP));
        assert allSubscribersFired;

        EventSubscriber failureSubscriber = new EventSubscriber() {
            @Override
            public Class<? extends AppEvent> getEventClass() {
                return GravitySimEvent.class;
            }

            @Override
            public void handleEvent(AppEvent event) {
                throw new RuntimeException("Exception in subscriber event handler");
            }
        };
        EventHandler.getInstance().subscribe(failureSubscriber);

        allSubscribersFired = EventHandler.getInstance().fireEvent(new GravitySimEvent(GravitySimEventType.STOP));
        assert !allSubscribersFired;
    }

}