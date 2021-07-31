package com.MostafaCovied.Mostafacovied.Normal_rays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.MostafaCovied.Mostafacovied.Book_now;
import com.MostafaCovied.Mostafacovied.CT_scan.Model_for_CT_Scan;
import com.MostafaCovied.Mostafacovied.On_Item_Listener;
import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class Normal_Rays extends AppCompatActivity implements OnclickListner {


    RecyclerView recyclerView;

    Adpter_for_normal_rays adpter_rays;
    ArrayList<Model_for_CT_Scan> list_of_scans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal__rays);
        recyclerView = findViewById(R.id.recycler_of_normal_Rays);
        list_of_scans = new ArrayList<>();
        list_of_scans.add(new Model_for_CT_Scan(45, getString(R.string.teeth), "15", getString(R.string.chest_ava_day)));
        list_of_scans.add(new Model_for_CT_Scan(130, getString(R.string.hip), "15", getString(R.string.abdomen_ava)));
        list_of_scans.add(new Model_for_CT_Scan(170, getString(R.string.skull), "15", getString(R.string.neck_ava)));
        list_of_scans.add(new Model_for_CT_Scan(1100, getString(R.string.intestines), "15", getString(R.string.neck_ava)));
        adpter_rays = new Adpter_for_normal_rays(list_of_scans, this);
        recyclerView.setAdapter(adpter_rays);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }


    @Override
    public void onItemClick(int position) {

        //startActivity(new Intent(getApplicationContext(), Book_now.class));
       Intent intent_for_book=new Intent(getApplicationContext(),Book_now.class);
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

