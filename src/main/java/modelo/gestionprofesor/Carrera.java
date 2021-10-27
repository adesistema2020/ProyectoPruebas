
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class Carrera {
    private int id_carrera;
    private int codCarrera;
    private String nomCarrera;
    
public Carrera(){}

    public Carrera(int id_carrera, int codCarrera, String nomCarrera) {
        this.id_carrera = id_carrera;
        this.codCarrera = codCarrera;
        this.nomCarrera = nomCarrera;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(int codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getNomCarrera() {
        return nomCarrera;
    }

    public void setNomCarrera(String nomCarrera) {
        this.nomCarrera = nomCarrera;
    }

    @Override
    public String toString() {
        return "Carrera{" + "id_carrera=" + id_carrera + ", codCarrera=" + codCarrera + ", nomCarrera=" + nomCarrera + '}';
    }



}