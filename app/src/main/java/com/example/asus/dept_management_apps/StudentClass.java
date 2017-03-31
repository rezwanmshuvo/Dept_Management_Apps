package com.example.asus.dept_management_apps;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ASUS on 3/31/2017.
 */
public class StudentClass extends SQLiteOpenHelper {

    public static final String DBName="Students.db";
    public static final String TableName="StdTabl.db";

    public static final String Col_Srl="Serial";

    public static final String Col_Name="Name";
    public static final String Col_Id="ID";
    public static final String Col_Sem="Semister";
    public static final String Col_Cgpa="Cgpa";
    public static final String Col_Mob="Mob";
    public static final String Col_Eml="Email";
    public static final String Col_Adrs="Adress";



    public StudentClass(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" create table "+TableName+ "(Serial INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT,ID TEXT,Semister TEXT,Cgpa TEXT,Mob TEXT,Email TEXT,Adress TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TableName);
        onCreate(db);

    }
    public boolean insInfo(String nm,String id,String sems,String cgp,String mob,String eml,String adrs){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_Name,nm);
        contentValues.put(Col_Id,id);
        contentValues.put(Col_Sem,sems);
        contentValues.put(Col_Cgpa,cgp);
        contentValues.put(Col_Mob,mob);
        contentValues.put(Col_Eml,eml);
        contentValues.put(Col_Adrs,adrs);
        long result=db.insert(TableName,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }
}
