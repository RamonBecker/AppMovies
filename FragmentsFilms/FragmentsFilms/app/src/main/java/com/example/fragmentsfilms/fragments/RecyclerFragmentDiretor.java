package com.example.fragmentsfilms.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentsfilms.Adapter.AdapterDiretor;
import com.example.fragmentsfilms.R;
import com.example.fragmentsfilms.controller.ControllerDiretor;

public class RecyclerFragmentDiretor extends Fragment {

    private RecyclerView recyclerView;
    private ControllerDiretor controllerDiretor;
    private AdapterDiretor adapterDiretor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        adapterDiretor = new AdapterDiretor(getContext());
        recyclerView.setAdapter(adapterDiretor);
        return view;
    }
}
