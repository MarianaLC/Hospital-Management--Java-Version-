package data.entidades;

import java.io.Serializable;

public abstract class Funcionario implements Serializable {

    private static final long serialVersionUID = 8139011490131754965L;
    private String nome;
    private String bi;
    private String nif;
    private String morada;
    private String codigo_postal;

    public Funcionario(){}

    public Funcionario(String nome, String bi, String nif, String morada, String codigo_postal) {
        this.nome = nome;
        this.bi = bi;
        this.nif = nif;
        this.morada = morada;
        this.codigo_postal = codigo_postal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                ", nome='" + nome + '\'' +
                ", bi='" + bi + '\'' +
                ", nif='" + nif + '\'' +
                ", morada='" + morada + '\'' +
                ", codigo_postal='" + codigo_postal + '\'' +
                '}';
    }
}
