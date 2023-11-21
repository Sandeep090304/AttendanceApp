package com.example.attendanceapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendanceapp.R;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {

    private Context context;
    private List<AttendanceModel> dataList;
    private AdapterView.OnItemClickListener onItemClickListener;

    public AttendanceAdapter(Context context, List<AttendanceModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.attendance_sheet_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AttendanceModel item = dataList.get(position);

        // Set your data to the views in the ViewHolder
        holder.textViewSlNo.setText(String.valueOf(item.getSlNo()));
        holder.textViewStudentName.setText(item.getStudentName());
        holder.textViewRegNo.setText(item.getRegNo());

        /// Handle checkbox state changes
        holder.checkBoxAttendance.setOnCheckedChangeListener(null); // Remove previous listener to avoid callback conflicts

        holder.checkBoxAttendance.setChecked(item.isPresent());

        // Set a tag to identify the position of the item associated with the checkbox
        holder.checkBoxAttendance.setTag(position);

        holder.checkBoxAttendance.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Update your data model based on checkbox state
            int adapterPosition = (int) buttonView.getTag();
            dataList.get(adapterPosition).setPresent(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSlNo;
        TextView textViewStudentName;
        TextView textViewRegNo;
        CheckBox checkBoxAttendance;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSlNo = itemView.findViewById(R.id.sl_no);
            textViewStudentName = itemView.findViewById(R.id.stu_name);
            textViewRegNo = itemView.findViewById(R.id.reg_no);
            checkBoxAttendance = itemView.findViewById(R.id.checkBox);
        }
    }
}
