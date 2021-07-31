package com.MostafaCovied.Mostafacovied.Demerdash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.MostafaCovied.Mostafacovied.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class Show_book_room extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    RecyclerView recyclerView;
    Button button_approvale;
    String USER_id;
    String order_id;
    List<Dem_modle> dem_modles = new ArrayList<>();
    Adpter_dem adpter_dem;
    show_details_book_room show_details_book_room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_book_room);
        recyclerView = findViewById(R.id.recycler_of_show_book_room);
        button_approvale = findViewById(R.id.approvale_book_room);

        Intent income_intent = getIntent();
        final String user_id = income_intent.getStringExtra("user_id");
       // Toast.makeText(Show_book_room.this, user_id+"", Toast.LENGTH_SHORT).show();

        firebaseFirestore.collection("Hospital_Confirm_reservation").whereEqualTo("user_id", user_id).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    USER_id = String.valueOf(snapshot.get("user_id"));
                    order_id = String.valueOf(snapshot.get("order_id"));
                    String patient_address = String.valueOf(snapshot.get("patient_address"));
                    String patient_name = String.valueOf(snapshot.get("patient_name"));
                    String patient_phone = String.valueOf(snapshot.get("patient_phone"));
                    String patient_age = String.valueOf(snapshot.get("patient_age"));
                    String kind = String.valueOf(snapshot.get("kind"));
                    //Toast.makeText(Show_book_room.this, kind+"", Toast.LENGTH_SHORT).show();
                    dem_modles.add(new Dem_modle(kind, patient_address, patient_age, patient_name, patient_phone));

                    show_details_book_room = new show_details_book_room((ArrayList<Dem_modle>) dem_modles);
                    recyclerView.setAdapter(show_details_book_room);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                  //  Toast.makeText(Show_book_room.this, user_id+"", Toast.LENGTH_SHORT).show();

                }
            }
        });
        button_approvale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseFirestore.collection("Hospital_Confirm_reservation").document(user_id).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(), Users_Fragment.class));
                          //  Toast.makeText(Show_orders_of_users_ph.this, "order acceptable", Toast.LENGTH_SHORT).show();
                            Toast.makeText(Show_book_room.this, "order acceptable", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }
}
