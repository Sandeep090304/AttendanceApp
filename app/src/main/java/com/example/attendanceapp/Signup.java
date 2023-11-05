package com.example.attendanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendanceapp.Entity.Faculty;
import com.example.attendanceapp.LoginPage;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    TextInputLayout name,email,pass;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=findViewById(R.id.username);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);

    }
    public void main(View view){
        Intent intent=new Intent(Signup.this,LoginPage.class);
        startActivity(intent);
        finish();
    }
    public void main1(View view){
        String a=name.getEditText().getText().toString();
        String b=email.getEditText().getText().toString();
        String c=pass.getEditText().getText().toString();
        if(!a.isEmpty())
        {
            name.setError(null);
            name.setErrorEnabled(false);
            if (!b.isEmpty())
            {
                email.setError(null);
                email.setErrorEnabled(false);

                if (!c.isEmpty()) {
                    pass.setError(null);
                    pass.setErrorEnabled(false);
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    reference = firebaseDatabase.getReference("datauser");
                    String a1 = name.getEditText().getText().toString();
                    String b1=email.getEditText().getText().toString();
                    String c1=pass.getEditText().getText().toString();
                    Faculty storingdata = new Faculty(a1,b1,c1);
                    reference.child(a1).setValue(storingdata);
                    Toast.makeText(getApplicationContext(), "Resister successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(), LoginPage.class);
                    startActivity(intent);
                    finish();

                } else {
                    pass.setError("please enter the password");
                }
            }
            else{
                email.setError("please enter the email");
            }
        }
        else{
            name.setError("please enter the name");
        }




    }
}