package com.experiment.appel.blooddonor;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.experiment.appel.blooddonor.database.DonorDatabaseManager;

import java.util.Calendar;

public class AddDonor extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    DonorDatabaseManager donorDatabaseManager;
    Spinner bg, address;
    Button btnDatePicker, save, cancel, update;
    EditText name, age, contactNo, txtDate;
    RadioGroup gender;
    RadioButton radioButton;
    private int dYear, dMonth, dDay;
    private String bgValue, addressValue, genderValue;
    String[] bgList = {"B+", "B-", "A+", "A-", "AB+", "AB-", "O+", "O-"};
    String[] locList = {"Dhanmonddi", "Azimpur", "Mohammadpur", "Shamoli", "Shahbag", "Mirpur", "Uttara", "Gulshan"};
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donor);

        name = (EditText) findViewById(R.id.nameET);
        age = (EditText) findViewById(R.id.ageET);
        contactNo = (EditText) findViewById(R.id.contactET);
        gender = (RadioGroup) findViewById(R.id.genderRG);
        txtDate = findViewById(R.id.donDateET);
        bg = findViewById(R.id.dbg);
        address = findViewById(R.id.locationList);
        btnDatePicker = findViewById(R.id.datePickBtn);
        btnDatePicker.setOnClickListener(this);

        save = findViewById(R.id.saveBtn);
        cancel = findViewById(R.id.cancelBtn);
        update = findViewById(R.id.updateBtn);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                                              @Override
                                              public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                  radioButton = (RadioButton) findViewById(checkedId);
                                                  genderValue = (String) radioButton.getText().toString();
                                                  Toast.makeText(getBaseContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();
                                              }
                                          }
        );

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bgList);
        ArrayAdapter bb = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locList);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bg.setAdapter(aa);
        address.setAdapter(bb);

        bg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                bgValue = (String) bg.getSelectedItem();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        address.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                addressValue =(String) address.getSelectedItem();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        donorDatabaseManager = new DonorDatabaseManager(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        final Calendar c = Calendar.getInstance();
        dYear = c.get(Calendar.YEAR);
        dMonth = c.get(Calendar.MONTH);
        dDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        txtDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                    }
                }, dYear, dMonth, dDay);
        datePickerDialog.show();

    }

    public void saveDonorInfo(View view) {
        Donor donor = new Donor(name.getText().toString(), age.getText().toString(), genderValue, addressValue, contactNo.getText().toString(), bgValue, txtDate.getText().toString());
        long test = donorDatabaseManager.addDonor(donor);
        if (test > 0) {
            Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show();
            intent = new Intent(AddDonor.this, FindDonor.class);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show();

        }
    }

    public void updateDonorInfo(View view) {

    }

    public void cancelReg(View view) {
        Intent intent=new Intent(AddDonor.this,MainActivity.class);
         startActivity(intent);
         finish();

    }
}
