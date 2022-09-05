package data.entidades;

import java.io.Serializable;

public class OutrosArtigos implements Serializable {

    private static final long serialVersionUID = -502723429558679533L;
    private int id;
    private String nome;
    private Fornecedor fornecedor;
    private int quantidade;

    public OutrosArtigos() {}

    public OutrosArtigos(int id, String nome, Fornecedor fornecedor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "OutrosArtigos{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", fornecedor=" + fornecedor +
                ", quantidade=" + quantidade +
                '}';
    }
}
