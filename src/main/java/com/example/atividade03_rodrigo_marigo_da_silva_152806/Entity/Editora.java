package com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity;

import java.util.List;

public class Editora {
    private String nome;

    private List<Livro> livros;

    private String cidade_sede;

    private String fundador;

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
            " nome='" + getNome() + "'" +
            ", livros='" + getLivros() + "'" +
            ", cidade_sede='" + getCidade_sede() + "'" +
            ", fundador='" + getFundador() + "'" +
            "}";
    }
    
}