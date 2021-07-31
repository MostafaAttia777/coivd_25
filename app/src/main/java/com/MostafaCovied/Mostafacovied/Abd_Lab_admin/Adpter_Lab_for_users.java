package com.MostafaCovied.Mostafacovied.Abd_Lab_admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.Confiram_Lab_model;
import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class Adpter_Lab_for_users extends RecyclerView.Adapter<Adpter_Lab_for_users.Users_View_Holder> {
    ArrayList<Confiram_Lab_model>lab_models;
    OnclickListner listner;

    public Adpter_Lab_for_users(ArrayList<Confiram_Lab_model> lab_models, OnclickListner listner) {
        this.lab_models = lab_models;
        this.listner = listner;
    }

    @NonNull
    @Override
    public Users_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_resrv_lab, parent, false);


        return new Users_View_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Users_View_Holder holder, int position) {
holder.textView_name.setText(lab_models.get(position).getPatient_name());
holder.textView_phone.setText(lab_models.get(position).getPatient_phone());
holder.Patient_age.setText(lab_models.get(position).getPatient_age());
    }

    @Override
    public int getItemCount() {
        return lab_models.size();
    }

    class  Users_View_Holder extends RecyclerView.ViewHolder {
        TextView textView_name;
        TextView textView_phone;
        TextView Patient_age;
        public Users_View_Holder(@NonNull View itemView) {
            super(itemView);
            textView_name = itemView.findViewById(R.id.user_name_of_order_scan);
            textView_phone = itemView.findViewById(R.id.phone_user_order_scan);
            Patient_age = itemView.findViewById(R.id.user_address_order_scan);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
