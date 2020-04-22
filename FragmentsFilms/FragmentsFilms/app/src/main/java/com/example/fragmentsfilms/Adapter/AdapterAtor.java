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
import com.example.fragmentsfilms.activity.MainActivity;
import com.example.fragmentsfilms.controller.ControllerAtor;
import com.example.fragmentsfilms.entites.Ator;
import com.example.fragmentsfilms.entites.Diretor;
import com.google.android.material.snackbar.Snackbar;

import java.util.Collections;

public class AdapterAtor extends RecyclerView.Adapter<AdapterAtor.MyViewHolder> {

    private ControllerAtor controllerAtor;
    private MainActivity activity;

    public AdapterAtor(MainActivity activity){
        controllerAtor = ControllerAtor.getInstance();
        this.activity = activity;
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



    public void mover(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(controllerAtor.getListAtor(), i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(controllerAtor.getListAtor(), i, i - 1);
            }

            notifyItemMoved(fromPosition, toPosition);
        }

    }
    public void remover(int position) {
        final int posicaoRemovida = position;
        final Ator atorRemovido = controllerAtor.getListAtor().get(position);
        controllerAtor.getListAtor().remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, this.getItemCount());

        Snackbar snackbar = Snackbar.make(activity.findViewById(R.id.RelativeLayout), "Item deletado", Snackbar.LENGTH_LONG);
        snackbar.setAction("Desfazer ?", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                controllerAtor.getListAtor().add(posicaoRemovida, atorRemovido);
                notifyItemInserted(posicaoRemovida);
            }
        });
        snackbar.show();
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
