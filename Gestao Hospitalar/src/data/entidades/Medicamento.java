package data.entidades;

import java.io.Serializable;

public class Medicamento implements Serializable {

    private static final long serialVersionUID = -7514483439180846720L;
    private int id;
    private String dci;
    private String nome;
    private String formafarmaceutica;
    private String dosagem;
    private String estadoautorizacao;
    private Boolean generico;
    private Fornecedor fornecedor; //Titular de AIM
    private int quantidade;

    public Medicamento() {}

    public Medicamento(int id, String dci, String nome, String formafarmaceutica, String dosagem, String estadoautorizacao, Boolean generico, Fornecedor fornecedor, int quantidade) {
        this.id = id;
        this.dci = dci;
        this.nome = nome;
        this.formafarmaceutica = formafarmaceutica;
        this.dosagem = dosagem;
        this.estadoautorizacao = estadoautorizacao;
        this.generico = generico;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDci() {
        return dci;
    }

    public void setDci(String dci) {
        this.dci = dci;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormafarmaceutica() {
        return formafarmaceutica;
    }

    public void setFormafarmaceutica(String formafarmaceutica) {
        this.formafarmaceutica = formafarmaceutica;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getEstadoautorizacao() {
        return estadoautorizacao;
    }

    public void setEstadoautorizacao(String estadoautorizacao) {
        this.estadoautorizacao = estadoautorizacao;
    }

    public Boolean getGenerico() {
        return generico;
    }

    public void setGenerico(Boolean generico) {
        this.generico = generico;
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

    public void addMedicamento(int n){
        this.quantidade += n;
    }

    public void removeMedicamento(int n){
        this.quantidade -= n;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "id=" + id +
                ", dci='" + dci + '\'' +
                ", nome='" + nome + '\'' +
                ", formafarmaceutica='" + formafarmaceutica + '\'' +
                ", dosagem='" + dosagem + '\'' +
                ", estadoautorizacao='" + estadoautorizacao + '\'' +
                ", generico=" + generico +
                ", fornecedor=" + fornecedor +
                ", quantidade=" + quantidade +
                '}';
    }
}