package com.experiment.appel.blooddonor.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.experiment.appel.blooddonor.Donor;

import java.util.ArrayList;


public class DonorDatabaseManager {

    DatabaseHelper databaseHelper;

    public DonorDatabaseManager(Context context){

        databaseHelper=new DatabaseHelper(context);
    }

    public  long addDonor(Donor donor){

        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_DONOR_NAME,donor.getName());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_AGE,donor.getAge());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_GENDER,donor.getGender());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_ADDRESS,donor.getAddress());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_CONTACT_NO,donor.getContactNo());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_BLOOD_GROUP,donor.getBloodGroup());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_LAST_DONATION_DATE,donor.getLastDonationDate());

        long insertedRow=sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return insertedRow;
    }

    public ArrayList<Donor> getAllDonors() {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        ArrayList<Donor> donors = new ArrayList<>();
        String selectQuery = "select * from " + DatabaseHelper.TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_ID));
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_NAME));
                String age = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_AGE));
                String gender = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_GENDER));
                String address = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_ADDRESS));
                String contactNo = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_CONTACT_NO));
                String bloodGroup = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_BLOOD_GROUP));
                String lastDonationDate = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_LAST_DONATION_DATE));
                Donor donor = new Donor(id, name, age, gender, address, contactNo, bloodGroup, lastDonationDate);
                donors.add(donor);
            } while (cursor.moveToNext());
        }
        return donors;
    }
public long updateDonor(Donor donor){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_DONOR_NAME,donor.getName());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_AGE,donor.getAge());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_GENDER,donor.getGender());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_ADDRESS,donor.getAddress());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_CONTACT_NO,donor.getContactNo());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_BLOOD_GROUP,donor.getBloodGroup());
        contentValues.put(DatabaseHelper.COLUMN_DONOR_LAST_DONATION_DATE,donor.getLastDonationDate());
        long updatedRow=sqLiteDatabase.update(DatabaseHelper.TABLE_NAME,contentValues,
                DatabaseHelper.COLUMN_DONOR_ID+" =? ",new String[]{String.valueOf(donor.getId())});
        return updatedRow;
    }

    public Donor getDonorById(int id){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getReadableDatabase();
        String selectQuery="select * from "+DatabaseHelper.TABLE_NAME
                +" where id = "+id;
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);
        Donor donor=null;
        if(cursor.moveToFirst()){
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_NAME));
            String age = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_AGE));
            String gender = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_GENDER));
            String address = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_ADDRESS));
            String contactNo = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_CONTACT_NO));
            String bloodGroup = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_BLOOD_GROUP));
            String lastDonationDate = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DONOR_LAST_DONATION_DATE));
            donor=new Donor(id,name,age,gender,address,contactNo,bloodGroup,lastDonationDate);
        }
        return donor;
    }

    public long deleteDonor(int id){
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
        long deletedRow=sqLiteDatabase.delete(DatabaseHelper.TABLE_NAME,DatabaseHelper.COLUMN_DONOR_ID+" =? ",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
        return deletedRow;
    }

}
