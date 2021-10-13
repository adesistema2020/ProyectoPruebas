
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class CargoGestion {
    private int id_cargoGestion;
    private String cargo;
    
 public CargoGestion(){}

    public CargoGestion(int id_cargoGestion, String cargo) {
        this.id_cargoGestion = id_cargoGestion;
        this.cargo = cargo;
    }

    public int getId_cargoGestion() {
        return id_cargoGestion;
    }

    public void setId_cargoGestion(int id_cargoGestion) {
        this.id_cargoGestion = id_cargoGestion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "CargoGestion{" + "id_cargoGestion=" + id_cargoGestion + ", cargo=" + cargo + '}';
    }
 
 
}
