package com.example.arnav.ecellapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EventDetailActivity extends AppCompatActivity {
    private String eventTitle=null;
    private int eventImageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
/*

        Bundle extras=getIntent().getExtras();

        if(extras!=null){
            eventTitle=extras.getString("EVENT_TITLE");
            eventImageId=extras.getInt("EVENT_IMAGE_ID");
        }

        TextView titleBox= findViewById(R.id.event_title);
        ImageView imageBox= findViewById(R.id.event_image);

        titleBox.setText(eventTitle);
        imageBox.setBackground(getResources().getDrawable(eventImageId));*/

    }
    @Override
    protected void onStart(){
        super.onStart();
        setRegisterButtonLook();
    }

    public void setRegisterButtonLook() {
        /*SharedPreferences sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);

        if (sharedPreferences.getString("events", null) != null) {
            if (sharedPreferences.getString("events", null).contains(eventTitle)) {
                Button registerBtn=findViewById(R.id.register_button);

                registerBtn.setText(R.string.registered);
                registerBtn.setBackgroundColor(getResources().getColor(R.color.green));
                registerBtn.setClickable(false);
            }
        }*/

    }

    public void backToEventsActivity(View v){
       onBackPressed();
    }

    public void toRegistrationActivity(View v){
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);

        if(sharedPreferences.getString("userName",null)==null) {
            Intent intent = new Intent(this, RegistrationActivity.class);
            intent.putExtra("EVENT_TITLE", eventTitle);
            startActivity(intent);
        }else{
            SharedPreferences.Editor editor=sharedPreferences.edit();

            String eventsTillNow=sharedPreferences.getString("events",null);

            editor.putString("events",eventsTillNow+eventTitle+",");

            editor.apply();

            setRegisterButtonLook();
            Toast.makeText(this,"Registered Successfully!",Toast.LENGTH_LONG).show();

        }
    }
}
