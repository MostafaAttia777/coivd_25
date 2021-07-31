package com.MostafaCovied.Mostafacovied.Demerdash;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.MostafaCovied.Mostafacovied.Activity.Home_Screen;
import com.MostafaCovied.Mostafacovied.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class book_room_in_hospital extends AppCompatActivity {
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    RadioButton radioButton;
    RadioGroup group;
    TextInputLayout patient_name_edittext,patient_phone_edittext,patient_age_edittext,patient_address_edittext;
    Button button;
    String patient_name;
    String patient_phone;
    String patient_age;
    String patient_address;
    String kind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_room_in_hospital);
//    radioButton_female=findViewById(R.id.female);
//    radioButton_male=findViewById(R.id.male);
        patient_name_edittext = findViewById(R.id.book_room_Patient_name);
        patient_phone_edittext=findViewById(R.id.book_room_Patient_phone);
        patient_age_edittext=findViewById(R.id.book_room_Patient_age);
        patient_address_edittext=findViewById(R.id.book_room_Patient_address);
        button = findViewById(R.id.confirmation_Patient_room);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patient_name = patient_name_edittext.getEditText().getText().toString().trim();
                patient_phone = patient_phone_edittext.getEditText().getText().toString().trim();
                patient_age = patient_age_edittext.getEditText().getText().toString().trim();
                patient_address = patient_address_edittext.getEditText().getText().toString().trim();
                if (TextUtils.isEmpty(patient_name) && TextUtils.isEmpty(patient_age) && TextUtils.isEmpty(patient_phone)&& TextUtils.isEmpty(patient_address)) {
                    Toast.makeText(getBaseContext(), "fill your data", Toast.LENGTH_SHORT).show();
                    patient_phone_edittext.setError("Enter your phone");
                    patient_name_edittext.setError("Enter your name");
                    patient_age_edittext.setError("Enter your age");
                    patient_address_edittext.setError("Enter your address");
                    return;
                } else if (!TextUtils.isEmpty(patient_name) && !TextUtils.isEmpty(patient_age) && !TextUtils.isEmpty(patient_phone) && !TextUtils.isEmpty(patient_address)) {
                    confirmation(); }
            }
        });

        group = findViewById(R.id.group_rad);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                radioButton = findViewById(id);
                kind = radioButton.getText().toString();
                Toast.makeText(book_room_in_hospital.this, kind, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void confirmation() {
        final String id = firebaseUser.getUid();
        String order_id = String.valueOf(System.currentTimeMillis());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user_id", id);
        hashMap.put("order_id", order_id);
        hashMap.put("patient_name", patient_name);
        hashMap.put("patient_phone", patient_phone);
        hashMap.put("patient_age", patient_age);
        hashMap.put("patient_address", patient_address);
        hashMap.put("kind",kind);

        firebaseFirestore.collection("Hospital_Confirm_reservation").document(id).set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(), Home_Screen.class));
                    Toast.makeText(book_room_in_hospital.this, "reservation is done", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    String error_message = task.getException().getLocalizedMessage();
                    Log.i("error", error_message);
                }
            }
        });
    }
}
