
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class NomProyectoInvestigacion {
    private int id_proyectoInvestigacion;
    private String nom_proyectoInves;
    
    public NomProyectoInvestigacion (){}

    public NomProyectoInvestigacion(int id_proyectoInvestigacion, String nom_proyectoInves) {
        this.id_proyectoInvestigacion = id_proyectoInvestigacion;
        this.nom_proyectoInves = nom_proyectoInves;
    }

    public int getId_proyectoInvestigacion() {
        return id_proyectoInvestigacion;
    }

    public void setId_proyectoInvestigacion(int id_proyectoInvestigacion) {
        this.id_proyectoInvestigacion = id_proyectoInvestigacion;
    }

    public String getNom_proyectoInves() {
        return nom_proyectoInves;
    }

    public void setNom_proyectoInves(String nom_proyectoInves) {
        this.nom_proyectoInves = nom_proyectoInves;
    }

    @Override
    public String toString() {
        return "NomProyectoInvestigacion{" + "id_proyectoInvestigacion=" + id_proyectoInvestigacion + ", nom_proyectoInves=" + nom_proyectoInves + '}';
    }
    
}
