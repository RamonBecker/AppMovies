package com.example.fragmentsfilms.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentsfilms.Adapter.AdapterAtor;
import com.example.fragmentsfilms.Adapter.AdapterFilme;
import com.example.fragmentsfilms.R;
import com.example.fragmentsfilms.controller.ControllerAtor;

public class RecyclerFragmentAtor extends Fragment {

    private RecyclerView recyclerView;
    private ControllerAtor controllerAtor;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controllerAtor = ControllerAtor.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        AdapterAtor adapterAtor = new AdapterAtor(getContext());
        recyclerView.setAdapter(adapterAtor);

        return view;
    }
}
