package com.MostafaCovied.Mostafacovied.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.MostafaCovied.Mostafacovied.Cart.CartshopeFragment;
import com.MostafaCovied.Mostafacovied.Fragments.Home_Fragment;
import com.MostafaCovied.Mostafacovied.Fragments.Lab_Fragment;
import com.MostafaCovied.Mostafacovied.Fragments.Newspaper;
import com.MostafaCovied.Mostafacovied.Fragments.checkCityFragment;
import com.MostafaCovied.Mostafacovied.Fragments.hospital_Fragment;
import com.MostafaCovied.Mostafacovied.Fragments.pharmacy_Fragment;
import com.MostafaCovied.Mostafacovied.Fragments.signoutFragment;
import com.MostafaCovied.Mostafacovied.Login.LoginScreen;
import com.MostafaCovied.Mostafacovied.Places.MapsActivity;
import com.MostafaCovied.Mostafacovied.R;
import com.MostafaCovied.Mostafacovied.Settings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home_Screen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Button button;
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
        setContentView(R.layout.activity_main);
        //   button = findViewById(R.id.outer);
        drawerLayout = findViewById(R.id.my_drawerLayout);
        navigationView = findViewById(R.id.my_nav);
        navigationView.setNavigationItemSelectedListener(this);
        textView_name = findViewById(R.id.name_menu);
        textView_email = findViewById(R.id.emial_menu);
        circleImageView = findViewById(R.id.image_menu);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (firebaseAuth.getCurrentUser() == null) {
            startActivity(new Intent(getBaseContext(), LoginScreen.class));
            finish();
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new Home_Fragment()).commit();

        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (firebaseUser != null) {
            updatanavheader();

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

            case R.id.my_lab:
                fragment = new Lab_Fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new Lab_Fragment()).commit();

                break;
            case R.id.my_hospital:
                fragment = new hospital_Fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new hospital_Fragment()).commit();

                break;
            case R.id.my_pharmacy:
                fragment = new pharmacy_Fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new pharmacy_Fragment()).commit();

                break;
            case R.id.my_home_page:
                fragment = new Home_Fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new Home_Fragment()).commit();

                break;
            case R.id.my_city:
                fragment = new checkCityFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new checkCityFragment()).commit();

                break;
            case R.id.out:
                // fragment = new signoutFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new signoutFragment()).commit();
                finish();
                break;
            case R.id.newspaper:
                // fragment = new signoutFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new Newspaper()).commit();
                break;
            case R.id.settings:
                startActivity(new Intent(getApplicationContext(), Settings.class));
                break;
            case R.id.Cartshope:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new CartshopeFragment()).commit();
                break;
            case R.id.my_location:
                // getSupportFragmentManager().beginTransaction().replace(R.id.my_tv, new CartshopeFragment()).commit();
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
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

    public void updatanavheader() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.my_nav);
        View headview = navigationView.getHeaderView(0);
        final TextView tx_name = headview.findViewById(R.id.name_menu);
        final TextView tx_email = headview.findViewById(R.id.emial_menu);
        final CircleImageView imageView = headview.findViewById(R.id.image_menu);

        String id = firebaseAuth.getCurrentUser().getUid();
        firebaseFirestore.collection("Users").document(id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    String name = String.valueOf(task.getResult().get("name"));
                    String email = String.valueOf(task.getResult().get("email"));
                    //  Uri image = Uri.parse(String.valueOf(task.getResult().get("image_link")));
                    // String links = String.valueOf(task.getResult().get("image_link"));
                    String links = String.valueOf(task.getResult().get("image_link"));
                    tx_email.setText(email);
                    tx_name.setText(name);
                    Picasso.get().load(links).placeholder(R.drawable.avters).into(imageView);

                }
            }
        });
        //Picasso.get().load(firebaseUser.getPhotoUrl()).into(imageView);
    }
}
