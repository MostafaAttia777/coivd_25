package com.MostafaCovied.Mostafacovied.mogat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.CT_scan.Model_for_CT_Scan;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class Adpter_for_mogat_sawtiya extends RecyclerView.Adapter<Adpter_for_mogat_sawtiya.mogat_sawtiya_view_holder> {

    ArrayList<Model_for_CT_Scan> model_for_ct_scans;

    public Adpter_for_mogat_sawtiya(ArrayList<Model_for_CT_Scan> model_for_ct_scans) {
        this.model_for_ct_scans = model_for_ct_scans;
    }

    @NonNull
    @Override
    public mogat_sawtiya_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_layout_ct_scan, parent, false);
        return new mogat_sawtiya_view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mogat_sawtiya_view_holder holder, int position) {
        Model_for_CT_Scan mogat_sawtiya = model_for_ct_scans.get(position);
        holder.textView_scan_name.setText(mogat_sawtiya.getScan_name() + "");
        holder.textView_scan_price.setText(mogat_sawtiya.getScan_price() + "");
        holder.textView_scan_availbale_time.setText(mogat_sawtiya.getAvailable_time() + "");
        holder.textView_scan_waitng_time.setText(mogat_sawtiya.getWaiting_time() + "");
    }

    @Override
    public int getItemCount() {
        return model_for_ct_scans.size();
    }

    class mogat_sawtiya_view_holder extends RecyclerView.ViewHolder {
        TextView textView_scan_price;
        TextView textView_scan_name;
        TextView textView_scan_waitng_time;
        TextView textView_scan_availbale_time;

        public mogat_sawtiya_view_holder(@NonNull View itemView) {
            super(itemView);
            textView_scan_price = itemView.findViewById(R.id.text_for_real_price);
            textView_scan_name = itemView.findViewById(R.id.text_scan_name);
            textView_scan_waitng_time = itemView.findViewById(R.id.text_wating_time);
            textView_scan_availbale_time = itemView.findViewById(R.id.text_Available_time);
        }
    }
}
