package com.MostafaCovied.Mostafacovied.Abd_Lab_admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.MostafaCovied.Mostafacovied.Fragments.signoutFragment;
import com.MostafaCovied.Mostafacovied.Login.LoginScreen;
import com.MostafaCovied.Mostafacovied.Muradpharmacy.Murad_Orders_Fragment;
import com.MostafaCovied.Mostafacovied.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Lab_amdin_home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_amdin_home);
        drawerLayout = findViewById(R.id.my_drawerLayout_Lab_admin);
        navigationView = findViewById(R.id.my_nav_Lab_admin);
        navigationView.setNavigationItemSelectedListener(this);
//        textView_name = findViewById(R.id.name_menu);
//        textView_email = findViewById(R.id.emial_menu);
//        circleImageView = findViewById(R.id.image_menu);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (firebaseAuth.getCurrentUser() == null) {
            startActivity(new Intent(getBaseContext(), LoginScreen.class));
            finish();
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.my_tv_Lab_admin, new Users_orders_lab()).commit();

        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (firebaseUser != null) {
            //  updatanavheader();

        } else {
            Toast.makeText(this, "no user", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.Users_orders_lab:
                fragment = new Murad_Orders_Fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv_Lab_admin, new Users_orders_lab()).commit();
                break;
//            case R.id.Cases:
//                fragment = new Cases_fragment();
//                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv_health, new Cases_fragment()).commit();
//                break;
            case R.id.out_lab:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv_Lab_admin, new signoutFragment()).commit();
                finish();
                break;

        }


        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}