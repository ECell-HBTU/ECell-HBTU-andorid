package com.example.arnav.ecellapplication;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class EventCard {
    public String name;
    public String city;
    public String url;
    public Drawable img;

    public EventCard(String name, String city, Drawable img, String url) {
        this.name = name;
        this.city = city;
        this.img = img;
        this.url = url;//this for later use when we actually supply pictures from database using urls perhaps
    }
}
