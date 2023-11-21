package com.example.attendanceapp.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendanceapp.R;

public class studentForm extends AppCompatActivity {
    Button back;
    DBhelper dBhelper;
    Button adddata;
    EditText eTName,etRoll,etSubject,etID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        back=findViewById(R.id.buttonback);
        adddata=findViewById(R.id.buttonadd);
        dBhelper=new DBhelper(this);
        eTName=(EditText) findViewById(R.id.editName);
        etRoll=(EditText) findViewById(R.id.editTextRollNo);
        etSubject=(EditText) findViewById(R.id.editSubject);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), AdminDashboard.class);
                startActivity(intent);
            }
        });

        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted=dBhelper.inserdata(eTName.getText().toString(),
                        etRoll.getText().toString(),
                        etSubject.getText().toString());
                if(isInserted==true){
                    Toast.makeText(studentForm.this,"Data Inserted Successfully",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(studentForm.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}