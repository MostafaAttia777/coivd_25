package com.MostafaCovied.Mostafacovied.Demerdash;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class show_details_book_room extends RecyclerView.Adapter<show_details_book_room.Show_booK_room> {

    ArrayList<Dem_modle> dem_modleArrayList;

    public show_details_book_room(ArrayList<Dem_modle> dem_modleArrayList) {
        this.dem_modleArrayList = dem_modleArrayList;
    }

    @NonNull
    @Override
    public Show_booK_room onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_book_room, parent, false);
        return new Show_booK_room(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Show_booK_room holder, int position) {
        Dem_modle demModle = dem_modleArrayList.get(position);
        holder.textView_name.setText(demModle.getPatient_name());
        holder.textView_phone.setText(demModle.getPatient_phone());
        holder.textView_address.setText(demModle.getPatient_address());
        holder.textView_kind.setText(demModle.getKind());
        holder.textView_age.setText(demModle.getPatient_age());
    }

    @Override
    public int getItemCount() {
        return dem_modleArrayList.size();
    }

    class Show_booK_room extends RecyclerView.ViewHolder {

        TextView textView_name, textView_phone, textView_address, textView_kind, textView_age;

        public Show_booK_room(@NonNull View itemView) {
            super(itemView);
            textView_address = itemView.findViewById(R.id.user_address_patient_address_);
            textView_name = itemView.findViewById(R.id.user_name_of_patient_name_);
            textView_phone = itemView.findViewById(R.id.phone_user_patient_phone_);
            textView_kind = itemView.findViewById(R.id.user_address_patient_kind_);
            textView_age = itemView.findViewById(R.id.user_patient_age_);
        }
    }
}
