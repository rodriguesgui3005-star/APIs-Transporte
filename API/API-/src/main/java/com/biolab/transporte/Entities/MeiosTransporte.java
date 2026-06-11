package com.biolab.transporte.Entities;


import jakarta.persistence.*;

@Entity
public class MeiosTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private String capacidade;
    private double valor;

    public MeiosTransporte() {}

    public MeiosTransporte(String nome, Tipo tipo, String capacidade, double valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.valor = valor;
    }

    public MeiosTransporte(long id, String nome, Tipo tipo, String capacidade, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getCapacidade() {
        return capacidade;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }
}
