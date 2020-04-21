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
import com.example.fragmentsfilms.controller.ControllerDiretor;
import com.example.fragmentsfilms.entites.Diretor;

public class AdapterDiretor extends RecyclerView.Adapter<AdapterDiretor.MyViewHolder>{

    private ControllerDiretor controllerDiretor;
    private Context context;

    public AdapterDiretor(Context context){
        this.context = context;
        controllerDiretor = ControllerDiretor.getInstance();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_diretor, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Diretor diretor = controllerDiretor.getListDiretor().get(position);
        holder.nome.setText(diretor.getNome());
        holder.dataNascimento.setText(diretor.getDataNascimento());
        holder.imageView.setImageResource(diretor.getIdImagem());
    }

    @Override
    public int getItemCount() {
        return controllerDiretor.getListDiretor().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nome;
        private TextView dataNascimento;
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textViewNomeDiretor);
            dataNascimento = itemView.findViewById(R.id.textViewAnoNascimentoDiretor);
            imageView = itemView.findViewById(R.id.imageViewDiretor);
        }
    }
}
