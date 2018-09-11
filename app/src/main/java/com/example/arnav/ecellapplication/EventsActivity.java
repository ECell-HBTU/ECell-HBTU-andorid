package com.example.arnav.ecellapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {
    private List<Event> events;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        RecyclerView rView=(RecyclerView)findViewById(R.id.eventList);
        rView.setHasFixedSize(true);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        rView.setLayoutManager(llm);

        initializeData();
        RViewAdapter adapter= new RViewAdapter(events);
        rView.setAdapter(adapter);

    }

    private void initializeData(){
        events=new ArrayList<>();

        events.add(new Event("Startup Boosting Workshop","1st Sept, 2018","11AM to 1PM",R.drawable.img));
        events.add(new Event("Talk on Waste Management and start-ups Q/A session","23rd Oct, 2018","5PM to 6PM",R.drawable.img));
        events.add(new Event("How to gain traction in the initial months?","11th Sept, 2018","10AM to 11AM",R.drawable.img));
    }
}
