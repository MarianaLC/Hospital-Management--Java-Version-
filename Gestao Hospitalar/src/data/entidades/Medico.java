package data.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import java.io.Serializable;

public class Medico extends Funcionario implements Serializable {

    private static final long serialVersionUID = 8741249743686564638L;
    private String especialidade;
    private String cedula;

    public Medico() {
        super();
    }

    public Medico(String nome, String bi, String nif, String morada, String codigo_postal, String especialidade, String cedula) {
        super(nome, bi, nif, morada, codigo_postal);
        this.especialidade = especialidade;
        this.cedula = cedula;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Medico{" +
                super.toString() +
                "especialidade='" + especialidade + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
