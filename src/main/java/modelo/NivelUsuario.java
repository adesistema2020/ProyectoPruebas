
package modelo;

/**
 * @author AdeS
 */
public class NivelUsuario {
     private int id_nivel;
    private String caracter;
    
    public NivelUsuario(){
    }

    public NivelUsuario(int id_nivel, String caracter) {
        this.id_nivel = id_nivel;
        this.caracter = caracter;
    }

    public int getId_nivel() {
        return id_nivel;
    }

    public void setId_nivel(int id_nivel) {
        this.id_nivel = id_nivel;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    @Override
    public String toString() {
//        return "NivelUsuario{" + "id_nivel=" + id_nivel + ", caracter=" + caracter + '}';
         return caracter;
    }
    
   
}
