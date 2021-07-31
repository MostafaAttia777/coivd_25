package com.MostafaCovied.Mostafacovied.Abd_Lab_admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.MostafaCovied.Mostafacovied.Confiram_Lab_model;
import com.MostafaCovied.Mostafacovied.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class Show_orders_of_users_Lab extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    Adpter_to_show_users_in_lab adpter_lab_for_users;
    ArrayList<Confiram_Lab_model> modles = new ArrayList<>();
    TextView textView_total_price;
    Button button_approvale;
    String order_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_orders_of_users__lab);
        recyclerView = findViewById(R.id.lab_show_users);
        button_approvale=findViewById(R.id.approvale_scan);
        Intent income_intent = getIntent();

        final String user_id = income_intent.getStringExtra("user_id");
        firebaseFirestore.collection("Lab_scan_details").whereEqualTo("user_id", user_id).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    order_id = String.valueOf(snapshot.get("order_id"));
                    String scan_name = String.valueOf(snapshot.get("scan_name"));
                    String scan_price = String.valueOf(snapshot.get("scan_price"));
                    String scan_reservation_time = String.valueOf(snapshot.get("scan_reservation_time"));
                    String scan_waiting_time = String.valueOf(snapshot.get("scan_waiting_time"));

                    modles.add(new Confiram_Lab_model(scan_name, scan_price, scan_reservation_time, scan_waiting_time,4));
                    adpter_lab_for_users = new Adpter_to_show_users_in_lab(modles);
                    recyclerView.setAdapter(adpter_lab_for_users);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }
        });
        button_approvale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseFirestore.collection("Lab_Confirm_reservation").document(user_id).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),Users_orders_lab.class));
                            Toast.makeText(Show_orders_of_users_Lab.this, "done", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
    }
}
