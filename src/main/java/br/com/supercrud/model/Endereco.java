package br.com.supercrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private int numero;
    private String estado;
    private String bairro;

    public Endereco(){
    }

    public Endereco(String logradouro, int numero, String estado, String bairro) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.estado = estado;
        this.bairro = bairro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }

    public String getBairro() {
        return bairro;
    }
}
