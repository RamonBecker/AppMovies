package com.example.fragmentsfilms.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentsfilms.R;
import com.example.fragmentsfilms.controller.ControllerAtor;
import com.example.fragmentsfilms.controller.ControllerDiretor;
import com.example.fragmentsfilms.entites.Ator;
import com.example.fragmentsfilms.entites.Diretor;

import java.util.ArrayList;
import java.util.List;

public class TesteSpinner extends Fragment {

    private Spinner spinnerAtor;
    private Spinner spinnerDiretor;
    private Activity activity;
    private ControllerAtor controllerAtor;
    private ControllerDiretor controllerDiretor;
    private ArrayAdapter<Ator>  dataAdapterAtor;
    private ArrayAdapter<Diretor>  dataAdapterDiretor;

    public TesteSpinner(Activity activity){
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_spinner, container, false);

        spinnerAtor = view.findViewById(R.id.spinnerAtor);
        spinnerDiretor = view.findViewById(R.id.spinnerDiretor);
        controllerAtor = ControllerAtor.getInstance();
        controllerDiretor = ControllerDiretor.getInstance();

        dataAdapterAtor = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);
        dataAdapterAtor.add(new Ator("Escolhe a sua opção",""));
        dataAdapterAtor.addAll(controllerAtor.getListAtor());
        dataAdapterAtor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dataAdapterDiretor = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item );
        dataAdapterDiretor.add(new Diretor("Escolha a sua opção",""));
        dataAdapterDiretor.addAll(controllerDiretor.getListDiretor());
        spinnerAtor.setAdapter(dataAdapterAtor);
        spinnerDiretor.setAdapter(dataAdapterDiretor);
        actionSpinner(spinnerAtor);
        actionSpinner(spinnerDiretor);

        return view;
    }

    private void actionSpinner(Spinner spinner){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Escolha a sua opção")){
                }
                else{
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected:"+item, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
