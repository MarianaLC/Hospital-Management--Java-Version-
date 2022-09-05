package data.entidades;

import java.io.Serializable;

public class Farmaceutico extends Funcionario implements Serializable {

    private static final long serialVersionUID = -8190567841382645994L;

    public Farmaceutico() {
        super();
    }

    public Farmaceutico(String nome, String bi, String nif, String morada, String codigo_postal) {
        super(nome, bi, nif, morada, codigo_postal);
    }

    @Override
    public String toString() {
        return "Farmaceutico{}" + super.toString() ;
    }
}