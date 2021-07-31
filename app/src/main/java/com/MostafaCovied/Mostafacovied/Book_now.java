package com.MostafaCovied.Mostafacovied;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.MostafaCovied.Mostafacovied.Activity.Abd_Lab;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Book_now extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String time;
    TextView textView_scan_name, textView_scan_price, textView_scan_waiting_time;
    TextInputLayout editText_patient_name, editText_patient_age, editText_patient_phone;
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    String scan_name;
    String scan_price;
    String waiting_time;
    Button button;
    String patient_name;
    String patient_phone;
    String patient_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);
        spinner = findViewById(R.id.my_spniner_for_time);
        textView_scan_name = findViewById(R.id.resrve_scan_name);
        textView_scan_price = findViewById(R.id.resrve_scan_price);
        textView_scan_waiting_time = findViewById(R.id.resrve_scan_waiting_time);
        editText_patient_phone=findViewById(R.id.Patient_phone);
        editText_patient_name=findViewById(R.id.Patient_name);
        editText_patient_age=findViewById(R.id.Patient_age);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.book_time, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
        Intent intent_get_data = getIntent();
        scan_name = intent_get_data.getStringExtra("name");
        scan_price = intent_get_data.getStringExtra("price");
        waiting_time = intent_get_data.getStringExtra("waiting_time");
        textView_scan_name.setText(scan_name);
        textView_scan_price.setText(scan_price);
        textView_scan_waiting_time.setText(waiting_time);
        button = findViewById(R.id.confirmation);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              patient_name = editText_patient_name.getEditText().getText().toString().trim();
             patient_phone = editText_patient_phone.getEditText().getText().toString().trim();
                 patient_age = editText_patient_age.getEditText().getText().toString().trim();
                if (TextUtils.isEmpty(patient_name) && TextUtils.isEmpty(patient_age) && TextUtils.isEmpty(patient_phone)) {
                    Toast.makeText(getBaseContext(), "fill your data", Toast.LENGTH_SHORT).show();
                    editText_patient_phone.setError("Enter your phone");
                    editText_patient_name.setError("Enter your name");
                    editText_patient_age.setError("Enter your age");
                    return;
                } else if (!TextUtils.isEmpty(patient_name) && !TextUtils.isEmpty(patient_age) && !TextUtils.isEmpty(patient_phone)) {
                    confirmation(); }
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

        firebaseFirestore.collection("Lab_Confirm_reservation").document(id).set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Book_now.this, "reservation confirmation", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Abd_Lab.class));
                    finish();
                } else {
                    String error_message = task.getException().getLocalizedMessage();
                    Log.i("error", error_message);
                }
            }
        });
        final String user_id = firebaseUser.getUid();
        String scan_id = String.valueOf(System.currentTimeMillis());
        HashMap<String, Object> hashMap_ = new HashMap<>();
        hashMap_.put("user_id", user_id);
        hashMap_.put("order_id", order_id);
        hashMap_.put("scan_name", scan_name);
        hashMap_.put("scan_price", scan_price);
        hashMap_.put("scan_waiting_time", waiting_time);
        hashMap_.put("scan_reservation_time", time);

        firebaseFirestore.collection("Lab_scan_details").document(scan_id).set(hashMap_);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        time = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, time + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void confirmation(View view) {


    }
}
