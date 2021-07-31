package com.MostafaCovied.Mostafacovied.Demerdash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.MostafaCovied.Mostafacovied.R;

public class Demerdash_home extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demerdash_home);
        button =findViewById(R.id.book_room_in_hospital);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),book_room_in_hospital.class));
            }
        });

    }
}
