package com.example.attendanceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.attendanceapp.Admin.AdminDashboard;
import com.example.attendanceapp.Dashboard.Dashboard;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {
    Button signup,login;
    TextInputLayout u_var,p_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        signup=findViewById(R.id.signup);
        login=findViewById(R.id.login);
        u_var=findViewById(R.id.username);
        p_var=findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=u_var.getEditText().getText().toString();
                String pass=p_var.getEditText().getText().toString();
                if(!user.isEmpty())
                {
                    u_var.setError(null);
                    u_var.setErrorEnabled(false);
                    if(!pass.isEmpty()){
                        p_var.setError(null);
                        p_var.setErrorEnabled(false);
                        final String u_d=u_var.getEditText().getText().toString();
                        final String p_d=p_var.getEditText().getText().toString();
                        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference=firebaseDatabase.getReference("datauser");
                        Query check=databaseReference.orderByChild("name").equalTo(u_d);
                        check.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    u_var.setError(null);
                                    u_var.setErrorEnabled(false);
                                    String pass=snapshot.child(u_d).child("password").getValue(String.class);
                                    if(pass.equals(p_d)){
                                        p_var.setError(null);
                                        p_var.setErrorEnabled(false);
                                        Toast.makeText(LoginPage.this, "login successfully", Toast.LENGTH_SHORT).show();
                                        String sp = u_var.getEditText().getText().toString();

                                        Intent intent=new Intent(getApplicationContext(), Dashboard.class);
                                        intent.putExtra("name", sp);
                                        startActivity(intent);
                                        finish();

                                    }
                                    else{
                                        p_var.setError("wrong password");
                                    }
                                }
                                else if(user.equals("admin")&&pass.equals("admin")){
                                    Toast.makeText(LoginPage.this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(), AdminDashboard.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    u_var.setError("user does not exist");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                    else {
                        p_var.setError("please enter the password");
                    }
                }
                else{
                    u_var.setError("please enter the user name");
                }

            }
        });









        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginPage.this,Signup.class);
                startActivity(intent);

            }
        });


    }
}