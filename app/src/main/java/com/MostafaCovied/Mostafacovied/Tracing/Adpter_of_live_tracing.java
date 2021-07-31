package com.MostafaCovied.Mostafacovied.Tracing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.Ministry.Healthy_model;
import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adpter_of_live_tracing extends RecyclerView.Adapter<Adpter_of_live_tracing.vh_of_elements_of_custome_live_traing> {

    ArrayList<Healthy_model> healthy_models;
    OnclickListner listner;

    public Adpter_of_live_tracing(ArrayList<Healthy_model> healthy_models, OnclickListner listner) {
        this.healthy_models = healthy_models;
        this.listner = listner;
    }

    @NonNull
    @Override
    public vh_of_elements_of_custome_live_traing onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_of_live, parent, false);
        return new vh_of_elements_of_custome_live_traing(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final vh_of_elements_of_custome_live_traing holder, int position) {
        //Healthy_model healthyModel = healthy_models.get(position);
        holder.textView_uid.setText(healthy_models.get(position).getId());
        holder.textView_name.setText(healthy_models.get(position).getName());
        Picasso.get().load(healthy_models.get(position).getImage()).into(holder.circleImageView);


    }

    @Override
    public int getItemCount() {
        return healthy_models.size();
    }

    class vh_of_elements_of_custome_live_traing extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView textView_name;
        TextView textView_uid;

        public vh_of_elements_of_custome_live_traing(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.live_tracing_image);
            textView_name = itemView.findViewById(R.id.user_name_of_live_tracing);
            textView_uid = itemView.findViewById(R.id.user_uid_of_live_tracing);
            circleImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
