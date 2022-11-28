package com.example.mya.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mya.R;
import com.example.mya.data.model.ChatModel;

import java.util.ArrayList;

import javax.xml.transform.Templates;

public class UserChatAdapter extends RecyclerView.Adapter<UserChatAdapter.UserChatHolder> {

      ArrayList<ChatModel>list;

    public void setList(ArrayList<ChatModel> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public UserChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_chat,parent,false);
        return new UserChatHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserChatHolder holder, int position) {
         ChatModel chatModel=list.get(position);
         holder.textView.setText(chatModel.getMessage());


    }

    @Override
    public int getItemCount() {

        return list == null? 0:list.size();
    }

   static class UserChatHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public UserChatHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tex_messagesend);
        }
    }

}
