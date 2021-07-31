package com.MostafaCovied.Mostafacovied.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.MostafaCovied.Mostafacovied.Activity.Home_Screen;
import com.MostafaCovied.Mostafacovied.Fragments.Supplies_Fragment;
import com.MostafaCovied.Mostafacovied.Fragments.medicine_Fragment;
import com.MostafaCovied.Mostafacovied.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Medical_Supplies extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical__supplies);
         bottomNavigationView =findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;

                switch (item.getItemId()){

                    case R.id.medicine:
                        fragment=new medicine_Fragment();
                        break;
                    case R.id.Supplies:
                        fragment=new Supplies_Fragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv_for_fragment,fragment).commit();
                return true;
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.my_tv_for_fragment, new medicine_Fragment()).commit();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), Home_Screen.class));

    }

}

