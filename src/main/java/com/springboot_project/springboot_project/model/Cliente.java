package com.springboot_project.springboot_project.model;

//POJO - Plain Old
public class Cliente {
    
    private int id;
    private String nome;
    private String preco;

    public Cliente() {

    }

    public Cliente(int id, String nome, String preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Cliente(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

}
