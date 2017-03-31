package com.example.asus.dept_management_apps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 3/31/2017.
 */
public class EmployeeClass extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "employee";
    private static final String TABLE_NAME2 = "emplist";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_Rank = "rank";
    private static final String COLUMN_Mob = "mob";
    private static final String COLUMN_Email = "email";
    private static final String COLUMN_Adress = "adress";

    public EmployeeClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_NAME2 + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT,"+COLUMN_Rank+" TEXT,"
                +COLUMN_Mob+" TEXT," +COLUMN_Email+" TEXT,"+COLUMN_Adress+" TEXT)";
        db.execSQL(CREATE_ITEM_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);

        // Create tables again
        onCreate(db);

    }
    public void insertLabel(String nm){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, nm);//column name, column value
       /* values.put(COLUMN_Rank, rnk);//column name, column value
        values.put(COLUMN_Mob, mbn);//column name, column value
        values.put(COLUMN_Email, eml);//column name, column value
        values.put(COLUMN_Adrs, adr);//column name, column value
        values.put(COLUMN_Course, crse);//column name, column value*/

        // Inserting Row
        db.insert(TABLE_NAME2, null, values);//tableName, nullColumnHack, CotentValues
        db.close(); // Closing database connection
    }
    public List<String> getAllLabels(){
        List<String> list = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME2;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);//selectQuery,selectedArguments

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));//adding 2nd column data
            } while (cursor.moveToNext());
        }
        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return list;
    }



}
