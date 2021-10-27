
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class Materia {
    private int id_materia;
    private int codMateria;
    private String nomMateria;
    private int id_Carrera;
    
public Materia(){}

    public Materia(int id_materia, int codMateria, String nomMateria, int id_Carrera) {
        this.id_materia = id_materia;
        this.codMateria = codMateria;
        this.nomMateria = nomMateria;
        this.id_Carrera = id_Carrera;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public int getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }

    public String getNomMateria() {
        return nomMateria;
    }

    public void setNomMateria(String nomMateria) {
        this.nomMateria = nomMateria;
    }

    public int getId_Carrera() {
        return id_Carrera;
    }

    public void setId_Carrera(int id_Carrera) {
        this.id_Carrera = id_Carrera;
    }

    @Override
    public String toString() {
        return "Materia{" + "id_materia=" + id_materia + ", codMateria=" + codMateria + ", nomMateria=" + nomMateria + ", id_Carrera=" + id_Carrera + '}';
    }

}
