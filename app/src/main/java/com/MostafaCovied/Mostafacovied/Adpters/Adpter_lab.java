package com.MostafaCovied.Mostafacovied.Adpters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.Models.Lab_Model;
import com.MostafaCovied.Mostafacovied.On_Item_Listener;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class Adpter_lab extends RecyclerView.Adapter<Adpter_lab.box_lab_vh> {


    Context context;
    On_Item_Listener listener;
    ArrayList<Lab_Model> lab_models;

    public Adpter_lab(Context context, On_Item_Listener listener, ArrayList<Lab_Model> lab_models) {
        this.context = context;
        this.listener = listener;
        this.lab_models = lab_models;
    }

    @NonNull
    @Override
    public box_lab_vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_labs,parent,false);

        return new box_lab_vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final box_lab_vh holder, int position) {

        Lab_Model model=lab_models.get(position);
        holder.textView_name_ph.setText(model.getName_ph_lab());
        holder.textView_address_ph.setText(model.getAddress_ph_lab());
        holder.textView_phone_ph.setText(model.getPhone_ph_lab());
        holder.textView_phone_ph_wh.setText(model.getPhone_ph_wh_lab());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_call = new Intent();
                intent_call.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:" + holder.textView_phone_ph.getText());
                intent_call.setData(uri);
                v.getContext().startActivity(intent_call);
            }
        });    }

    @Override
    public int getItemCount() {
        return lab_models.size();
    }

    class  box_lab_vh extends RecyclerView.ViewHolder{
        TextView textView_name_ph;
        TextView textView_address_ph;
        TextView textView_phone_ph;
        TextView textView_phone_ph_wh;
        ImageView imageView;
        public box_lab_vh(@NonNull final View itemView) {
            super(itemView);
            textView_address_ph = itemView.findViewById(R.id.address_text_lab);
            textView_name_ph = itemView.findViewById(R.id.name_text_lab);
            textView_phone_ph = itemView.findViewById(R.id.phone_text_lab);
            textView_phone_ph_wh = itemView.findViewById(R.id.phone_text_lab_wh);
            imageView = itemView.findViewById(R.id.ph_phones_lab);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.onItemClick(getAdapterPosition());
                }
            });

        }
    }
}
