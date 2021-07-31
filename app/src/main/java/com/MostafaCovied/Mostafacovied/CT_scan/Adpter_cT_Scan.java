package com.MostafaCovied.Mostafacovied.CT_scan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class Adpter_cT_Scan extends RecyclerView.Adapter<Adpter_cT_Scan.vh_of_custome_mogat_sawta> {
    ArrayList<Model_for_CT_Scan> ct;
OnclickListner listner;

    public Adpter_cT_Scan(ArrayList<Model_for_CT_Scan> ct, OnclickListner listner) {
        this.ct = ct;
        this.listner = listner;
    }

    @NonNull
    @Override
    public vh_of_custome_mogat_sawta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_layout_ct_scan, parent, false);
        return new vh_of_custome_mogat_sawta(view);
    }

    @Override
    public void onBindViewHolder(@NonNull vh_of_custome_mogat_sawta holder, int position) {
        Model_for_CT_Scan for_ct_scan = ct.get(position);
        holder.textView_scan_name.setText(for_ct_scan.getScan_name()+"");
        holder.textView_scan_price.setText(for_ct_scan.getScan_price()+"");
        holder.textView_scan_availbale_time.setText(for_ct_scan.getAvailable_time()+"");
        holder.textView_scan_waitng_time.setText(for_ct_scan.getWaiting_time()+"");
    }

    @Override
    public int getItemCount() {
        return ct.size();
    }

    class vh_of_custome_mogat_sawta extends RecyclerView.ViewHolder {

        TextView textView_scan_price;
        TextView textView_scan_name;
        TextView textView_scan_waitng_time;
        TextView textView_scan_availbale_time;
        Button button_book_now;
        public vh_of_custome_mogat_sawta(@NonNull View itemView) {
            super(itemView);
            textView_scan_price = itemView.findViewById(R.id.text_for_real_price);
            textView_scan_name = itemView.findViewById(R.id.text_scan_name);
            textView_scan_waitng_time = itemView.findViewById(R.id.text_wating_time);
            textView_scan_availbale_time = itemView.findViewById(R.id.text_Available_time);
            button_book_now=itemView.findViewById(R.id.book_now);

            button_book_now.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
