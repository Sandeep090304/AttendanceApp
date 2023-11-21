package com.example.attendanceapp.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendanceapp.R;

public class StudentForm3 extends AppCompatActivity {
    Button button;
    Button update;
    EditText eTName,etRoll,etSubject,etID;
    DBhelper dBhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form3);
        button=findViewById(R.id.buttonback);
        update=findViewById(R.id.buttonupdate);
        dBhelper=new DBhelper(this);
        eTName=(EditText) findViewById(R.id.editName);
        etRoll=(EditText) findViewById(R.id.editTextRollNo);
        etSubject=(EditText) findViewById(R.id.editSubject);
        etID=(EditText)findViewById(R.id.id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), AdminDashboard.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate=dBhelper.updateData(etID.getText().toString(),
                        eTName.getText().toString(),
                        etRoll.getText().toString(),
                        etSubject.getText().toString());
                if(isUpdate==true)
                    Toast.makeText(StudentForm3.this, "Data Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(StudentForm3.this,"Data  not Updated",Toast.LENGTH_LONG).show();
            }
        });
    }
}