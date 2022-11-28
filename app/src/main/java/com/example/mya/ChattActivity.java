package com.example.mya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.mya.data.model.ChatModel;
import com.example.mya.ui.adapter.UserChatAdapter;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChattActivity extends AppCompatActivity {

   public  final String USER_ID="dddfjg";
     EditText editChat;
     ImageButton button;
    RecyclerView recyclerView;
    ArrayList<ChatModel>list = new ArrayList<>();
    UserChatAdapter userChatAdapter=new UserChatAdapter();
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatt);
        editChat=findViewById(R.id.messaget);
        button=findViewById(R.id.sendmsg);
        recyclerView=findViewById(R.id.user_chatrecycle);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message= editChat.getText().toString().trim();
                   if (!message.isEmpty())
                    sendMessage(message);
            }
        });


    }

    private void sendMessage(String message) {
        ref.child("message").push().setValue(new ChatModel(message,USER_ID));
        editChat.setText("  ");

    }
    private void getData(){
        ref.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    list.add(snapshot1.getValue(ChatModel.class));
                }
                userChatAdapter.setList(list);
                recyclerView.setAdapter(userChatAdapter);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}