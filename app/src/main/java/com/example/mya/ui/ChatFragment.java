package com.example.mya.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mya.ChattActivity;
import com.example.mya.R;
import com.example.mya.data.model.UserModel;
import com.example.mya.ui.adapter.ChatAdapter;

import java.util.ArrayList;


public class ChatFragment extends Fragment {
    RecyclerView chatRecycler;
    ArrayList<UserModel> users = new ArrayList<>();
    ChatAdapter chatAdapter;


    public ChatFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler(view);

    }

    private void setupRecycler(View view) {
        users.add(new UserModel(R.drawable.ee, "sahar", "hi"));
        users.add(new UserModel(R.drawable.nn, "lolo", "ok"));
        users.add(new UserModel(R.drawable.pp, "maha", "hallo"));
        users.add(new UserModel(R.drawable.tt, "dalia", "merci"));
        users.add(new UserModel(R.drawable.ic_launcher_background, "sherien", "hi"));
        users.add(new UserModel(R.drawable.ee, "soso", "thank"));
        users.add(new UserModel(R.drawable.ii, "sara", "ooooooo"));
        users.add(new UserModel(R.drawable.rr, "noga", "hi"));
        users.add(new UserModel(R.drawable.ic_launcher_background, "sahar", "hi"));
        users.add(new UserModel(R.drawable.nn, "sahar", "by"));
        users.add(new UserModel(R.drawable.ic_launcher_background, "sahar", "oky"));


        chatRecycler = view.findViewById(R.id.chat_recycle);
        chatAdapter = new ChatAdapter(users,this::onChatClick);
        chatRecycler.setAdapter(chatAdapter);
        chatRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    private  void onChatClick(UserModel userModel) {
        startActivity(new Intent(requireActivity(),ChattActivity.class));
    }









    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.option_menu_items, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.group_btn) {
            Toast.makeText(getActivity(), "new group", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.new_btn) {
            Toast.makeText(getActivity(), "new broadcast", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.linked_btn) {
            Toast.makeText(getActivity(), "linked device", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.message) {
            Toast.makeText(getActivity(), "start message", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.setting_btn) {
            Toast.makeText(getActivity(), "settings", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}