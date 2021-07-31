package com.MostafaCovied.Mostafacovied.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.MostafaCovied.Mostafacovied.Activity.Home_Screen;
import com.MostafaCovied.Mostafacovied.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity {

    TextView textView_create_Account;
    TextInputLayout textInputLayout_email;
    TextInputLayout textInputLayout_password;
    TextView textView_btn_login;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        textView_create_Account = findViewById(R.id.createAccuont);
        textInputLayout_email = findViewById(R.id.my_textbox_Email);
        textInputLayout_password = findViewById(R.id.my_textbox_password);
        textView_btn_login = findViewById(R.id.btn_login);
        //    final String ministry_of_Health = firebaseAuth.getCurrentUser().getEmail();
        textView_create_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create_Account();
            }
        });
        textView_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textInputLayout_email.getEditText().getText().toString();
                String password = textInputLayout_password.getEditText().getText().toString();

                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                    textInputLayout_password.setError("Enter your password");
                    textInputLayout_email.setError("Enter your Email");
                } else if (TextUtils.isEmpty(email)) {

                    textInputLayout_email.setError("Enter your Email");
                } else if (TextUtils.isEmpty(password)) {
                    textInputLayout_password.setError("Enter your password");
                }

                else if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    Login_Op();
                }
            }

            ;
        });

    }

    private void Login_Op() {
        String email = textInputLayout_email.getEditText().getText().toString();
        String password = textInputLayout_password.getEditText().getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginScreen.this, "Welcome", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Home_Screen.class));
                    finish();
                }
            }
        });
    }

    private void create_Account() {
        startActivity(new Intent(getApplicationContext(), CreateAccount.class));
    }
}
