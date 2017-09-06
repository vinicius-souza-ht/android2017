package br.com.fabricadeprogramador.fdpapp;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by viniciuspodi on 30/08/17.
 */

public class Pessoa implements Serializable{

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private Integer imagem;

    public Pessoa(){}

    public Pessoa(Long id, String nome, String telefone, String email, Integer imagem) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.imagem = imagem;
    }

    public Pessoa(String nome, String telefone, String email, Integer imagem) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.imagem = imagem;
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        return id.equals(pessoa.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
