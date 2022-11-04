package com.example.mya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
    TextView whatsText,phoneNamber,code;
    Button   sendCode,sure;
    FirebaseAuth auth;
    String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth=FirebaseAuth.getInstance();
        initUI();
        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(phoneNamber.getText().toString()))
                    Toast.makeText(LoginActivity.this, "Enter your phonenumber", Toast.LENGTH_SHORT).show();
                else {
                    String number = phoneNamber.getText().toString();
                    Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                    sendVerifyCode(number);
                    
                }
            }
        });
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(code.getText().toString()))
                    Toast.makeText(LoginActivity.this, "no code entered", Toast.LENGTH_SHORT).show();
                else {
                    sure(code.getText().toString());
                }
                    
            }
        });
    }

    private void sendVerifyCode(String number) {
        String phoneNumber;
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber("+20"+number)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mcallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mcallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
            final String code=credential.getSmsCode();
            if (code!= null)
                sure(code);
            
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(LoginActivity.this, "verification failed", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s ;
        }
    };
    private void sure(String code) {
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationId,code);
        signInByCredential(credential);
    }

    private void signInByCredential(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"login successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }

                    }
                });
    }


    private void initUI() {
        whatsText=findViewById(R.id.what_txt);
        phoneNamber=findViewById(R.id.user_phone);
        code=findViewById(R.id.code_txt);
        sendCode=findViewById(R.id.send_bt);
        sure=findViewById(R.id.verify);
        


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
    }
}