package com.MostafaCovied.Mostafacovied.Demerdash;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;
import java.util.List;

public class Adpter_dem extends RecyclerView.Adapter<Adpter_dem.Box_vh_dem> {

    ArrayList<Dem_modle> dem_modleArrayList;
    OnclickListner listner;

    public Adpter_dem(ArrayList<Dem_modle> dem_modleArrayList, OnclickListner listner) {
        this.dem_modleArrayList = dem_modleArrayList;
        this.listner = listner;
    }



    @NonNull
    @Override
    public Box_vh_dem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_dem, parent, false);
        Box_vh_dem box_vh_dem = new Box_vh_dem(view);
        return box_vh_dem;
    }

    @Override
    public void onBindViewHolder(@NonNull Box_vh_dem holder, int position) {

        Dem_modle demModle=dem_modleArrayList.get(position);
        holder.textView_name.setText(demModle.getPatient_name());
        holder.textView_phone.setText(demModle.getPatient_phone());
        holder.textView_address.setText(demModle.getPatient_address());
    }

    @Override
    public int getItemCount() {
        return dem_modleArrayList.size();
    }

    class Box_vh_dem extends RecyclerView.ViewHolder {
        TextView textView_name;
        TextView textView_phone;
        TextView textView_address;

        public Box_vh_dem(@NonNull View itemView) {
            super(itemView);
            textView_name = itemView.findViewById(R.id.user_name_of_patient_name);
            textView_phone = itemView.findViewById(R.id.phone_user_patient_phone);
            textView_address = itemView.findViewById(R.id.user_address_patient_address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
