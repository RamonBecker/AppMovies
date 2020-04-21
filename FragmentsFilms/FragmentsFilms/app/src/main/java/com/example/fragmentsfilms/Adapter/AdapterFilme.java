package com.example.fragmentsfilms.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fragmentsfilms.R;
import com.example.fragmentsfilms.controller.ControllerFilme;
import com.example.fragmentsfilms.entites.Filme;

public class AdapterFilme extends RecyclerView.Adapter<AdapterFilme.MyViewHolder> {

    private ControllerFilme controllerFilme;
    private Context activity;


    public AdapterFilme(){
    }

    public AdapterFilme(AppCompatActivity activity) {
        this.activity = activity;
        this.controllerFilme = ControllerFilme.getInstance();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_filme, parent, false);
        return new MyViewHolder(itemLista);

    }


   // public void editar(Filme filme, int position){
        /*
        controllerFIlme.getListaFilme().get(position).setNome(filme.getNome());
        controllerFIlme.getListaFilme().get(position).setAno(filme.getAno());
        controllerFIlme.getListaFilme().get(position).setGenero(filme.getGenero());
        controllerFIlme.getListaFilme().get(position).setDescricao(filme.getDescricao());
        notifyItemChanged(position);

         */
 //   }

   // public void adicionarFilme(Filme filme){
   //     controllerFIlme.getListaFilme().add(filme);
    //    notifyItemInserted(getItemCount());
  //  }




    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        Filme filme = controllerFilme.getListaFilme().get(position);
        holder.titulo.setText(filme.getTitulo());
        holder.genero.setText(filme.getGenero());
        holder.anoLancamento.setText(filme.getAnoLançamento());
        holder.imagem.setImageResource(filme.getIdImagem());


/*
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), EditarFilme.class);
                v.getContext().startActivity(i);
                EditarFilme.tela = "Editar";
                EditarFilme.posicao = holder.getAdapterPosition();
            }
        });

        */
    }

    @Override
    public int getItemCount() {
        return controllerFilme.getListaFilme().size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private TextView genero;
        private TextView anoLancamento;
        private ImageView imagem;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            titulo = itemView.findViewById(R.id.textViewTituloFilme);
            genero = itemView.findViewById(R.id.textViewGenero);
            anoLancamento = itemView.findViewById(R.id.textViewAnoLancamento);
            imagem = itemView.findViewById(R.id.imageViewFilm);
        }
    }
}


