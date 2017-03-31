package com.example.asus.dept_management_apps;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class EmployeeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EmployeeClass empdb;
    EditText TvEName,TvERank,TvEMob,TvEEml,TvEAdrs;
    Button btnEsave,btnEedt,btnEshow;
    Spinner espin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        espin=(Spinner)findViewById(R.id.espin);
        empdb=new EmployeeClass(this);
        TvEName=(EditText)findViewById(R.id.TvEName);
        TvERank=(EditText)findViewById(R.id.TvERank);
        TvEMob=(EditText)findViewById(R.id.TvEMob);
        TvEEml=(EditText)findViewById(R.id.TvEEml);
        TvEAdrs=(EditText)findViewById(R.id.TvEAdrs);
        btnEsave=(Button)findViewById(R.id.btnEsave);
        btnEedt=(Button)findViewById(R.id.btnEedt);
        btnEshow=(Button)findViewById(R.id.btnEshow);
        espin.setOnItemSelectedListener(this);

        btnEsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


                String tkinp1 = TvEName.getText().toString();



                if (tkinp1.trim().length() > 0) {

                    empdb = new EmployeeClass(getApplicationContext());
                    empdb.insertLabel(tkinp1);



                    // making input filed text to blank
                    TvEName.setText("");

                    // Hiding the keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(TvEName.getWindowToken(), 0);


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
        espin.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String label = parent.getItemAtPosition(position).toString();


        TvEName.setText(label);
        TvERank.setText(label);


        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
