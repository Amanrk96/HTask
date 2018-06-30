package com.example.hp.htask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CourceInfo> courseList;

    public CustomAdapter(Context context, ArrayList<CourceInfo> courceInfoList) {
        this.context = context;
        this.courseList = courceInfoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_citem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(courseList.get(position).getName());
        holder.des.setText(courseList.get(position).getDesc());
        holder.pack.setText(courseList.get(position).getPack());

        Glide.with(context).load(courseList.get(position).getImagelink()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, des, pack;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.course_image);
            name = itemView.findViewById(R.id.course_name);
            des = itemView.findViewById(R.id.course_des);
            pack = itemView.findViewById(R.id.course_pack);
        }
    }
}