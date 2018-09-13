package com.example.arnav.ecellapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    private String eventTitle=null;
    private EditText nameBox;
    private EditText emailBox;
    private Spinner branchDropDown;
    private Spinner yearDropDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Bundle extras=getIntent().getExtras();

        if(extras!=null){
            eventTitle=extras.getString("EVENT_TITLE");
        }

        branchDropDown=findViewById(R.id.branch);
        yearDropDown=findViewById(R.id.year);
        nameBox=findViewById(R.id.name);
        emailBox=findViewById(R.id.emailid);

        String branches[]={"Computer Sc. & Engg.","Information Technology","Mechanical Engineering","Electrical Engineering",
                           "Electronics Engineering","Civil Engineering","Chemical Engineering","Plastic Technology",
                           "Paint Technology", "Biochemical Engineering","Food Technology","Oil Technology","Leather Technology"};

        String years[]={"Fresher","Second","Third","Final"};

        displayDropdown(branches,branchDropDown);
        displayDropdown(years,yearDropDown);

    }



    public void displayDropdown(String[] array,Spinner spinner){
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,array);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
    }

    public void saveRegistrationDetails(View v){
        SharedPreferences sharedPreferences=getSharedPreferences("userInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        String eventsTillNow=sharedPreferences.getString("events",null);

        editor.putString("userName",nameBox.getText().toString());
        editor.putString("userEmail",emailBox.getText().toString());
        editor.putString("userBranch",branchDropDown.getSelectedItem().toString());
        editor.putString("userYear",yearDropDown.getSelectedItem().toString());
        editor.putString("events",eventsTillNow+eventTitle+",");

        editor.apply();
        Toast.makeText(this,"Registered Successfully!",Toast.LENGTH_LONG).show();

        Intent intent=new Intent(this,EventsActivity.class);
        startActivity(intent);
    }
}
