package com.example.attendanceapp.Admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.attendanceapp.LoginPage;
import com.example.attendanceapp.R;
import com.example.attendanceapp.Studentf.AddStudent;

public class AdminDashboard extends AppCompatActivity {
    Button buttonadd;
    Button buttondel;
    Button buttonview;
    Button buttonupdate;
    DBhelper dBhelper;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_daashboard);
        dBhelper=new DBhelper(this);
        buttonadd=findViewById(R.id.buttonadd);
        imageView=findViewById(R.id.img_view_user);
        buttonupdate=findViewById(R.id.buttonupdate);
        buttondel=findViewById(R.id.buttondel);
        buttonview=findViewById(R.id.buttonview);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
            }
        });
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(AdminDashboard.this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), studentForm.class);
                startActivity(intent);
            }
        });
        buttonupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(AdminDashboard.this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), StudentForm3.class);
                startActivity(intent);
            }
        });
        buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(AdminDashboard.this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), StudentForm2.class);
                startActivity(intent);
            }
        });


        viewData();



    }
    public void viewData() {
        buttonview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=dBhelper.getData();
                if(res.getCount()==0){
                    showMsg("Error","No Data is Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n");
                    buffer.append("Name :" + res.getString(1) + "\n");
                    buffer.append("RollNo :" + res.getString(2) + "\n");
                    buffer.append("Subject :" + res.getString(3) + "\n\n");
                }
                showMsg("Data",buffer.toString());
            }
        });
    }

    public void showMsg(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}