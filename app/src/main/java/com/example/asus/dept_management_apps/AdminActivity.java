package com.example.asus.dept_management_apps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {
    Button Tchbtn,Stdbtn,Empbtn,Rtnbtn,Sembtn,Exmbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Tchbtn=(Button)findViewById(R.id.Tchbtn);
        Stdbtn=(Button)findViewById(R.id.Stdbtn);
        Empbtn=(Button)findViewById(R.id.Empbtn);
        Rtnbtn=(Button)findViewById(R.id.Rtnbtn);
        Sembtn=(Button)findViewById(R.id.Sembtn);
        Exmbtn=(Button)findViewById(R.id.Exmbtn);

        Tchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objtch=new Intent(AdminActivity.this,TeacherActivity.class);
                startActivity(objtch);
            }
        });
        Stdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objstd=new Intent(AdminActivity.this,StudentActivity.class);
                startActivity(objstd);
            }
        });

        Empbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objemp=new Intent(AdminActivity.this,EmployeeActivity.class);
                startActivity(objemp);
            }
        });
        Rtnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objrtn=new Intent(AdminActivity.this,RoutineActivity.class);
                startActivity(objrtn);
            }
        });

        Sembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objsem=new Intent(AdminActivity.this,LibraryActivity.class);
                startActivity(objsem);
            }
        });
        Exmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent objexm=new Intent(AdminActivity.this,ExamActivity.class);
                startActivity(objexm);
            }
        });




    }
}
