package data.entidades;

import java.io.Serializable;

public class Fornecedor implements Serializable {

    private static final long serialVersionUID = -3329030841103669695L;
    private int id;
    private String nome;

    public Fornecedor() {
    }

    public Fornecedor(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
