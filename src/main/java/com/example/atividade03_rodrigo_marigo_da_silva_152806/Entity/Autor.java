package com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

// bibliotecas de validaçao de dados não funcionando
// import javax.validation.constraints.Max;
// import javax.validation.constraints.Min;
// import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
public class Autor implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.AUTO) //gera a chave automaticamente
    private int id;

    @NonNull
    private String nome;

    @ManyToMany
    @JoinTable(
        name="LivroAutor", 
        uniqueConstraints = @UniqueConstraint (columnNames = { "id_livro", "id_autor" }),
        joinColumns        = @JoinColumn(name = "id_autor" ),
        inverseJoinColumns = @JoinColumn(name = "id_livro")
    )
    private List<Livro> livros;

    @NonNull
    // @Min(10)
    // @Max(150)
    private int idade;

    @NonNull
    // @Min(0)
    private int num_premios;

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
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", livros='" + getLivros() + "'" +
            ", idade='" + getIdade() + "'" +
            ", num_premios='" + getNum_premios() + "'" +
            "}";
    }
    

    
}