package com.example.attendanceapp.Subject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendanceapp.R;

import java.util.ArrayList;

public class ClassAdaptor extends RecyclerView.Adapter<ClassAdaptor.ClassViewHolder> {
    Context context;
    ArrayList<Classitem> classitems;
    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ClassAdaptor(Context context, ArrayList<Classitem> classitems) {
        this.classitems = classitems;
        this.context=context;
    }

    public ClassAdaptor(ArrayList<Classitem> classitems) {
        this.classitems=classitems;
    }


    public static  class ClassViewHolder extends RecyclerView.ViewHolder{
        TextView DomainName;
        TextView subjectName;
        public ClassViewHolder(@NonNull View itemView,OnItemClickListener onItemClickListener) {
            super(itemView);
            DomainName=itemView.findViewById(R.id.domain);
            subjectName=itemView.findViewById(R.id.edt02);
            itemView.setOnClickListener(v->onItemClickListener.onClick(getAdapterPosition()));
        }
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item,parent,false);
        return new ClassViewHolder(itemView,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        holder.DomainName.setText(classitems.get(position).getDomainname());
        holder.subjectName.setText(classitems.get(position).getSubjentName());
    }

    @Override
    public int getItemCount() {
        return classitems.size();
    }
}
