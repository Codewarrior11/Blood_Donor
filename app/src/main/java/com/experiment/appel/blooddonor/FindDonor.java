package com.experiment.appel.blooddonor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FindDonor extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_donor);

        listView=findViewById(R.id.donor_list_data);
        ArrayList<Donor>arrayList=new ArrayList<>();
        arrayList.add(new Donor("O+","Appel Mahmud","Sherpur,Dhaka"));
        arrayList.add(new Donor("AB+","Srabon Ahamed","Dhaka"));
        arrayList.add(new Donor("B+","Akib","Mymensingh"));
        arrayList.add(new Donor("O+","Appel Mahmud","Sherpur,Dhaka"));
        arrayList.add(new Donor("AB+","Srabon Ahamed","Dhaka"));
        arrayList.add(new Donor("B+","Akib","Mymensingh"));
        arrayList.add(new Donor("O+","Appel Mahmud","Sherpur,Dhaka"));
        arrayList.add(new Donor("AB+","Srabon Ahamed","Dhaka"));
        arrayList.add(new Donor("B+","Akib","Mymensingh"));
        arrayList.add(new Donor("O+","Appel Mahmud","Sherpur,Dhaka"));
        arrayList.add(new Donor("AB+","Srabon Ahamed","Dhaka"));
        arrayList.add(new Donor("B+","Akib","Mymensingh"));

        DonorAdapter donorAdapter=new DonorAdapter(FindDonor.this,arrayList);

        //ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,R.layout.donor_view,R.id.donorname,arrayList);
        listView.setAdapter(donorAdapter);

    }
}
