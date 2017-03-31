package com.example.asus.dept_management_apps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {
    Button Tchbtn,Stdbtn,Empbtn,Rtnbtn,Sembtn,Exmbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Tchbtn=(Button)findViewById(R.id.Tchbtn);
        Stdbtn=(Button)findViewById(R.id.Stdbtn);
        Empbtn=(Button)findViewById(R.id.Empbtn);
        Rtnbtn=(Button)findViewById(R.id.Rtnbtn);
        Sembtn=(Button)findViewById(R.id.Sembtn);
        Exmbtn=(Button)findViewById(R.id.Exmbtn);
        Tchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objtch=new Intent(UserActivity.this,UserTchActivity.class);
                startActivity(objtch);
            }
        });
        Stdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objstd=new Intent(UserActivity.this,UserStdntActivity.class);
                startActivity(objstd);
            }
        });

        Empbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objemp=new Intent(UserActivity.this,UserEmpActivity.class);
                startActivity(objemp);
            }
        });
        Rtnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objrtn=new Intent(UserActivity.this,UserRoutineActivity.class);
                startActivity(objrtn);
            }
        });

        Sembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objsem=new Intent(UserActivity.this,UserLibrActivity.class);
                startActivity(objsem);
            }
        });
        Exmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objexm=new Intent(UserActivity.this,ResultActivity.class);
                startActivity(objexm);
            }
        });


    }
}
