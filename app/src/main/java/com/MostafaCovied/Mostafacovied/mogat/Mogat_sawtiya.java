package com.MostafaCovied.Mostafacovied.mogat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.MostafaCovied.Mostafacovied.Book_now;
import com.MostafaCovied.Mostafacovied.CT_scan.Model_for_CT_Scan;
import com.MostafaCovied.Mostafacovied.Normal_rays.Adpter_for_normal_rays;
import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class Mogat_sawtiya extends AppCompatActivity implements OnclickListner {

    RecyclerView recyclerView;

    Adpter_for_normal_rays adpter_mogat;
    ArrayList<Model_for_CT_Scan> list_of_scans;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mogat_sawtiya);
    recyclerView = findViewById(R.id.recycler_of_mogat_sawtya);
    list_of_scans = new ArrayList<>();
    list_of_scans.add(new Model_for_CT_Scan(140, getString(R.string.Sound), "15", getString(R.string.chest_ava_day)));
    list_of_scans.add(new Model_for_CT_Scan(225, getString(R.string.Sound_neck), "15", getString(R.string.abdomen_ava)));
    list_of_scans.add(new Model_for_CT_Scan(400, getString(R.string.Sound_eye), "15", getString(R.string.neck_ava)));
    list_of_scans.add(new Model_for_CT_Scan(500, getString(R.string.Sound_brain), "15", getString(R.string.neck_ava)));
    adpter_mogat = new Adpter_for_normal_rays(list_of_scans,this);
    recyclerView.setAdapter(adpter_mogat);
    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }

    @Override
    public void onItemClick(int position) {
        Intent intent_for_book=new Intent(getApplicationContext(), Book_now.class);
        String name= list_of_scans.get(position).getScan_name();
        String waiting_time= list_of_scans.get(position).getWaiting_time();
        int price= list_of_scans.get(position).getScan_price();
        Bundle bundle_send_data=new Bundle();
        bundle_send_data.putString("name",name);
        bundle_send_data.putString("waiting_time",waiting_time);
        bundle_send_data.putString("price",String.valueOf(price));
        intent_for_book.putExtras(bundle_send_data);
        startActivity(intent_for_book);
    }
}
