package com.MostafaCovied.Mostafacovied.CT_scan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.MostafaCovied.Mostafacovied.Book_now;
import com.MostafaCovied.Mostafacovied.OnclickListner;
import com.MostafaCovied.Mostafacovied.R;

import java.util.ArrayList;

public class CT_scan extends AppCompatActivity implements OnclickListner {
    RecyclerView recyclerView;
    Adpter_cT_Scan adpter_mogat_sawtya;
    ArrayList<Model_for_CT_Scan> sawtays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_t_scan);
        recyclerView = findViewById(R.id.recycler_of_CT_scan);
        sawtays = new ArrayList<>();
        sawtays.add(new Model_for_CT_Scan(630, getString(R.string.chest), "15", getString(R.string.chest_ava_day)));
        sawtays.add(new Model_for_CT_Scan(550, getString(R.string.abdomen), "15", getString(R.string.abdomen_ava)));
        sawtays.add(new Model_for_CT_Scan(570, getString(R.string.eye), "15", getString(R.string.neck_ava)));
        sawtays.add(new Model_for_CT_Scan(550, getString(R.string.neck), "15", getString(R.string.neck_ava)));
        adpter_mogat_sawtya = new Adpter_cT_Scan(sawtays,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adpter_mogat_sawtya);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent_for_book=new Intent(getApplicationContext(), Book_now.class);
        String name= sawtays.get(position).getScan_name();
        String waiting_time= sawtays.get(position).getWaiting_time();
        int price= sawtays.get(position).getScan_price();
        Bundle bundle_send_data=new Bundle();
        bundle_send_data.putString("name",name);
        bundle_send_data.putString("waiting_time",waiting_time);
        bundle_send_data.putString("price",String.valueOf(price));
        intent_for_book.putExtras(bundle_send_data);
        startActivity(intent_for_book);
    }
}
