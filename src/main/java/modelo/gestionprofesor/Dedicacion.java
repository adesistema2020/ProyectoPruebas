
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class Dedicacion {
    private int id_dedicacion;
    private String dedicacion;
    private int cargaHoraria;

public Dedicacion(){}

    public Dedicacion(int id_dedicacion, String dedicacion, int cargaHoraria) {
        this.id_dedicacion = id_dedicacion;
        this.dedicacion = dedicacion;
        this.cargaHoraria = cargaHoraria;
    }

    public int getId_dedicacion() {
        return id_dedicacion;
    }

    public void setId_dedicacion(int id_dedicacion) {
        this.id_dedicacion = id_dedicacion;
    }

    public String getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Dedicacion{" + "id_dedicacion=" + id_dedicacion + ", dedicacion=" + dedicacion + ", cargaHoraria=" + cargaHoraria + '}';
    }


}
