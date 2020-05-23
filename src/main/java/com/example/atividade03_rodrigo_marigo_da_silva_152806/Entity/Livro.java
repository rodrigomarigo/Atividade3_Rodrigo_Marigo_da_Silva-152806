package com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

@Entity
public class Livro implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.AUTO) //gera a chave automaticamente
    private int id;

    @NonNull
    private String titulo;

    @NonNull
    // @Min(10)
    private int num_paginas;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;

    @ManyToMany
    @JoinTable(
        name = "LivroAutor",
        uniqueConstraints = @UniqueConstraint (columnNames = { "id_livro", "id_autor" }),
        joinColumns        = @JoinColumn(name = "id_livro"), 
        inverseJoinColumns = @JoinColumn(name = "id_autor")
    )
    private List<Autor> autor;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Editora getEditora() {
        return this.editora;
    }

    public void setEditora(Editora editora) {
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
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", num_paginas='" + getNum_paginas() + "'" +
            ", editora='" + getEditora() + "'" +
            ", autor='" + getAutor() + "'" +
            "}";
    }

}