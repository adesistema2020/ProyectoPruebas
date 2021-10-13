
package modelo.gestionprofesor;

/**
 * @author AdeS
 */
public class CategoriaInvestigacion {
    private int id_cat_Investigacion;
    private int id_act_extracurricular;
    private String cat_Investigacion;
    
public CategoriaInvestigacion (){}

    public CategoriaInvestigacion(int id_cat_Investigacion, int id_act_extracurricular, String cat_Investigacion) {
        this.id_cat_Investigacion = id_cat_Investigacion;
        this.id_act_extracurricular = id_act_extracurricular;
        this.cat_Investigacion = cat_Investigacion;
    }

    public int getId_cat_Investigacion() {
        return id_cat_Investigacion;
    }

    public void setId_cat_Investigacion(int id_cat_Investigacion) {
        this.id_cat_Investigacion = id_cat_Investigacion;
    }

    public int getId_act_extracurricular() {
        return id_act_extracurricular;
    }

    public void setId_act_extracurricular(int id_act_extracurricular) {
        this.id_act_extracurricular = id_act_extracurricular;
    }

    public String getCat_Investigacion() {
        return cat_Investigacion;
    }

    public void setCat_Investigacion(String cat_Investigacion) {
        this.cat_Investigacion = cat_Investigacion;
    }

    @Override
    public String toString() {
        return "CategoriaInvestigacion{" + "id_cat_Investigacion=" + id_cat_Investigacion + ", id_act_extracurricular=" + id_act_extracurricular + ", cat_Investigacion=" + cat_Investigacion + '}';
    }


}
