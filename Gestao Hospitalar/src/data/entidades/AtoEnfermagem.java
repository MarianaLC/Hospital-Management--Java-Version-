package data.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AtoEnfermagem implements Serializable {

    private static final long serialVersionUID = 104434574700556481L;
    private int id;
    private Enfermeiro e;
    private Utente u;
    private LocalDateTime hora;
    private HashMap<Integer, Integer> artigos;

    public AtoEnfermagem(int id, Enfermeiro e, Utente u, LocalDateTime hora, HashMap<Integer, Integer> artigos) {
        this.id = id;
        this.e = e;
        this.u = u;
        this.hora = hora;

        if (artigos == null)
            this.artigos = new HashMap<>();
        else
            this.artigos = artigos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enfermeiro getE() {
        return e;
    }

    public void setE(Enfermeiro e) {
        this.e = e;
    }

    public Utente getU() {
        return u;
    }

    public void setU(Utente u) {
        this.u = u;
    }

    public Map<Integer, Integer> getArtigos() {
        return artigos;
    }

    public void setArtigos(HashMap<Integer, Integer> artigos) {
        this.artigos = artigos;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public void putArtigo(int id, int quant){
        this.artigos.put(id, quant);
    }

    public void removeArtigo(int id){
        this.artigos.remove(id);
    }

    @Override
    public String toString() {
        return "AtoEnfermagem{" +
                "id=" + id +
                ", e=" + e +
                ", u=" + u +
                ", hora=" + hora +
                ", artigos=" + artigos +
                '}';
    }
}

