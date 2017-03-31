package com.example.asus.dept_management_apps;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class TeacherActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spin;
    EditText TvName,TvRank,TvMob,TvEml,TvAdrs,TvCrs;
    Button btnsave,btnedt,btnshow;
    TeacherClass db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        spin=(Spinner)findViewById(R.id.spin);

        TvName=(EditText)findViewById(R.id.TvName);
        TvRank=(EditText)findViewById(R.id.TvRank);
        TvMob=(EditText)findViewById(R.id.TvMob);
        TvEml=(EditText)findViewById(R.id.TvEml);
        TvAdrs=(EditText)findViewById(R.id.TvAdrs);
        TvCrs=(EditText)findViewById(R.id.TvCrs);
        btnsave=(Button)findViewById(R.id.btnsave);
        btnedt=(Button)findViewById(R.id.btnedt);
        btnshow=(Button)findViewById(R.id.btnshow);
        spin.setOnItemSelectedListener(this);
        loadSpinnerData();


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


                String tkinp1 = TvName.getText().toString();



                if (tkinp1.trim().length() > 0) {

                    db = new TeacherClass(getApplicationContext());
                    db.insertLabel(tkinp1);



                    // making input filed text to blank
                    TvName.setText("");

                    // Hiding the keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(TvName.getWindowToken(), 0);


                    // loading spinner with newly added data
                    loadSpinnerData();
                }





                    else {
                    Toast.makeText(getApplicationContext(), "Please enter label name", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }



    private void loadSpinnerData() {
        TeacherClass db = new  TeacherClass(getApplicationContext());
        List<String> labels = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spin.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String label = parent.getItemAtPosition(position).toString();


        TvName.setText(label);
        TvRank.setText(label);


        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
