package com.MostafaCovied.Mostafacovied.Muradpharmacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

import javax.annotation.Nullable;

public class Show_orders_of_users_ph extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    RecyclerView recyclerView;
    Adpter_show_orders_in_pharmacy show_orders_in_pharmacy;
    ArrayList<Murad_Pharmacy_Modle> modles = new ArrayList<>();
    TextView textView_total_price;
    Button button_approvale;
    String USER_id;
    String order_id;
    String id_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_orders_of_users_ph);
        recyclerView = findViewById(R.id.recycler_of_show_order_user);

        textView_total_price = findViewById(R.id.TOTAL_PRICE);
        button_approvale = findViewById(R.id.approvale);
        Intent income_intent = getIntent();
        final String user_id = income_intent.getStringExtra("user_id");
        String total_price = income_intent.getStringExtra("total_price");


        //Toast.makeText(this, user_id + "" + total_price, Toast.LENGTH_SHORT).show();
        textView_total_price.setText(total_price + "");
        firebaseFirestore.collection("pharmacy_sales").whereEqualTo("user_id", user_id).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    String med_name = String.valueOf(snapshot.get("med_name"));
                    USER_id = String.valueOf(snapshot.get("user_id"));
                    order_id = String.valueOf(snapshot.get("order_id"));
                    int count = Integer.parseInt(String.valueOf(snapshot.get("count")));
                    String med_image = String.valueOf(snapshot.get("med_image"));
                    int mult = Integer.parseInt(String.valueOf(snapshot.get("mult")));
                    modles.add(new Murad_Pharmacy_Modle(med_name, mult, count, med_image));
                    show_orders_in_pharmacy = new Adpter_show_orders_in_pharmacy(modles);
                    recyclerView.setAdapter(show_orders_in_pharmacy);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }
        });
        button_approvale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseFirestore.collection("Confirm_medication_reservation").document(user_id).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(), Murad_Orders_Fragment.class));
                            Toast.makeText(Show_orders_of_users_ph.this, "order acceptable", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
