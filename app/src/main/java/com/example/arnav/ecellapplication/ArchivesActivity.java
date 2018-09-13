package com.example.arnav.ecellapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class ArchivesActivity extends AppCompatActivity{
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archives);

        recyclerView = findViewById(R.id.recycler_view);

        List<Event> events = new ArrayList<>();

        events.add(new Event("Startup Boosting Workshop","1st Sept, 2018","11AM to 1PM",R.mipmap.archive7));
        events.add(new Event("Talk on Waste Management and start-ups Q/A session","23rd Oct, 2018","5PM to 6PM",R.mipmap.archive8));
        events.add(new Event("How to gain traction in the initial months?","11th Sept, 2018","10AM to 11AM",R.mipmap.sample2));
        events.add(new Event("Pitching Workshop","12th Sept, 2018","10AM to 1PM",R.mipmap.sample3));
        events.add(new Event("Elevator Pitch","12th Sept, 2018","10AM to 1PM",R.mipmap.sample4));
        events.add(new Event("Start-up 101","12th Sept, 2018","10AM to 1PM",R.mipmap.sample1));
        events.add(new Event("Talk : 10 ways to gain investors attention!","12th Sept, 2018","10AM to 1PM",R.mipmap.sample3));
        events.add(new Event("Innovative Idea Competition","12th Sept, 2018","10AM to 1PM",R.mipmap.sample2));
        events.add(new Event("Start-up quiz","12th Sept, 2018","10AM to 1PM",R.mipmap.sample4));
        events.add(new Event("Talk:Things to keep in mind before pivoting","12th Sept, 2018","10AM to 1PM",R.drawable.ic_launcher));

        ArchiveImageAdapter adapter = new ArchiveImageAdapter(events);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }
}
