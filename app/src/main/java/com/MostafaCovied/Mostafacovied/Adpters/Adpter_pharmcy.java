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

import com.MostafaCovied.Mostafacovied.Models.Model_pharmcy;
import com.MostafaCovied.Mostafacovied.On_Item_Listener;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class Adpter_pharmcy extends RecyclerView.Adapter<Adpter_pharmcy.elments_vh> {

    ArrayList<Model_pharmcy> model_pharmcies;
    Context context;

    public Adpter_pharmcy(ArrayList<Model_pharmcy> model_pharmcies, Context context, On_Item_Listener on_item_listener) {
        this.model_pharmcies = model_pharmcies;
        this.context = context;
        this.on_item_listener = on_item_listener;
    }

    On_Item_Listener on_item_listener;


    @NonNull
    @Override
    public elments_vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cutstome_pharmcy, parent, false);
        return new elments_vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final elments_vh holder, int position) {

        Model_pharmcy modelPharmcy = model_pharmcies.get(position);

        holder.textView_name_ph.setText(modelPharmcy.getName_ph() + "");
        holder.textView_phone_ph.setText(modelPharmcy.getPhone_ph() + "");
        holder.textView_address_ph.setText(modelPharmcy.getAddress_ph() + "");
        holder.textView_phone_ph_wh.setText(modelPharmcy.getPhone_ph_wh() + "");
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_call = new Intent();
                intent_call.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:" + holder.textView_phone_ph.getText());
                intent_call.setData(uri);
                v.getContext().startActivity(intent_call);
            }
        });

    }

    @Override
    public int getItemCount() {
        return model_pharmcies.size();
    }

    class elments_vh extends RecyclerView.ViewHolder {
        TextView textView_name_ph;
        TextView textView_address_ph;
        TextView textView_phone_ph;
        TextView textView_phone_ph_wh;
        ImageView imageView;

        public elments_vh(@NonNull View itemView) {
            super(itemView);
            textView_address_ph = itemView.findViewById(R.id.address_text_pharmcey);
            textView_name_ph = itemView.findViewById(R.id.name_text_pharmcey);
            textView_phone_ph = itemView.findViewById(R.id.phone_text_pharmcey);
            textView_phone_ph_wh = itemView.findViewById(R.id.phone_text_pharmcey_wh);
            imageView = itemView.findViewById(R.id.ph_phones);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    on_item_listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
