package com.MostafaCovied.Mostafacovied.Abd_Lab_admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.Confiram_Lab_model;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class Adpter_to_show_users_in_lab extends RecyclerView.Adapter<Adpter_to_show_users_in_lab.Box> {
    public Adpter_to_show_users_in_lab(ArrayList<Confiram_Lab_model> lab_models) {
        this.lab_models = lab_models;
    }

    ArrayList<Confiram_Lab_model> lab_models;

    @NonNull
    @Override
    public Box onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_user_in_lab, parent, false);


        return new Box(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Box holder, int position) {

        holder.come_to_lab_time.setText(lab_models.get(position).getScan_reservation_time());
        holder.textView_can_price.setText(lab_models.get(position).getScan_price());
        holder.textView_scan_name.setText(lab_models.get(position).getScan_name());
        holder.waitng_lab_time.setText(lab_models.get(position).getScan_waiting_time());
    }

    @Override
    public int getItemCount() {
        return lab_models.size();
    }

    class Box extends RecyclerView.ViewHolder {
        TextView textView_scan_name;
        TextView textView_can_price;
        TextView come_to_lab_time;
        TextView waitng_lab_time;
        public Box(@NonNull View itemView) {

            super(itemView);
            textView_scan_name = itemView.findViewById(R.id.name_of_scan);
            textView_can_price = itemView.findViewById(R.id.price_scan);
            come_to_lab_time = itemView.findViewById(R.id.user_address_come_time_to_lab_scan);
            waitng_lab_time = itemView.findViewById(R.id.user_wait_time_scan);
        }
    }
}
