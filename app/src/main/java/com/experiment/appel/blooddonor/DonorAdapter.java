package com.experiment.appel.blooddonor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DonorAdapter extends ArrayAdapter<Donor>{

    private Context context;
    private ArrayList<Donor>donors;


    public DonorAdapter(@NonNull Context context,@NonNull ArrayList<Donor> donor) {
        super(context, R.layout.donor_view, donor);

        this.context=context;
        this.donors=donor;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Donor donor=donors.get(position);

        ViewHolder viewHolder;
        if (convertView==null) {
            viewHolder=new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.donor_view, parent, false);
            viewHolder.bloodgroup = convertView.findViewById(R.id.blood_group);
            viewHolder.name = convertView.findViewById(R.id.donorname);
            viewHolder.address = convertView.findViewById(R.id.donoraddress);
            convertView.setTag(viewHolder);

        }
        else
        {
            viewHolder=(ViewHolder)convertView.getTag();
        }

        viewHolder.bloodgroup.setText(donor.getBloodGroup());
        viewHolder.name.setText(donor.getName());
        viewHolder.address.setText(donor.getAddress());

        return convertView;
    }

    private static class ViewHolder{
        TextView bloodgroup,name,address;
    }
}
