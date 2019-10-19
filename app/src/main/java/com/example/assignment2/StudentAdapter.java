package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    private LayoutInflater mInflater;
    private List<Student> mData = new ArrayList<>();

    public StudentAdapter(Context context) {

        this.mInflater = LayoutInflater.from(context);
        this.mData.addAll(StudentRepository.getInstance().getStudents());
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.student_vh, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        List<Student> animals = StudentRepository.getInstance().getStudents();



        holder.tvName.setText(animals.get(position).name);

        holder.tvType.setText(String.valueOf(animals.get(position).id));

    }

    @Override
    public int getItemCount() {
        return StudentRepository.getInstance().getStudents().size();
    }

    public void update() {
        mData.clear();
        mData.addAll(StudentRepository.getInstance().getStudents());
        notifyDataSetChanged();
    }
}
