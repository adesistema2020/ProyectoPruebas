
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class Categoria {
    
    private int id_categoria;
    private int id_profesor;
    private String nomCategoria;

public Categoria (){}

    public Categoria(int id_categoria, int id_profesor, String nomCategoria) {
        this.id_categoria = id_categoria;
        this.id_profesor = id_profesor;
        this.nomCategoria = nomCategoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id_categoria=" + id_categoria + ", id_profesor=" + id_profesor + ", nomCategoria=" + nomCategoria + '}';
    }

}
