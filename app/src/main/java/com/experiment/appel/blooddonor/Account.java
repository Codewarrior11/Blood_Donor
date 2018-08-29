package com.experiment.appel.blooddonor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Account extends AppCompatActivity {
    Button call,update,delete,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view);

        call=findViewById(R.id.call);
        update=findViewById(R.id.updateBtn);
        delete=findViewById(R.id.deleteBtn);

        final int position=Integer.parseInt(getIntent().getStringExtra("position"));
        final String phoneNumber=getIntent().getStringExtra("phone");

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Account.this,""+position,Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Account.this,""+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
