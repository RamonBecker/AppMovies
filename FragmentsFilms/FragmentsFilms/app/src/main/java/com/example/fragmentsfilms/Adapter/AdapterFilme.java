package com.example.fragmentsfilms.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fragmentsfilms.R;
import com.example.fragmentsfilms.controller.ControllerFilme;

public class AdapterFilme extends RecyclerView.Adapter<AdapterFilme.MyViewHolder> {
    //  private List<Filme> listaFilme;
    private ControllerFilme controllerFilme;
    AppCompatActivity activity;
    private LayoutInflater layoutInflater;

    public AdapterFilme(Context context, AppCompatActivity activity) {
        this.layoutInflater = LayoutInflater.from(context);
        this.activity = activity;
    //    this.controllerFIlme = ControllerFIlme.getInstance();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = layoutInflater.from(parent.getContext()).inflate(R.layout.card_view_filme, parent, false);
        return new MyViewHolder(itemLista);

    }

    public void mover(int fromPosition, int toPosition) {
        /*
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(controllerFIlme.getListaFilme(), i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(controllerFIlme.getListaFilme(), i, i - 1);
            }

            notifyItemMoved(fromPosition, toPosition);
        }


         */
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
       /*

        Filme filme = controllerFIlme.getListaFilme().get(position);

        holder.tituloFilme.setText(filme.getNome());
        holder.generoFilme.setText(filme.getGenero());
        holder.anoFilme.setText(String.valueOf(filme.getAno()));
        holder.descricaoFilme.setText(filme.getDescricao());
        holder.imgFilme.setImageResource(filme.getIdImagem());

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
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        /*
        private TextView tituloFilme;
        private TextView generoFilme;
        private TextView anoFilme;
        private TextView descricaoFilme;
        private ImageView imgFilme;
        private TextView posicaoFilme;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloFilme = (TextView) itemView.findViewById(R.id.textViewtitulo);
            generoFilme = (TextView) itemView.findViewById(R.id.textViewGenero);
            descricaoFilme = (TextView) itemView.findViewById(R.id.textViewDescricao);
            anoFilme = (TextView) itemView.findViewById(R.id.textViewAno);
            imgFilme = (ImageView) itemView.findViewById(R.id.imageViewFilme);
        }

         */
    }
}


