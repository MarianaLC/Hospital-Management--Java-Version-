package data.entidades;

import java.io.Serializable;

public class Enfermeiro extends Funcionario implements Serializable {

    private static final long serialVersionUID = 6433160964837287072L;
    private String especialidade;

    public Enfermeiro() {
        super();
    }

    public Enfermeiro(String nome, String bi, String nif, String morada, String codigo_postal, String especialidade) {
        super(nome, bi, nif, morada, codigo_postal);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Enfermeiro{" +
                super.toString() +
                "especialidade='" + especialidade + '\'' +
                '}';
    }
}

