package com.MostafaCovied.Mostafacovied.Muradpharmacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class Adpter_for_pharmacy extends RecyclerView.Adapter<Adpter_for_pharmacy.Users_modle_order> {


    ArrayList<Murad_Pharmacy_Modle> pharmacy_modles;
    OnclickListner listner;

    public Adpter_for_pharmacy(ArrayList<Murad_Pharmacy_Modle> pharmacy_modles, OnclickListner listner) {
        this.pharmacy_modles = pharmacy_modles;
        this.listner = listner;
    }

    @NonNull
    @Override
    public Users_modle_order onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.murad_orders, parent, false);

        return new Users_modle_order(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Users_modle_order holder, int position) {
        holder.textView_name.setText(pharmacy_modles.get(position).getCustomer_name());
        holder.textView_address.setText(pharmacy_modles.get(position).getCustomer_address());
        holder.textView_phone.setText(pharmacy_modles.get(position).getCustomer_phone());
        holder.textView_sign.setText(pharmacy_modles.get(position).getCustomer_sign());
    }

    @Override
    public int getItemCount() {
        return pharmacy_modles.size();
    }

    class Users_modle_order extends RecyclerView.ViewHolder {

        TextView textView_name;
        TextView textView_phone;
        TextView textView_address;
        TextView textView_sign;

        CardView cardView;

        public Users_modle_order(@NonNull View itemView) {
            super(itemView);
            textView_name = itemView.findViewById(R.id.user_name_of_order);
            textView_phone = itemView.findViewById(R.id.phone_user_order);
            textView_address = itemView.findViewById(R.id.user_address_order);
            textView_sign = itemView.findViewById(R.id.user_sign_order);
//            cardView = itemView.findViewById(R.id.my_view);
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    listner.onItemClick(getAdapterPosition());
//                }
//            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClick(getAdapterPosition());
                }
            });
        }

    }

}
