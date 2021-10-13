
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class Carrera {
    private int id_carrera;
    private int id_profesor;
    private int cod_carrera;
    private String nom_carrera;
    
public Carrera(){}

    public Carrera(int id_carrera, int id_profesor, int cod_carrera, String nom_carrera) {
        this.id_carrera = id_carrera;
        this.id_profesor = id_profesor;
        this.cod_carrera = cod_carrera;
        this.nom_carrera = nom_carrera;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public int getCod_carrera() {
        return cod_carrera;
    }

    public void setCod_carrera(int cod_carrera) {
        this.cod_carrera = cod_carrera;
    }

    public String getNom_carrera() {
        return nom_carrera;
    }

    public void setNom_carrera(String nom_carrera) {
        this.nom_carrera = nom_carrera;
    }

    @Override
    public String toString() {
        return "Carrera{" + "id_carrera=" + id_carrera + ", id_profesor=" + id_profesor + ", cod_carrera=" + cod_carrera + ", nom_carrera=" + nom_carrera + '}';
    }
    

}
