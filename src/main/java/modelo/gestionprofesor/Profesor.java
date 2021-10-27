
package modelo.gestionprofesor;

import java.sql.Date;

/**
 * @author AdeS
 */

public class Profesor{
private int id_profesor;
private String nombreProf;
private String apellido;
private String direccion;
private int dni;
private int id_actiAcademica;
private int id_carrera;
private int id_materia;
    
public Profesor(){}

    public Profesor(int id_profesor, String nombreProf, String apellido, String direccion, int dni, int id_actiAcademica, int id_carrera, int id_materia) {
        this.id_profesor = id_profesor;
        this.nombreProf = nombreProf;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.id_actiAcademica = id_actiAcademica;
        this.id_carrera = id_carrera;
        this.id_materia = id_materia;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombreProf() {
        return nombreProf;
    }

    public void setNombreProf(String nombreProf) {
        this.nombreProf = nombreProf;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getId_actiAcademica() {
        return id_actiAcademica;
    }

    public void setId_actiAcademica(int id_actiAcademica) {
        this.id_actiAcademica = id_actiAcademica;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    @Override
    public String toString() {
        return "Profesor{" + "id_profesor=" + id_profesor + ", nombreProf=" + nombreProf + ", apellido=" + apellido + ", direccion=" + direccion + ", dni=" + dni + ", id_actiAcademica=" + id_actiAcademica + ", id_carrera=" + id_carrera + ", id_materia=" + id_materia + '}';
    }
}