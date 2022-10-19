package com.example.mya.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mya.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public abstract class LoginActivity2 extends AppCompatActivity {
    EditText welecomToWhatsapp, phoneNumber, code;
    Button sendCode, verify;
    FirebaseAuth auth;
    String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        auth = FirebaseAuth.getInstance();

         initUI();
         sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(phoneNumber.getText().toString()))
                    Toast.makeText(LoginActivity2.this, "Enter phone number", Toast.LENGTH_SHORT).show();
                else {
                    String number = phoneNumber.getText().toString();
                    Toast.makeText(LoginActivity2.this, "", Toast.LENGTH_SHORT).show();
                    sendCodeVerifycode(number);
                }


            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(code.getText().toString()))
                    Toast.makeText(LoginActivity2.this, "No code enter", Toast.LENGTH_SHORT).show();
                else
                    verifyCode(code.getText().toString());
            }
        });


    }

   

    private void initUI() {
        setContentView(R.layout.activity_login2);
        welecomToWhatsapp = findViewById(R.id.text1);
        phoneNumber = findViewById(R.id.Phone_num);
        code = findViewById(R.id.code1_txt);
        verify = findViewById(R.id.verify1);
        auth = FirebaseAuth.getInstance();


    }
    private void sendCodeVerifycode(String number) {

        PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = null;{
            PhoneAuthOptions options =
                    PhoneAuthOptions.newBuilder(auth)
                            .setPhoneNumber("+20" + number)       // Phone number to verify
                            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                            .setActivity(this)                 // Activity (for callback binding)
                            .setCallbacks(mCallbacks)        // OnVerificationStateChangedCallbacks
                            .build();
            PhoneAuthProvider.verifyPhoneNumber(options);

        }
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
                final String code = credential.getSmsCode();
                if (code != null)
                    verifyCode(code);


            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(LoginActivity2.this, "Verification Failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationId = s;

            }
        };
    }
    private void verifyCode(String code) {
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationId,code);
        signInByCredential(credential);

    }

    private void signInByCredential(PhoneAuthCredential credential){
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity2.this,"Login sucess",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity2.this,MainActivity.class));
                        }


                    }
                });
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(LoginActivity2.this, MainActivity.class));
            finish();
        }
    }
}








