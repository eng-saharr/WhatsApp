package com.example.mya.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mya.R;
import com.example.mya.data.model.UserCalls;

import java.util.List;

public class CallsAdapter extends RecyclerView.Adapter<CallsAdapter.CallsHolder> {
    private List<UserCalls>calls;

    public CallsAdapter(List<UserCalls> calls) {
        this.calls = calls;
    }

    @NonNull
    @Override
    public CallsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_calls_layout,parent,false);
        return new CallsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallsHolder holder, int position) {
        UserCalls userCalls=calls.get(position);
        holder.userName.setText(userCalls.getUserName());
        holder.callsTime.setText(userCalls.getCallTime());
        holder.userImage.setImageResource(userCalls.getUserImage());

    }

    @Override
    public int getItemCount() {
        if(calls !=null)
            return calls.size();
        return 0;
    }


    static class CallsHolder extends RecyclerView.ViewHolder{
        ImageView userImage;
        TextView userName;
        TextView callsTime;


        public CallsHolder(@NonNull View itemView) {
            super(itemView);
            userImage=itemView.findViewById(R.id.call_img);
            userName=itemView.findViewById(R.id.user_name_call);
            callsTime=itemView.findViewById(R.id.call_time);
        }
    }



}
