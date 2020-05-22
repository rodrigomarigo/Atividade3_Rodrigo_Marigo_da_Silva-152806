package com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity
public class Editora implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.AUTO) //gera a chave automaticamente
    @Column(name="id_editora")
    private int id;

    @NonNull
    private String nome;

    @OneToMany
    @JoinColumn(name = "id_editora")
    private List<Livro> livros;

    @NonNull
    private String cidade_sede; 

    @NonNull
    private String fundador;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return this.livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getCidade_sede() {
        return this.cidade_sede;
    }

    public void setCidade_sede(String cidade_sede) {
        this.cidade_sede = cidade_sede;
    }

    public String getFundador() {
        return this.fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", livros='" + getLivros() + "'" +
            ", cidade_sede='" + getCidade_sede() + "'" +
            ", fundador='" + getFundador() + "'" +
            "}";
    }
    
    
}