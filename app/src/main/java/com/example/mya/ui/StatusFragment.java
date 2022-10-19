package com.example.mya.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mya.R;
import com.example.mya.data.model.UserStatusModel;
import com.example.mya.ui.adapter.StatusAdapter;

import java.util.ArrayList;


public class StatusFragment extends Fragment {
           RecyclerView statusRecycle;
           ArrayList<UserStatusModel>status =new ArrayList<>();
           StatusAdapter statusAdapter;



    public StatusFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupRecycler(view);
    }

    private  void setupRecycler(View view){
        status.add(new UserStatusModel(R.drawable.ic_launcher_background,"sahar","3 minutes ago"));
        status.add(new UserStatusModel(R.drawable.rr,"lolo","now"));

        status.add(new UserStatusModel(R.drawable.pp,"maha","20 minutes ago"));

        status.add(new UserStatusModel(R.drawable.ic_launcher_foreground,"dalia","now"));

        status.add(new UserStatusModel(R.drawable.ee,"sherien","now"));

        status.add(new UserStatusModel(R.drawable.ic_launcher_background,"sos","35minutes ago"));

        status.add(new UserStatusModel(R.drawable.nn,"noga","30 minutes ago"));

        status.add(new UserStatusModel(R.drawable.ii,"sahar","11 minutes ago"));

        status.add(new UserStatusModel(R.drawable.ic_launcher_background,"sahar","5 minutes ago"));

        status.add(new UserStatusModel(R.drawable.nn,"sahar","45 minutes ago"));
        status.add(new UserStatusModel(R.drawable.ii,"sahar","55 minutes ago"));
        status.add(new UserStatusModel(R.drawable.ic_launcher_background,"sahar","56 minutes ago"));
        status.add(new UserStatusModel(R.drawable.pp,"sahar","one hours"));



        statusRecycle=view.findViewById(R.id.status_recycle);
        statusAdapter=new StatusAdapter(status);
        statusRecycle.setAdapter(statusAdapter);
        statusRecycle.setLayoutManager(new LinearLayoutManager(requireContext()));





    }
}