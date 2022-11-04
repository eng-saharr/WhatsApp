package com.example.mya.ui;

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

import com.example.mya.R;
import com.example.mya.data.model.UserCalls;
import com.example.mya.ui.adapter.CallsAdapter;

import java.util.ArrayList;


public class CallsFragment extends Fragment {

    RecyclerView  callsRecycler;
    ArrayList<UserCalls>calls=new ArrayList<>();
    CallsAdapter callsAdapter;



    public CallsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_call_item,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if (id == R.id.link){
            Toast.makeText(getActivity(), "clear call link", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.settingg){
            Toast.makeText(getActivity(), "Settings", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler(view);
    }

    private void setupRecycler(View view){
        calls.add(new UserCalls(R.drawable.ic_launcher_background,"sahar","now"));
        calls.add(new UserCalls(R.drawable.pp,"sahar","now"));
        calls.add(new UserCalls(R.drawable.nn,"loloo","30 minuts ago"));
        calls.add(new UserCalls(R.drawable.ii,"sosoo","2 days"));
        calls.add(new UserCalls(R.drawable.ee,"maiii","3days"));
        calls.add(new UserCalls(R.drawable.ic_launcher_foreground,"sahar","one daya"));
        calls.add(new UserCalls(R.drawable.tt,"dinaa","11 hrs"));
        calls.add(new UserCalls(R.drawable.rr,"rokaa","now"));
        calls.add(new UserCalls(R.drawable.ic_launcher_background,"ayana","now"));
        calls.add(new UserCalls(R.drawable.ic_launcher_foreground,"dalia","50 minutes ago"));
        calls.add(new UserCalls(R.drawable.pp,"sahar","now"));
        calls.add(new UserCalls(R.drawable.ic_launcher_background,"hanaa","now"));
        calls.add(new UserCalls(R.drawable.tt,"malak","now"));
        calls.add(new UserCalls(R.drawable.ic_launcher_background,"mahaa","now"));
        calls.add(new UserCalls(R.drawable.ee,"dalia","now"));
        calls.add(new UserCalls(R.drawable.ic_launcher_background,"sahar","now"));
        calls.add(new UserCalls(R.drawable.ic_launcher_foreground,"monaa","now"));
        calls.add(new UserCalls(R.drawable.ic_launcher_background,"doaaa","now"));
        calls.add(new UserCalls(R.drawable.ic_launcher_foreground,"hager","now"));
        calls.add(new UserCalls(R.drawable.nn,"sahar","now"));
        calls.add(new UserCalls(R.drawable.ic_launcher_background,"sahar","now"));

        callsRecycler=view.findViewById(R.id.call_recycle);
        callsAdapter=new CallsAdapter(calls);
        callsRecycler.setAdapter(callsAdapter);
        callsRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));


    }
}