package com.example.arnav.ecellapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.arnav.ecellapplication.swipeView.TeamAdapter;

public class TeamActivity extends AppCompatActivity {
    ListView list;

    RecyclerView heads,members;
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

        heads = findViewById(R.id.heads_recycler_view);
        members = findViewById(R.id.members_recycler_view);

        TeamAdapter adapter = new TeamAdapter();

        heads.setAdapter(adapter);
        heads.setLayoutManager(new GridLayoutManager(this,4));

        members.setAdapter(adapter);
        members.setLayoutManager(new GridLayoutManager(this,6));

/*
        TeamList adapter=new TeamList(this, maintitle, subtitle,imgid);
        list=findViewById(R.id.list);
        list.setAdapter(adapter);*/
    }
}