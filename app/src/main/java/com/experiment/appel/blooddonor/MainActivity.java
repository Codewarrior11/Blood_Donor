package com.experiment.appel.blooddonor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findDonor(View view) {
        Intent intent=new Intent(MainActivity.this,FindDonor.class);
        startActivity(intent);

    }

    public void postRequ(View view) {

        Intent intent=new Intent(MainActivity.this,PostRequest.class);
        startActivity(intent);
    }

    public void addDonor(View view) {
        Intent intent=new Intent(MainActivity.this,AddDonor.class);
        startActivity(intent);

    }

    public void myAccount(View view) {
        Intent intent=new Intent(MainActivity.this,Account.class);
        startActivity(intent);

    }

    public void information(View view) {
        Intent intent=new Intent(MainActivity.this,Information.class);
        startActivity(intent);

    }

    public void aboutUs(View view) {
        Intent intent=new Intent(MainActivity.this,AboutUs.class);
        startActivity(intent);

    }
}
