package com.example.attendanceapp.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendanceapp.R;

public class StudentForm2 extends AppCompatActivity {
    Button back;
    DBhelper dBhelper;
    Button del;
    EditText eetID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form2);
        dBhelper=new DBhelper(this);
        back=findViewById(R.id.buttonback);
        del=findViewById(R.id.buttonadd);
        eetID=(EditText)findViewById(R.id.editId);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), AdminDashboard.class);
                startActivity(intent);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int delRows=dBhelper.delData(eetID.getText().toString());
                if(delRows>0)
                    Toast.makeText(StudentForm2.this, "Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(StudentForm2.this,"Data  not Deleted",Toast.LENGTH_LONG).show();
            }
        });
    }
}