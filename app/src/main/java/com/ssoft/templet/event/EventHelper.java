package com.ssoft.templet.event;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public class EventHelper {
    public static void register(Object subscriber){
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber){
        EventBus.getDefault().unregister(subscriber);
    }

    public static void post(Object event){
        EventBus.getDefault().post(event);
    }

    public static class TestEvent{


    }
    public static class Test2Event{

    }
}
