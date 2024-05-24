package com.example.chattingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
     private EditText signemail;
     private EditText signpass;
     private Button create;
     private TextView google;
     private GoogleSignInOptions signInOptions;
   private GoogleSignInClient googleSignInclient;
   private static int code=100;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign2);
        firebaseAuth=FirebaseAuth.getInstance();
        signemail=findViewById(R.id.newmailid);
        signpass=findViewById(R.id.pass);
        create=findViewById(R.id.button2);
        google=findViewById(R.id.google);
        signInOptions= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
         googleSignInclient=GoogleSignIn.getClient(this,signInOptions);
         GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(this);



        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usermail=signemail.getText().toString().trim();
                String userpass=signpass.getText().toString().trim();

                if(usermail.isEmpty()&&userpass.isEmpty()){
                    Toast.makeText(sign.this, "FILL ALL FIELDS ", Toast.LENGTH_SHORT).show();
                }
                else {
                    firebaseAuth.createUserWithEmailAndPassword(usermail,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(sign.this, "Signup complete ", Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(sign.this,login.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(sign.this, "SIGN UP FAILED", Toast.LENGTH_SHORT).show();

                            }
                        }

                    });
                }





            }
        });
        //google sign i  functionality
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               signin();


            }
        });




    }

    private void signin() {
        Intent signintent=googleSignInclient.getSignInIntent();
        startActivityForResult(signintent,code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==code){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            handlesignresult(task);
            Intent intent=new Intent(sign.this,onboard.class);
            startActivity(intent);
            finish();
        }
    }

    private void handlesignresult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account=task.getResult(ApiException.class);
        } catch (ApiException e) {
            Toast.makeText(this, "welcome to app", Toast.LENGTH_SHORT).show();
        }
    }
}