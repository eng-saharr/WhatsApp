package com.example.mya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mya.ui.MainActivity;
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

public class LoginActivity extends AppCompatActivity {

    EditText phoneNo,smsCode;
    Button sendBtn,verifyBtn;
    FirebaseAuth auth;
    String VerificationID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phoneNo = findViewById(R.id.input_phone);
        sendBtn = findViewById(R.id.send_btn);
        verifyBtn = findViewById(R.id.done_btn);
        smsCode = findViewById(R.id.code_txt);

        auth = FirebaseAuth.getInstance();


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(phoneNo.getText().toString()))
                {
                    Toast.makeText(LoginActivity.this, "Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String phoneNumber = phoneNo.getText().toString();
                    sendVerficationCode(phoneNumber);

                }

            }
        });

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(smsCode.getText().toString()))
                {
                    Toast.makeText(LoginActivity.this, "Wrong OTP", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    verifycode(smsCode.getText().toString());
                }
            }
        });
    }



    private void sendVerficationCode(String phoneNumber) {

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber("+20" + phoneNumber)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallbacks)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential)
        {
            final String code = credential.getSmsCode();
            if (code != null)
            {
                verifycode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e)
        {

            Toast.makeText(LoginActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCodeSent(@NonNull String s,
                               @NonNull PhoneAuthProvider.ForceResendingToken token) {

            super.onCodeSent(s,token);
            VerificationID = s;

        }
    };

    private void verifycode(String code)
    {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(VerificationID,code);
        signinbyCredentials(credential);
    }


    private void signinbyCredentials(PhoneAuthCredential credential)
    {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null)
        {
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}