package com.example.attendanceapp.Subject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.attendanceapp.R;
import com.example.attendanceapp.Studentf.AddStudent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddSubject extends AppCompatActivity {
    FloatingActionButton fab;
    RecyclerView recyclerView;
    ClassAdaptor classAdaptor;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Classitem> classitems=new ArrayList<>();
    Toolbar toolbar;

    Button cancel;
    Button add;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab=findViewById(R.id.add);
        fab.setOnClickListener(v->show());
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        classAdaptor=new ClassAdaptor(this.classitems);
        recyclerView.setAdapter(classAdaptor);classAdaptor.setOnItemClickListener(position -> gotoItemActivity(position));
        settooolbar();
    }

    private void settooolbar() {
        toolbar=findViewById(R.id.addtoolbar);
        TextView title=toolbar.findViewById(R.id.title_toolbar);
        TextView subtitle=toolbar.findViewById(R.id.subtitle_toolbar);
        ImageButton back=toolbar.findViewById(R.id.back);
        ImageButton save=toolbar.findViewById(R.id.save);
        title.setText("ATTENDANCE APP(CUTM)");
        subtitle.setText("Domain list with subject");
//       back.setVisibility(View.INVISIBLE);
        save.setVisibility(View.INVISIBLE);
    }

    private void gotoItemActivity(int position) {
        Intent intent=new Intent(this, AddStudent.class);
        intent.putExtra("DomainName",classitems.get(position).getDomainname());
        intent.putExtra("SubjectName",classitems.get(position).getSubjentName());
        intent.putExtra("position",position);
        startActivities(new Intent[]{intent});
    }

    private  void show(){
        MyDialog dialog=new MyDialog();
        dialog.show(getSupportFragmentManager(),MyDialog.CLASS_ADD_DIALOG);
        dialog.setListner((domainName,subjectName)->addClass(domainName,subjectName));
    }
    private void  addClass(String domainName,String subjectName){

        classitems.add(new Classitem(domainName,subjectName));
        classAdaptor.notifyDataSetChanged();
    }
}