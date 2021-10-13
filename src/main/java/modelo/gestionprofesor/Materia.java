
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class Materia {
    private int id_materia;
    private int cod_materia;
    private String nom_materia;
    
public Materia(){}

    public Materia(int id_materia, int cod_materia, String nom_materia) {
        this.id_materia = id_materia;
        this.cod_materia = cod_materia;
        this.nom_materia = nom_materia;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public int getCod_materia() {
        return cod_materia;
    }

    public void setCod_materia(int cod_materia) {
        this.cod_materia = cod_materia;
    }

    public String getNom_materia() {
        return nom_materia;
    }

    public void setNom_materia(String nom_materia) {
        this.nom_materia = nom_materia;
    }

    @Override
    public String toString() {
        return "Materia{" + "id_materia=" + id_materia + ", cod_materia=" + cod_materia + ", nom_materia=" + nom_materia + '}';
    }


}
