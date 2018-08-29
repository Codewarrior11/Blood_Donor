package com.experiment.appel.blooddonor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DonorAdapter extends ArrayAdapter<Donor>{

    private Context context;
    private ArrayList<Donor>donors;
    private List<Donor> dnl;


    public DonorAdapter(@NonNull Context context,@NonNull ArrayList<Donor> donors) {
        super(context, R.layout.donor_view, donors);
        this.dnl=donors;
        this.context=context;
        this.donors=new ArrayList<Donor>();
        this.donors.addAll(dnl);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Donor donor=dnl.get(position);

        ViewHolder viewHolder;
        if (convertView==null) {
            viewHolder=new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.donor_view, parent, false);
            viewHolder.bloodgroup = convertView.findViewById(R.id.blood_group);
            viewHolder.name = convertView.findViewById(R.id.donorname);
            viewHolder.address = convertView.findViewById(R.id.donoraddress);
            viewHolder.call=convertView.findViewById(R.id.call);
            viewHolder.profileView=convertView.findViewById(R.id.accountDonor);
            convertView.setTag(viewHolder);

        }
        else
        {
            viewHolder=(ViewHolder)convertView.getTag();
        }

        viewHolder.bloodgroup.setText(donor.getBloodGroup());
        viewHolder.name.setText(donor.getName());
        viewHolder.address.setText(donor.getAddress());
        viewHolder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + donor.getPhoneNumber()));
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    private static class ViewHolder{
        TextView bloodgroup,name,address;
        Button call,profileView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dnl.clear();
        if (charText.length() == 0) {
            dnl.addAll(donors);
        } else {
            for (Donor dn : donors) {
                if (dn.getBloodGroup().toLowerCase(Locale.getDefault())
                        .contains(charText) ||dn.getAddress().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    dnl.add(dn);
                }
            }
        }
        notifyDataSetChanged();
    }
}
