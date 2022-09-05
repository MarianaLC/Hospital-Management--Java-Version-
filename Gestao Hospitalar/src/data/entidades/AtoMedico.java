package data.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class AtoMedico  implements Serializable {

    private static final long serialVersionUID = -6924708098543487364L;
    private int id;
    private Medico m;
    private Utente u;
    private LocalDateTime hora;
    private HashMap<Integer, Integer> artigos;
    private HashMap<Integer, Integer > medicamentos;

    public AtoMedico(){
        this.id = 0;
        this.m = new Medico();
        this.u = new Utente();
        this.hora = null;
        this.artigos = new HashMap<>();
        this.medicamentos = new HashMap<>();
    }

    public AtoMedico(int id, Medico m, Utente u, LocalDateTime hora, HashMap< Integer, Integer> artigos, HashMap< Integer, Integer> medicamentos) {
        this.id = id;
        this.m = m;
        this.u = u;
        this.hora = hora;
        if (artigos == null)
            this.artigos = new HashMap<>();
        else if (medicamentos == null)
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

    public Medico getM() {
        return m;
    }

    public void setM(Medico m) {
        this.m = m;
    }

    public Utente getU() {
        return u;
    }

    public void setU(Utente u) {
        this.u = u;
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
        return "AtoMedico{" +
                "id=" + id +
                ", m=" + m +
                ", u=" + u +
                ", hora=" + hora +
                ", artigos=" + artigos +
                ", medicamentos=" + medicamentos +
                '}';
    }
}
