package com.example.fragmentsfilms.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentsfilms.R;
import com.example.fragmentsfilms.controller.ControllerAtor;
import com.example.fragmentsfilms.entites.Ator;

public class AdapterAtor extends RecyclerView.Adapter<AdapterAtor.MyViewHolder> {

    private ControllerAtor controllerAtor;
    private Context context;

    public AdapterAtor(Context context){
        controllerAtor = ControllerAtor.getInstance();
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_ator, parent, false);
        return new MyViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Ator ator = controllerAtor.getListAtor().get(position);

        holder.nome.setText(ator.getNome());
        holder.dataNascimento.setText(ator.getDataNascimento());
        holder.imageView.setImageResource(ator.getIdImagem());
    }

    @Override
    public int getItemCount() {
        return controllerAtor.getListAtor().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nome;
        private TextView dataNascimento;
        private ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textViewNomeAtor);
            dataNascimento = itemView.findViewById(R.id.textViewAnoNascimentoAtor);
            imageView = itemView.findViewById(R.id.imageViewAtor);
        }
    }
}
