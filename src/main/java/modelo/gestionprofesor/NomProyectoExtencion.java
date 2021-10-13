
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class NomProyectoExtencion {
    private int id_proyecto_extencion;
    private String nom_proyectoExten;
    
 public NomProyectoExtencion (){}

    public NomProyectoExtencion(int id_proyecto_extencion, String nom_proyectoExten) {
        this.id_proyecto_extencion = id_proyecto_extencion;
        this.nom_proyectoExten = nom_proyectoExten;
    }

    public int getId_proyecto_extencion() {
        return id_proyecto_extencion;
    }

    public void setId_proyecto_extencion(int id_proyecto_extencion) {
        this.id_proyecto_extencion = id_proyecto_extencion;
    }

    public String getNom_proyectoExten() {
        return nom_proyectoExten;
    }

    public void setNom_proyectoExten(String nom_proyectoExten) {
        this.nom_proyectoExten = nom_proyectoExten;
    }

    @Override
    public String toString() {
        return "NomProyectoExtencion{" + "id_proyecto_extencion=" + id_proyecto_extencion + ", nom_proyectoExten=" + nom_proyectoExten + '}';
    }
 
 
}
