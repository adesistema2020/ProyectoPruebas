
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class ActividadExtracurricular {
    private int id_actExtracurricular;
    private int id_profesor;
    private String actividad;

public ActividadExtracurricular(){}

    public ActividadExtracurricular(int id_actExtracurricular, int id_profesor) {
        this.id_actExtracurricular = id_actExtracurricular;
        this.id_profesor = id_profesor;
    }

    public int getId_actExtracurricular() {
        return id_actExtracurricular;
    }

    public void setId_actExtracurricular(int id_actExtracurricular) {
        this.id_actExtracurricular = id_actExtracurricular;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    @Override
    public String toString() {
        return "ActividadExtracurricular{" + "id_actExtracurricular=" + id_actExtracurricular + ", id_profesor=" + id_profesor + ", actividad=" + actividad + '}';
    }


}
