package com.example.arnav.ecellapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class TeamActivity extends AppCompatActivity {
    ListView list;

    String[] maintitle ={
            "Harshit Tripathi","Vishal Gupta",
            "Arnav Srivastava","Praful Chauhan",
            "Tanul Singh", "Puru Bhatnagar", "Kartikeya Jain","Naman Kumar","Mohit Ojha","Rishu Trivedi", "Sonia Malik"
    };

    String[] subtitle ={
            "PRESIDENT","VICE-PRESIDENT",
            "WEB AND APP DEVELOPMENT","HOSPITALITY",
            "EVENTS","MARKETING", "FINANCE","LOGISTICS","PUBLICITY","DESIGN","CONTENT WRITING"
    };

    Integer[] imgid={
            R.mipmap.harshit_sir_min,R.mipmap.vishal_sir_min,
            R.mipmap.arnav_sir_min,R.mipmap.praful_sir_min,
            R.mipmap.tanul_sir_min, R.mipmap.puru_sir_min, R.mipmap.kartikey_sir_min, R.mipmap.naman_sir_min, R.mipmap.mohit_sir_min, R.mipmap.rishu_sir_min, R.mipmap.sonia_mam_min
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        TeamList adapter=new TeamList(this, maintitle, subtitle,imgid);
        list=findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}