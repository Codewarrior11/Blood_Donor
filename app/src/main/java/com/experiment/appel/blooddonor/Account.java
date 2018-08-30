package com.experiment.appel.blooddonor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Account extends AppCompatActivity {
    Button callbtn;
    Button updateBtn;
    Button deleteBtn;

    TextView bloodGroup,age1,phone1,adress1,name1,donationDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view);

        callbtn=findViewById(R.id.callBtn);
        updateBtn=findViewById(R.id.updateBtn);
        deleteBtn=findViewById(R.id.deleteBtn);

        age1=findViewById(R.id.age);
        bloodGroup=findViewById(R.id.dbg);
        phone1=findViewById(R.id.phone);

        name1=findViewById(R.id.profileName);
        adress1=findViewById(R.id.address);
        donationDate=findViewById(R.id.donationDate);

        final String phoneNumber=getIntent().getStringExtra("dphone");


        //below(position) variable for id
        final int position=getIntent().getIntExtra("dposition",1);
        String name=getIntent().getStringExtra("dname");
        String age=getIntent().getStringExtra("dage");
        String address=getIntent().getStringExtra("daddress");
        String bgroup=getIntent().getStringExtra("dbgroup");
        String ddate=getIntent().getStringExtra("dlastdonation");
        //String gender=getIntent().getStringExtra("gender");

        bloodGroup.setText(bgroup);
        age1.setText(age);
        name1.setText(name);
        adress1.setText(address);
        donationDate.setText("Last Donation: "+ddate);

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });

        //For update and delete

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Account.this,""+position,Toast.LENGTH_SHORT).show();
            }
        });


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
