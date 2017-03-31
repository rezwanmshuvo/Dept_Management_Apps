package com.example.asus.dept_management_apps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {
    EditText TvName,TvId,TvSem,TvRslt,TvMob,TvEml,TvAdrs;
    Button btnsave,btnedt,btnshow;
    StudentClass mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        mydb=new StudentClass(this);
        TvName=(EditText)findViewById(R.id.TvName);
        TvId=(EditText)findViewById(R.id.TvId);
        TvSem=(EditText)findViewById(R.id.TvSem);
        TvRslt=(EditText)findViewById(R.id.TvRslt);
        TvMob=(EditText)findViewById(R.id.TvMob);
        TvAdrs=(EditText)findViewById(R.id.TvAdrs);
        TvEml=(EditText)findViewById(R.id.TvEml);

        btnsave=(Button)findViewById(R.id.btnsave);
        btnedt=(Button)findViewById(R.id.btnedt);
        btnshow=(Button)findViewById(R.id.btnshow);


        AddData();
    }

    public void AddData(){
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean inserted= mydb.insInfo(TvName.getText().toString(),TvId.getText().toString(),TvSem.getText().toString(),
                        TvRslt.getText().toString(),TvMob.getText().toString(),TvEml.getText().toString(),TvAdrs.getText().toString());

         if(inserted==true)
             Toast.makeText(StudentActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                else
             Toast.makeText(StudentActivity.this, "Not Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
