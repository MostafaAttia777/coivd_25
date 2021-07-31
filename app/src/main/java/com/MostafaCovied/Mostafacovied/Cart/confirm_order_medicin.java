package com.MostafaCovied.Mostafacovied.Cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.MostafaCovied.Mostafacovied.Activity.Home_Screen;
import com.MostafaCovied.Mostafacovied.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;

public class confirm_order_medicin extends AppCompatActivity {

    TextView textView_total;
    TextInputLayout textInputLayout_name, textInputLayout_phone, textInputLayout_address, textInputLayout_sign;
    Button button;
    String name;
    String phone;
    String address;
    String sign;
    String total;
    String total_price;
    String med_name;
    String count;
    String med_image;
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    String id_order;
    String ud_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order_medicin);
        textView_total = findViewById(R.id.confirm_order_medicin_price);
        textInputLayout_name = findViewById(R.id.confirm_order_medicin_name);
        textInputLayout_phone = findViewById(R.id.confirm_order_medicin_phone);
        textInputLayout_address = findViewById(R.id.Patient_confirm_order_medicin_address);
        textInputLayout_sign = findViewById(R.id.Patient_confirm_order_medicin_sign);


        button = findViewById(R.id.confirmation_med);
//        Intent intent = getIntent();
//        total_price = intent.getStringExtra("total");
//        med_name = intent.getStringExtra("med_name");
//        count = intent.getStringExtra("count");
//        med_image = intent.getStringExtra("med_image");
//        Toast.makeText(this, total_price, Toast.LENGTH_SHORT).show();
        Bundle bundle = getIntent().getExtras();
        total_price = bundle.getString("total");
        med_name = bundle.getString("med_name");
        Toast.makeText(this, med_name, Toast.LENGTH_SHORT).show();
        count = bundle.getString("count");
        med_image = bundle.getString("med_image");
        textView_total.setText(total_price);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = textInputLayout_name.getEditText().getText().toString().trim();
                phone = textInputLayout_phone.getEditText().getText().toString().trim();
                address = textInputLayout_address.getEditText().getText().toString().trim();
                sign = textInputLayout_sign.getEditText().getText().toString().trim();
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(address) && TextUtils.isEmpty(sign)) {
                    textInputLayout_name.setError("enter your name");
                    textInputLayout_phone.setError("enter your phone");
                    textInputLayout_address.setError("enter your address");
                    textInputLayout_sign.setError("enter the  sign");
                } else if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(address) && !TextUtils.isEmpty(sign) && !TextUtils.isEmpty(total_price)) {
                    confram();
                }
            }
        });
//        reservation confirmation


//      firebaseFirestore.collection("pharmacy_sales").addSnapshotListener(new EventListener<QuerySnapshot>() {
//          @Override
//          public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
//
//              for (DocumentSnapshot snapshot:queryDocumentSnapshots.getDocuments()){
//
//                   id_order=snapshot.getId();
//                   //ud_us=snapshot.getId();
//                   ud_us= String.valueOf(snapshot.get("order_id"));
//              }
//          }
//      });
    }

    private void confram() {
        final String id = firebaseUser.getUid();
        final String order_id = String.valueOf(System.currentTimeMillis());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user_id", id);
        hashMap.put("order_id", order_id);
        hashMap.put("customer_name", name);
        hashMap.put("customer_phone", phone);
        hashMap.put("customer_address", address);
        hashMap.put("customer_sign", sign);
        hashMap.put("total_price", total_price);
//        hashMap.put("med_image", med_image);
//        hashMap.put("count", count);
//        hashMap.put("med_name", med_name);
//        firebaseFirestore.collection("Confirm_medication_reservation").document(order_id).set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//
//                if (task.isSuccessful()) {
//                    Toast.makeText(getApplicationContext(), "reservation confirmation", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getApplicationContext(), Home_Screen.class));
//                    finish();
//                } else {
//                    String error_message = task.getException().getLocalizedMessage();
//                    Log.i("error", error_message);
//                }
//            }
//        });
        firebaseFirestore.collection("Confirm_medication_reservation").document(id).set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(confirm_order_medicin.this, "done", Toast.LENGTH_SHORT).show();


                    startActivity(new Intent(getApplicationContext(), CartshopeFragment.class));
                }
            }
        });
    }
}
