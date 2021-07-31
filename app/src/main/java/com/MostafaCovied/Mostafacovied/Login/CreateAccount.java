package com.MostafaCovied.Mostafacovied.Login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.MostafaCovied.Mostafacovied.Models.Model_Regastar;
import com.MostafaCovied.Mostafacovied.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class CreateAccount extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    FirebaseAuth auth = FirebaseAuth.getInstance();
    StorageReference storageReference = FirebaseStorage.getInstance().getReference("Users_Images");
    DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference("Users_Accounts");
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    Spinner spinner;
    String city;
    ImageButton imageButton;
    CircleImageView circleImageView_regstar;
    TextInputLayout editText_name, editText_email, editText_password, editText_phone, editText_street;
    TextView textView_btn_create_account;
    final private int REQUST_CODE = 1;
    Model_Regastar model_regastar;
    Uri image_uri = null;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        imageButton = findViewById(R.id.cma_up_load);
        circleImageView_regstar = findViewById(R.id.my_image_regster);
        editText_name = findViewById(R.id.txt_name);
        editText_email = findViewById(R.id.txt_email);
        editText_password = findViewById(R.id.txt_password);
        editText_phone = findViewById(R.id.txt_phone);
        editText_street = findViewById(R.id.Street_address);
        textView_btn_create_account = findViewById(R.id.create_account);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_galary();
            }
        });
        spinner = findViewById(R.id.my_spns);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

        textView_btn_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText_name.getEditText().getText().toString();
                String email = editText_email.getEditText().getText().toString();
                String passord = editText_password.getEditText().getText().toString();
                String phone = editText_phone.getEditText().getText().toString();
                String street = editText_street.getEditText().getText().toString();
                if (image_uri == null) {
                    Toast.makeText(getBaseContext(), "Photos must be selected", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(passord) && TextUtils.isEmpty(email) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(street)) {
                    editText_name.setError("enter your name");
                    editText_phone.setError("enter your phone");
                    editText_password.setError("enter your password");
                    editText_email.setError("enter your email");
                    editText_street.setError("enter your street address");
                } else if (TextUtils.isEmpty(email) && TextUtils.isEmpty(name)) {
                    editText_email.setError("enter your email");
                    editText_name.setError("enter your name");

                } else if (TextUtils.isEmpty(phone) && TextUtils.isEmpty(passord)) {
                    editText_phone.setError("enter your phone");
                    editText_password.setError("enter your password");
                } else if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(passord)) {
                    createAccount();
                }
            }
        });
    }

    private void createAccount() {
        final String name = editText_name.getEditText().getText().toString();
        final String email = editText_email.getEditText().getText().toString();
        final String passord = editText_password.getEditText().getText().toString();
        final String phone = editText_phone.getEditText().getText().toString();
        final String street = editText_street.getEditText().getText().toString();
        model_regastar = new Model_Regastar(name, email, phone, street);
        auth.createUserWithEmailAndPassword(email, passord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CreateAccount.this, "created", Toast.LENGTH_SHORT).show();
                    uid=auth.getCurrentUser().getUid();
                    storageReference.child("photos_Covid").child(uid + "jpg").putFile(image_uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull final Task<UploadTask.TaskSnapshot> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(CreateAccount.this, "uploaded", Toast.LENGTH_SHORT).show();
                                get_image_link(); } }
                    }); } else { } }}); }
    private void get_image_link() {
        storageReference.child("photos_Covid").child(uid + "jpg").getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()){
                    String image_link=task.getResult().toString();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("name", model_regastar.getName());
                    hashMap.put("email", model_regastar.getEmail());
                    hashMap.put("phone", model_regastar.getPhone());
                    hashMap.put("street", model_regastar.getAddress());
                    hashMap.put("city", city);
                    hashMap.put("image_link",image_link);
                    hashMap.put("user_id",uid);
                    firebaseFirestore.collection("Users").document(uid).set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(CreateAccount.this, "done", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), LoginScreen.class));
                                finish();
                            }
                            else {
                                String e = task.getException().getMessage();
                                Toast.makeText(CreateAccount.this, e, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }

    private void open_galary() {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                image_uri = result.getUri();
                circleImageView_regstar.setImageURI(image_uri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        city = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
