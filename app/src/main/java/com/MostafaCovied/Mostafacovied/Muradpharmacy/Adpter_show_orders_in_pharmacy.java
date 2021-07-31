package com.MostafaCovied.Mostafacovied.Muradpharmacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adpter_show_orders_in_pharmacy extends RecyclerView.Adapter<Adpter_show_orders_in_pharmacy.Show_my_orders> {

    public Adpter_show_orders_in_pharmacy(ArrayList<Murad_Pharmacy_Modle> muradPharmacyModles) {
        this.muradPharmacyModles = muradPharmacyModles;
    }

    ArrayList<Murad_Pharmacy_Modle> muradPharmacyModles;

    @NonNull
    @Override
    public Show_my_orders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_of_show_order, parent, false);

        return new Show_my_orders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Show_my_orders holder, int position) {

        holder.textView_name.setText(muradPharmacyModles.get(position).getCustomer_name());
        holder.textView_pp_price.setText(String.valueOf(muradPharmacyModles.get(position).getMult()));
        holder.textView_count.setText(String.valueOf(muradPharmacyModles.get(position).getCount()));
        Picasso.get().load(muradPharmacyModles.get(position).getMed_image()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return muradPharmacyModles.size();
    }

    class Show_my_orders extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView_pp_price;
        TextView textView_name, textView_count;

        public Show_my_orders(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_custome_of_show_order);
            textView_name = itemView.findViewById(R.id.name_custome_of_show_order);
            textView_count = itemView.findViewById(R.id.count_of_order_show_order);
            textView_pp_price = itemView.findViewById(R.id.pp_price_show);
        }
    }
}
