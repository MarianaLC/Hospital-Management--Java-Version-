package data.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AtoFarmaceutico implements Serializable {

    private static final long serialVersionUID = -4401030034439285526L;
    private int id;
    private Farmaceutico f;
    private LocalDateTime hora;
    private HashMap<Integer, Integer> artigos;
    private HashMap< Integer, Integer > medicamentos;

    public AtoFarmaceutico(int id, Farmaceutico f, LocalDateTime hora, HashMap<Integer, Integer> artigos, HashMap<Integer, Integer > medicamentos) {
        this.id = id;
        this.f = f;
        this.hora = hora;
        if (artigos == null)
            this.artigos = new HashMap<>();
        if (medicamentos == null)
            this.medicamentos = new HashMap<>();
        if ((artigos == null) && (medicamentos == null)) {
            this.artigos = new HashMap<>();
            this.medicamentos = new HashMap<>();
        }
        else{
            this.artigos = artigos;
            this.medicamentos = medicamentos;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Farmaceutico getF() {
        return f;
    }

    public void setF(Farmaceutico f) {
        this.f = f;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public Map<Integer, Integer> getArtigos() {
        return artigos;
    }

    public void setArtigos(HashMap<Integer, Integer> artigos) {
        this.artigos = artigos;
    }

    public HashMap<Integer, Integer> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(HashMap<Integer, Integer> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void putArtigo(int id, int quant){
        this.artigos.put(id, quant);
    }

    public void putMedicamento(int id, int quant){
        this.medicamentos.put(id, quant);
    }

    public void removeArtigo(int id){
        this.artigos.remove(id);
    }

    public void removeMedicamento(int id){
        this.medicamentos.remove(id);
    }    

    @Override
    public String toString() {
        return "AtoFarmaceutico{" +
                "id=" + id +
                ", f=" + f +
                ", hora=" + hora +
                ", artigos=" + artigos +
                ", medicamentos=" + medicamentos +
                '}';
    }
}

