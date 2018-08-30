package com.experiment.appel.blooddonor.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {

    public static  final String DATABASE_NAME="donor_db";
    public static final int DATABASE_VERSION=1;
    public  static final String TABLE_NAME="donor";

    public static final String COLUMN_DONOR_ID="id";
    public static final String COLUMN_DONOR_NAME="name";
    public static final String COLUMN_DONOR_AGE="age";
    public static final String COLUMN_DONOR_GENDER="gender";
    public static final String COLUMN_DONOR_ADDRESS="address";
    public static final String COLUMN_DONOR_CONTACT_NO="contactNo";
    public static final String COLUMN_DONOR_BLOOD_GROUP="bloodGroup";
    public static final String COLUMN_DONOR_LAST_DONATION_DATE="lastDonationDate";

    public static final String CREATE_DONOR_QUERY="create table "+TABLE_NAME
            +"("+COLUMN_DONOR_ID+" integer primary key autoincrement,"
            +COLUMN_DONOR_NAME+" text,"
            +COLUMN_DONOR_AGE+" text,"
            +COLUMN_DONOR_GENDER+" text,"
            +COLUMN_DONOR_ADDRESS+" text,"
            + COLUMN_DONOR_CONTACT_NO+" text,"
            +COLUMN_DONOR_BLOOD_GROUP+" text,"
            +COLUMN_DONOR_LAST_DONATION_DATE+" text);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DONOR_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
