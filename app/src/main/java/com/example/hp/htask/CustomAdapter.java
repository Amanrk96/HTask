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

import java.util.List;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context ;
    private List<CourceInfo> courceInfoList ;

    public CustomAdapter(Context context, List<CourceInfo> courceInfoList) {
        this.context = context;
        this.courceInfoList = courceInfoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item,parent,false);
        return new ViewHolder(itemView) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(courceInfoList.get(position).getName());
        holder.des.setText(courceInfoList.get(position).getDesc());
        holder.pack.setText(courceInfoList.get(position).getPack());
        Glide.with(context).load(courceInfoList.get(position).getImagelink()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return courceInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image ;
        TextView name , des , pack ;
        public ViewHolder(View itemView) {
            super(itemView);
            image =(ImageView)itemView.findViewById(R.id.cource_image);
            name = (TextView)itemView.findViewById(R.id.cource_name);
            des = (TextView)itemView.findViewById(R.id.cource_des);
            pack = (TextView)itemView.findViewById(R.id.cource_pack);
        }
    }
}
