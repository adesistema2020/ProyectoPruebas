
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class CategoriaExtencionista {
    
    private int id_cat_extencionista;
    private int id_act_extracurricular;
    private String cat_Extencion;
    
 public CategoriaExtencionista(){}

    public CategoriaExtencionista(int id_cat_extencionista, int id_act_extracurricular, String cat_Extencion) {
        this.id_cat_extencionista = id_cat_extencionista;
        this.id_act_extracurricular = id_act_extracurricular;
        this.cat_Extencion = cat_Extencion;
    }

    public int getId_cat_extencionista() {
        return id_cat_extencionista;
    }

    public void setId_cat_extencionista(int id_cat_extencionista) {
        this.id_cat_extencionista = id_cat_extencionista;
    }

    public int getId_act_extracurricular() {
        return id_act_extracurricular;
    }

    public void setId_act_extracurricular(int id_act_extracurricular) {
        this.id_act_extracurricular = id_act_extracurricular;
    }

    public String getCat_Extencion() {
        return cat_Extencion;
    }

    public void setCat_Extencion(String cat_Extencion) {
        this.cat_Extencion = cat_Extencion;
    }

    @Override
    public String toString() {
        return "CategoriaExtencionista{" + "id_cat_extencionista=" + id_cat_extencionista + ", id_act_extracurricular=" + id_act_extracurricular + ", cat_Extencion=" + cat_Extencion + '}';
    }
 
}
