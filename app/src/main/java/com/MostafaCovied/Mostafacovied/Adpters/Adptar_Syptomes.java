package com.MostafaCovied.Mostafacovied.Adpters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.Models.Model_home;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class Adptar_Syptomes extends RecyclerView.Adapter<Adptar_Syptomes.box_vh> {

    public Adptar_Syptomes(ArrayList<Model_home> model_homes) {
        this.model_homes = model_homes;
    }

    ArrayList<Model_home> model_homes;

    @NonNull
    @Override
    public box_vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_syptomes, parent, false);
        return new box_vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull box_vh holder, int position) {
        Model_home modelHome = model_homes.get(position);
        holder.textView.setText(String.valueOf(modelHome.getName()));
        holder.imageView.setImageResource(modelHome.getImage());
    }

    @Override
    public int getItemCount() {
        return model_homes.size();
    }

    class box_vh extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public box_vh(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.mg_mg);
            textView = itemView.findViewById(R.id.tx_tx);
        }
    }
}
