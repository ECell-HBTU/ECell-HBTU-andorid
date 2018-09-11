package com.example.arnav.ecellapplication;

public class Event {
    String event_title;
    String event_date;
    String event_timing;
    int eventImageId;

    Event(String event_title,String event_date,String event_timing,int eventImageId){
        this.event_title=event_title;
        this.event_date=event_date;
        this.event_timing=event_timing;
        this.eventImageId=eventImageId;
    }
}
