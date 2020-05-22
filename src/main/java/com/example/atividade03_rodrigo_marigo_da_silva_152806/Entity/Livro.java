package com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Livro {
    private String titulo;

    private int num_paginas;

    private String editora;

    private List<Autor> autor;

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNum_paginas() {
        return this.num_paginas;
    }

    public void setNum_paginas(int num_paginas) {
        this.num_paginas = num_paginas;
    }

    public String getEditora() {
        return this.editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public List<Autor> getAutor() {
        return this.autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "{" +
            " titulo='" + getTitulo() + "'" +
            ", num_paginas='" + getNum_paginas() + "'" +
            ", editora='" + getEditora() + "'" +
            ", autor='" + getAutor() + "'" +
            "}";
    }
}