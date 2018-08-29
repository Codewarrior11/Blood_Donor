package com.experiment.appel.blooddonor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Account extends AppCompatActivity {
    Button callbtn;
    Button updateBtn;
    Button deleteBtn;
    Button emailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view);

        callbtn=findViewById(R.id.callBtn);
        updateBtn=findViewById(R.id.updateBtn);
        deleteBtn=findViewById(R.id.deleteBtn);
        emailBtn=findViewById(R.id.emailBtn);

        final String phoneNumber=getIntent().getStringExtra("phone");
        final int position=getIntent().getIntExtra("position",1);

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Account.this,""+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
