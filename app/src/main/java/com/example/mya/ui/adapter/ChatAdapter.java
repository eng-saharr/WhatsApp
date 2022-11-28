package com.example.mya.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mya.R;
import com.example.mya.data.model.UserModel;

import java.util.List;

public  class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {

    private   List<UserModel> users;
    private  ChatClickListener chatClickListener;
    public ChatAdapter(List<UserModel> users, ChatClickListener chatClickListener) {

        this.users = users;
        this.chatClickListener=chatClickListener;






    }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat_layout, parent, false);
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, int position) {
        UserModel userModel = users.get(position);
        holder.userName.setText(userModel.getUserName());
        holder.chatContent.setText(userModel.getChatContent());
        holder.userImage.setImageResource(userModel.getUserImage());

    }

    @Override
    public int getItemCount() {
        if (users != null)
            return users.size();
        return 0;
    }

    class ChatHolder extends RecyclerView.ViewHolder {
        ImageView userImage;
        TextView userName;
        TextView chatContent;



        public ChatHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.user_img);
            userName = itemView.findViewById(R.id.user_name);
            chatContent = itemView.findViewById(R.id.chat_content);

           itemView.getRootView().setOnClickListener(new View.OnClickListener() {


               @Override
               public void onClick(View view) {
                  chatClickListener.onChatClick(users.get(getLayoutPosition()));

               }
           });


        }
    }
    public interface ChatClickListener{
       void onChatClick(UserModel userModel);
    }
}