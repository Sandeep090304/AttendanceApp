package com.example.attendanceapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendanceapp.Adapter.AttendanceAdapter;
import com.example.attendanceapp.Adapter.AttendanceModel;
import com.example.attendanceapp.Admin.DBhelper;
import com.example.attendanceapp.Entity.Student;
import com.example.attendanceapp.R;

import java.util.ArrayList;
import java.util.List;

public class attendance_sheet extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AttendanceAdapter adapter;
    private List<AttendanceModel> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_sheet);

        //Database Fetch Data
        DBhelper dBhelper=new DBhelper(this);
        ArrayList<Student> arrSt=dBhelper.fetchstudent();

        // Initialize your data list (replace this with your actual data)
        dataList = new ArrayList<>();
        for(int i=0;i<arrSt.size();i++){
            dataList.add(new AttendanceModel(arrSt.get(i).getId(), arrSt.get(i).getName(), arrSt.get(i).getRollno()));
        }
//        dataList.add(new AttendanceModel("1", "John Doe", "123456"));
//        dataList.add(new AttendanceModel("2", "Jane Smith", "789012"));
//        dataList.add(new AttendanceModel("3", "Alice Johnson", "456789"));
//        dataList.add(new AttendanceModel("4", "Bob Anderson", "987654"));
//        dataList.add(new AttendanceModel("5", "Eva Williams", "654321"));
//        dataList.add(new AttendanceModel("6", "Michael Brown", "112233"));
//        dataList.add(new AttendanceModel("7", "Sophie Davis", "445566"));
//        dataList.add(new AttendanceModel("8", "Andrew Miller", "778899"));
//        dataList.add(new AttendanceModel("9", "Emma Taylor", "990011"));
//        dataList.add(new AttendanceModel("10", "Daniel Wilson", "334455"));
//        dataList.add(new AttendanceModel("11", "Olivia Martin", "667788"));
//        dataList.add(new AttendanceModel("12", "William Moore", "112233"));
//        dataList.add(new AttendanceModel("13", "Chloe Thompson", "445566"));
//        dataList.add(new AttendanceModel("14", "James White", "778899"));
//        dataList.add(new AttendanceModel("15", "Emily Harris", "990011"));
//        dataList.add(new AttendanceModel("16", "Alexander Turner", "334455"));
//        dataList.add(new AttendanceModel("17", "Grace Wilson", "667788"));
//        dataList.add(new AttendanceModel("18", "Mason Brown", "112233"));
//        dataList.add(new AttendanceModel("19", "Ava Jackson", "445566"));
//        dataList.add(new AttendanceModel("20", "Benjamin Miller", "778899"));
//        dataList.add(new AttendanceModel("21", "Mia Taylor", "990011"));
//        dataList.add(new AttendanceModel("22", "Elijah Wilson", "334455"));
//        dataList.add(new AttendanceModel("23", "Lily Moore", "667788"));
//        dataList.add(new AttendanceModel("24", "Logan Thompson", "112233"));
//        dataList.add(new AttendanceModel("25", "Sofia Davis", "445566"));
//        dataList.add(new AttendanceModel("26", "Isaac Turner", "778899"));
//        dataList.add(new AttendanceModel("27", "Olivia Parker", "990011"));
//        dataList.add(new AttendanceModel("28", "Henry Hughes", "334455"));
//        dataList.add(new AttendanceModel("29", "Sophia Carter", "667788"));
//        dataList.add(new AttendanceModel("30", "Liam Walker", "112233"));
        // Add more data as needed

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        // Initialize and set the adapter
        adapter = new AttendanceAdapter(this, dataList);
        recyclerView.setAdapter(adapter);

        // Other code for your activity
    }
}