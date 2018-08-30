package com.experiment.appel.blooddonor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.experiment.appel.blooddonor.database.DonorDatabaseManager;

import java.util.ArrayList;

public class FindDonor extends AppCompatActivity {
    ListView donorList;
    Button callButton;
    DonorAdapter donorAdapter;
    DonorDatabaseManager donorDatabaseManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_donor);

        donorList = findViewById(R.id.donor_list_data);
        donorDatabaseManager = new DonorDatabaseManager(this);

        ArrayList<Donor> arrayList = donorDatabaseManager.getAllDonors();
        ArrayList<Donor> listForDisplay = new ArrayList<>();
        /*for(Donor donor:arrayList){
            listForDisplay.add(donor);
        }*/
        donorAdapter = new DonorAdapter(FindDonor.this, arrayList);
        donorList.setAdapter(donorAdapter);

       /* ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listForDisplay);
        donorList.setAdapter(adapter);

        ArrayList<Donor> arrayList = new ArrayList<>();
        arrayList.add(new Donor("O+", "Appel Mahmud", "Sherpur,Dhaka","01719717528"));
        arrayList.add(new Donor("AB+", "Srabon Ahamed", "Dhaka","01719717529"));
        arrayList.add(new Donor("B+", "Akib", "Mymensingh","01719717520"));
        arrayList.add(new Donor("O+", "Appel Mahmud", "Sherpur,Dhaka","01719717528"));
        arrayList.add(new Donor("AB+", "Srabon Ahamed", "Dhaka","01719717528"));
        arrayList.add(new Donor("B+", "Akib", "Mymensingh","01719717528"));
        arrayList.add(new Donor("O+", "Appel Mahmud", "Sherpur,Dhaka","01719717528"));
        arrayList.add(new Donor("AB+", "Srabon Ahamed", "Dhaka","01719717528"));
        arrayList.add(new Donor("B+", "Akib", "Mymensingh","01719717528"));
        arrayList.add(new Donor("O+", "Appel Mahmud", "Sherpur,Dhaka","01719717528"));
        arrayList.add(new Donor("AB+", "Srabon Ahamed", "Dhaka","01719717528"));
        arrayList.add(new Donor("B+", "Akib", "Mymensingh","01719717528"));

        donorAdapter = new DonorAdapter(FindDonor.this, arrayList);

        //ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,R.layout.donor_view,R.id.donorname,arrayList);
        donorList.setAdapter(donorAdapter);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.searchmenu,menu);
        MenuItem item=menu.findItem(R.id.serachItem);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setQueryHint("Type Blood group or Address");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    donorAdapter.filter("");
                    donorList.clearTextFilter();
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
