package com.example.fragmentsfilms.controller;

import com.example.fragmentsfilms.R;
import com.example.fragmentsfilms.entites.Filme;

import java.util.ArrayList;
import java.util.List;

public class ControllerFilme {
    private static ControllerFilme controllerFilme;
    private List<Filme> listaFilme;

    private ControllerFilme() {
        this.listaFilme = new ArrayList<>();
        criarFilmes();
    }

    public static ControllerFilme getInstance() {
        if (controllerFilme == null) {
            controllerFilme = new ControllerFilme();
        }
        return controllerFilme;
    }

    public List<Filme> getListaFilme() {
        return listaFilme;
    }

    public void criarFilmes(){
        this.listaFilme.add(new Filme("Coringa", "2019", "Drama", R.drawable.coringa));
        this.listaFilme.add(new Filme("Band of Brothers", "2001", "Minissérie", R.drawable.bandofbrothers));
        this.listaFilme.add(new Filme("Coração Valente", "1995", "Guerra", R.drawable.coracaovalente));
        this.listaFilme.add(new Filme("O resgate do soldado Ryan", "1998", "Guerra", R.drawable.oresgatedosoldadoryan));
    }
}
