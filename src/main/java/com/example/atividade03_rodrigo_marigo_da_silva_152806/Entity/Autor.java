package com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity;

import java.util.List;

public class Autor {
    private String nome;

    private List<Livro> livros;

    private int idade;

    private int num_premios;

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

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getNum_premios() {
        return this.num_premios;
    }

    public void setNum_premios(int num_premios) {
        this.num_premios = num_premios;
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", livros='" + getLivros() + "'" +
            ", idade='" + getIdade() + "'" +
            ", num_premios='" + getNum_premios() + "'" +
            "}";
    }

    
}