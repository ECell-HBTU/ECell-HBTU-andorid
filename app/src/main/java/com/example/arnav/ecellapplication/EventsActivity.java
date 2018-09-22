package com.example.arnav.ecellapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {
    private List<Event> events;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        RecyclerView rView= findViewById(R.id.eventList);
        rView.setHasFixedSize(true);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        rView.setLayoutManager(llm);

        initializeData();
        RViewAdapter adapter= new RViewAdapter(events,this);
        rView.setAdapter(adapter);

        /*adapter.setOnItemClickListener(new RViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String title=events.get(position).event_title;
                int imageID=events.get(position).eventImageId;

                Intent intent=new Intent(context,EventDetailActivity.class);
                intent.putExtra("EVENT_IMAGE_ID",imageID);
                intent.putExtra("EVENT_TITLE",title);
                startActivity(intent);

            }
        });*/

    }

    private void initializeData(){
        events=new ArrayList<>();

        events.add(new Event("Startup Boosting Workshop","1st Sept, 2018","11AM to 1PM",R.mipmap.event1));
        events.add(new Event("Talk on Waste Management and start-ups Q/A session","23rd Oct, 2018","5PM to 6PM",R.mipmap.event4));
        events.add(new Event("How to gain traction in the initial months?","11th Sept, 2018","10AM to 11AM",R.mipmap.event2));
        events.add(new Event("Pitching Workshop","12th Sept, 2018","10AM to 1PM",R.mipmap.event7));
        events.add(new Event("Elevator Pitch","12th Sept, 2018","10AM to 1PM",R.mipmap.event5));
        events.add(new Event("Start-up 101","12th Sept, 2018","10AM to 1PM",R.mipmap.event6));
        events.add(new Event("Talk : 10 ways to gain investors attention!","12th Sept, 2018","10AM to 1PM",R.mipmap.event7));
        events.add(new Event("Innovative Idea Competition","12th Sept, 2018","10AM to 1PM",R.mipmap.event8));
        events.add(new Event("Start-up quiz","12th Sept, 2018","10AM to 1PM",R.mipmap.event1));
        events.add(new Event("Talk:Things to keep in mind before pivoting","12th Sept, 2018","10AM to 1PM",R.mipmap.event2));
        events.add(new Event("Pitching Workshop","12th Sept, 2018","10AM to 1PM",R.mipmap.event6));
        events.add(new Event("Elevator Pitch","12th Sept, 2018","10AM to 1PM",R.mipmap.event5));
    }

}
