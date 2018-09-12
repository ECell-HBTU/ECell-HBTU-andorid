package com.example.arnav.ecellapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailActivity extends AppCompatActivity {
    private String eventTitle=null;
    private int eventImageId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        Bundle extras=getIntent().getExtras();

        if(extras!=null){
            eventTitle=extras.getString("EVENT_TITLE");
            eventImageId=extras.getInt("EVENT_IMAGE_ID");
        }
        System.out.println("idddd: "+eventImageId);
        TextView title= findViewById(R.id.event_title);
        ImageView image= findViewById(R.id.event_image);

        title.setText(eventTitle);
        image.setBackground(getResources().getDrawable(eventImageId));

    }

    public void backToEventsActivity(View v){
        Intent intent=new Intent(this,EventsActivity.class);
        startActivity(intent);
    }
}
