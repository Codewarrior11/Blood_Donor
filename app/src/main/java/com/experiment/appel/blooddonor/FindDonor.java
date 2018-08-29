package com.experiment.appel.blooddonor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Locale;

public class FindDonor extends AppCompatActivity {
    ListView listView;
    DonorAdapter donorAdapter;



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

        donorAdapter=new DonorAdapter(FindDonor.this,arrayList);

        //ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,R.layout.donor_view,R.id.donorname,arrayList);
        listView.setAdapter(donorAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.searchmenu,menu);
        MenuItem item=menu.findItem(R.id.serachItem);
        SearchView searchView=(SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    donorAdapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    donorAdapter.filter(s);
                }
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
