package com.MostafaCovied.Mostafacovied.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.MostafaCovied.Mostafacovied.CT_scan.CT_scan;
import com.MostafaCovied.Mostafacovied.mogat.Mogat_sawtiya;
import com.MostafaCovied.Mostafacovied.Normal_rays.Normal_Rays;
import com.MostafaCovied.Mostafacovied.R;

public class Abd_Lab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abd__lab);
    }

    public void sawtita(View view) {
        startActivity(new Intent(getApplicationContext(), Mogat_sawtiya.class));


    }

    public void rays(View view) {
        startActivity(new Intent(getApplicationContext(), Normal_Rays.class));

    }

    public void ct(View view) {
        startActivity(new Intent(getApplicationContext(), CT_scan.class));

    }
}
