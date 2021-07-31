package com.MostafaCovied.Mostafacovied.Ministry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.MostafaCovied.Mostafacovied.Fragments.signoutFragment;
import com.MostafaCovied.Mostafacovied.Login.LoginScreen;
import com.MostafaCovied.Mostafacovied.R;
import com.MostafaCovied.Mostafacovied.Tracing.Users_fragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import de.hdodenhof.circleimageview.CircleImageView;

public class Health_of_egypt extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    TextView textView_name, textView_email;
    CircleImageView circleImageView;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_of_egypt);
        drawerLayout = findViewById(R.id.my_drawerLayout_health);
        navigationView = findViewById(R.id.my_nav_health);
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
            getSupportFragmentManager().beginTransaction().replace(R.id.my_tv_health, new Users_fragment()).commit();

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
            case R.id.my_Users:
                fragment = new Users_fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv_health, new Users_fragment()).commit();
                break;
            case R.id.Cases:
                fragment = new Cases_fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv_health, new Cases_fragment()).commit();
                break;
                case R.id.out_healthy:
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_tv_health, new signoutFragment()).commit();
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
