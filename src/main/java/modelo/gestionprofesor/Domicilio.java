
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class Domicilio {
    private int id_domicilio;
    private String localidad;
    private String barrio;
    private String calle;
    private String num_casa;
    private String num_depto;
    
public Domicilio(){}

    public Domicilio(int id_domicilio, String localidad, String barrio, String calle, String num_casa, String num_depto) {
        this.id_domicilio = id_domicilio;
        this.localidad = localidad;
        this.barrio = barrio;
        this.calle = calle;
        this.num_casa = num_casa;
        this.num_depto = num_depto;
    }

    public int getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNum_casa() {
        return num_casa;
    }

    public void setNum_casa(String num_casa) {
        this.num_casa = num_casa;
    }

    public String getNum_depto() {
        return num_depto;
    }

    public void setNum_depto(String num_depto) {
        this.num_depto = num_depto;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "id_domicilio=" + id_domicilio + ", localidad=" + localidad + ", barrio=" + barrio + ", calle=" + calle + ", num_casa=" + num_casa + ", num_depto=" + num_depto + '}';
    }


}
