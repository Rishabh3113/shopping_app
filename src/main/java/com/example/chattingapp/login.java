package com.example.chattingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class login extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
     private EditText logemail;
     private EditText logpass;
     private Button log2;
     private Button sign2;
     TextView forgotpass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);
        firebaseAuth=FirebaseAuth.getInstance();
        logemail=findViewById(R.id.logemail);
        logpass=findViewById(R.id.logpass);
        log2=findViewById(R.id.LOG2);
        sign2=findViewById(R.id.sign2);
        forgotpass=findViewById(R.id.textView3);


        sign2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login.this,sign.class);
                startActivity(intent);
                finish();
            }
        });

        log2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail=logemail.getText().toString().trim();
                String pass=logpass.getText().toString().trim();

                if(!useremail.isEmpty()&&Patterns.EMAIL_ADDRESS.matcher(useremail).matches()){
                    if (!pass.isEmpty()) {
                        firebaseAuth.signInWithEmailAndPassword(useremail,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(login.this, "Welcome to shopy india app", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(login.this,onboard.class);
                                startActivity(intent);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(login.this, "try sign in with google", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }


                    }
            }






        });
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(login.this);
                View dialogview=getLayoutInflater().inflate(R.layout.forget,null);
                EditText emailbox=dialogview.findViewById(R.id.registermail);
                Button reset=dialogview.findViewById(R.id.reset);
                Button cancel=dialogview.findViewById(R.id.cancel);
                builder.setView(dialogview);
                AlertDialog dialog= builder.create();
                reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String usermail=emailbox.getText().toString();
                        if(TextUtils.isEmpty(usermail)&&Patterns.EMAIL_ADDRESS.matcher(usermail).matches()){
                            Toast.makeText(login.this, "enter your registered email", Toast.LENGTH_SHORT).show();
                        }
                       firebaseAuth.sendPasswordResetEmail(usermail).addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if(task.isSuccessful()){
                                   Toast.makeText(login.this, "check your mail", Toast.LENGTH_SHORT).show();
                                   dialog.dismiss();
                               }
                               else{
                                   Toast.makeText(login.this, "unable to send mail", Toast.LENGTH_SHORT).show();

                               }
                           }
                       });
                    }
                });
                //7.1.3 to 7.4.2

                //cancel button handling
 cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                if (dialog.getWindow()!=null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }
                dialog.show();
            }
        });


    }
}