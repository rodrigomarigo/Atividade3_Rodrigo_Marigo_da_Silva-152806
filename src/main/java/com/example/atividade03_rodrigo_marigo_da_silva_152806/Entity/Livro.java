package com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Livro {
    private String titulo;

    private int num_paginas;

    private String editora;

    private List<Autor> autor;
}