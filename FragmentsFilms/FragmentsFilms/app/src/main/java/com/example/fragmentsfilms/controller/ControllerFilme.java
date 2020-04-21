package com.example.fragmentsfilms.controller;

import com.example.fragmentsfilms.entites.Filme;

import java.util.ArrayList;
import java.util.List;

public class ControllerFilme {
    private static ControllerFilme controllerFilme;
    private List<Filme> listaFilme;

    private ControllerFilme() {
        this.listaFilme = new ArrayList<>();
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
}
