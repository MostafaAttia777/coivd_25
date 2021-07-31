package com.MostafaCovied.Mostafacovied.Normal_rays;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.MostafaCovied.Mostafacovied.CT_scan.Model_for_CT_Scan;
import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class Adpter_for_normal_rays extends RecyclerView.Adapter<Adpter_for_normal_rays.normal_rays_view_hlder> {
    ArrayList<Model_for_CT_Scan> model_for_ct_scans;

    OnclickListner listner;

    public Adpter_for_normal_rays(ArrayList<Model_for_CT_Scan> model_for_ct_scans, OnclickListner listner) {
        this.model_for_ct_scans = model_for_ct_scans;
        this.listner = listner;
    }

    @NonNull
    @Override
    public normal_rays_view_hlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_layout_ct_scan, parent, false);
        normal_rays_view_hlder normal_rays_view_hlder = new normal_rays_view_hlder(view);
        return normal_rays_view_hlder;
    }

    @Override
    public int getItemCount() {
        return model_for_ct_scans.size();
    }

    @Override
    public void onBindViewHolder(@NonNull normal_rays_view_hlder holder, int position) {
        Model_for_CT_Scan scan = model_for_ct_scans.get(position);
        holder.textView_scan_name.setText(scan.getScan_name()+"");
        holder.textView_scan_price.setText(scan.getScan_price()+"");
        holder.textView_scan_availbale_time.setText(scan.getAvailable_time()+"");
        holder.textView_scan_waitng_time.setText(scan.getWaiting_time()+"");
    }

    class normal_rays_view_hlder extends RecyclerView.ViewHolder {
        TextView textView_scan_price;
        TextView textView_scan_name;
        TextView textView_scan_waitng_time;
        TextView textView_scan_availbale_time;
        Button button_book_now;
        public normal_rays_view_hlder(@NonNull View itemView) {
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
