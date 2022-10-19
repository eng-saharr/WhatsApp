package com.example.mya.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mya.R;
import com.example.mya.data.model.UserStatusModel;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusHolder> {
    private List<UserStatusModel>stutas;

    public StatusAdapter(List<UserStatusModel> stutas) {
        this.stutas = stutas;
    }

    @NonNull
    @Override
    public StatusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_status_layout,parent,false);
        return new StatusHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusHolder holder, int position) {
        UserStatusModel userStatusModel=stutas.get(position);
        holder.userName.setText(userStatusModel.getUserName());
        holder.statusTime.setText(userStatusModel.getStatusTime());
        holder.userImage.setImageResource(userStatusModel.getUserImage());

    }

    @Override
    public int getItemCount() {
        if(stutas != null)
            return stutas.size();
        return 0;
    }

    static class StatusHolder extends RecyclerView.ViewHolder{

        ImageView userImage;
        TextView userName;
        TextView statusTime;

        public StatusHolder(@NonNull View itemView) {
            super(itemView);
            userImage=itemView.findViewById(R.id.status_img);
            userName=itemView.findViewById(R.id.user_name_status);
            statusTime=itemView.findViewById(R.id.status_time);


        }
    }



}
