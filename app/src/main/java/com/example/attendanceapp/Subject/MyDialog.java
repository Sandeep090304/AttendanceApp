package com.example.attendanceapp.Subject;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.attendanceapp.R;

public class MyDialog extends DialogFragment {
    public static final String CLASS_ADD_DIALOG = "AddClass";
    public static final String STUDENT_ADD_DIALOG = "AddStudent";
   private onClickListner listner;
    public interface  onClickListner{
        void onClick(String text1,String text2);
    }

    public void setListner(onClickListner listner) {
        this.listner = listner;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@NonNull Bundle saveInstanceState) {
        Dialog dialog = null;
        if (getTag().equals(CLASS_ADD_DIALOG)) dialog = getAddClassDialog();
        if (getTag().equals(STUDENT_ADD_DIALOG)) dialog = getAddStudentDialog();
        return dialog;
    }

    private Dialog getAddStudentDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        builder.setView(view);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView title=view.findViewById(R.id.titleDialog);
        title.setText("Add New Student");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText regd_edt = view.findViewById(R.id.est01);
        regd_edt.setHint("Enter Registration Number");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText name_edt = view.findViewById(R.id.edt02);
        name_edt.setHint("Enter Student Name");
        Button cancel = view.findViewById(R.id.cancel);
        Button add = view.findViewById(R.id.plus);
        cancel.setOnClickListener(v ->dismiss());
        add.setOnClickListener(v -> {
            String regd=regd_edt.getText().toString();
            String name=name_edt.getText().toString();
            regd_edt.setText(String.valueOf(Integer.parseInt(regd)+1));
            listner.onClick(regd,name);
        });
        return builder.create();
    }

    private Dialog getAddClassDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        builder.setView(view);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView title=view.findViewById(R.id.titleDialog);
        title.setText("Add New Class");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText domain_edt = view.findViewById(R.id.est01);
        domain_edt.setHint("Enter Domain Name");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText subject_edt = view.findViewById(R.id.edt02);
        subject_edt.setHint("Enter Subject Name");
        Button cancel = view.findViewById(R.id.cancel);
        Button add = view.findViewById(R.id.plus);
        cancel.setOnClickListener(v ->dismiss());
        add.setOnClickListener(v -> {
            String DomainName=domain_edt.getText().toString();
            String SubjectName=subject_edt.getText().toString();
            listner.onClick(DomainName,SubjectName);
            dismiss();

        });
        return builder.create();
    }

}
