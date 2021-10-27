
package crud.gestionprofesor;

import dao.ProfesorDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.gestionprofesor.Dedicacion;

/**
 * @author AdeS
 */
public class GestionDataDedicacion {
     private Connection connP;
     
     public GestionDataDedicacion() throws IOException{
     connP = ProfesorDAO.getInstance().getProfesorDAO();
     }
      public boolean ingresar(Dedicacion dedicacion) {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO t_dedicacion (dedicacion, cargaHoraria) VALUE (?,?)";
        try {
            pstmt = connP.prepareStatement(sql);            
            pstmt.setString(1, dedicacion.getDedicacion());
            pstmt.setInt(2, dedicacion.getCargaHoraria());
            return true;
        } catch (SQLException e) {
            System.out.println("[GestionDataDedicacion]" + e.getMessage());
            e.getMessage();
            return false;
        }
    }
      
       public int modificar(Dedicacion dedicacion) {
        int r = 0;
        PreparedStatement pstmt = null;
        String sql = "UPDATE t_dedicacion SET dedicacion=?, cargaHoraria=? WHERE id_dedicacion";
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setString(1, dedicacion.getDedicacion());
            pstmt.setInt(2, dedicacion.getCargaHoraria());
            pstmt.setInt(3, dedicacion.getId_dedicacion());
            r = pstmt.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("El cambio fallo AQUI!!!:");
            e.getMessage();
        } finally {
        }
        return r;
    }

    public boolean buscarDedicacion(Dedicacion dedicacion) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM t_dedicacion WHERE id_dedicacion=?";
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, dedicacion.getId_dedicacion());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dedicacion.setId_dedicacion(rs.getInt("id_dedicacion"));
                dedicacion.setDedicacion(rs.getString("dedicacion"));
                dedicacion.setCargaHoraria(rs.getInt("cargaHoraria"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(sql);
            e.getMessage();
            return false;
        } finally {
        }
    }
//////////////////////////////////////////////    
    
    public ArrayList<String> ObtenerDedicacion() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<String> listaDedicacion = new ArrayList<>();
        String sql = " SELECT * FROM t_dedicacion";
        System.out.println("aqui se ejecuto Metodo ArrayList ObtenerDedicacion!!");
        try {
            pstmt = connP.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                listaDedicacion.add(rs.getString("dedicacion"));
            }
        } catch (SQLException e) {
        }
        return listaDedicacion;
    }

    public int obtenerIdDedicacion(String nomDedicacion) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int Id = 0;
        String sql = " SELECT id_dedicacion FROM t_dedicacion WHERE  dedicacion= ?";
        System.out.println("se mostro aqui Metodo obtenerIdDedicacion!!");
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setString(1, nomDedicacion);
            rs = pstmt.executeQuery();

            int registro = 0;
            while (rs.next()) {
                Id = rs.getInt("id_dedicacion");
                registro++;
            }
        } catch (Exception e) {
            System.out.println("No se mostro Metodo obtenerIdDedicacion!!");
        }
        return Id;

    }
    
     public int obtenerLisDedicacion(Integer id_dedicacion) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int Id = 0;
        String sql = " SELECT dedicacion FROM t_categoria WHERE id_dedicacion = ?";
        System.out.println("se mostro aqui Metodo obtenerLisDedicacion!!");
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, id_dedicacion);
            rs = pstmt.executeQuery();
            
            int registro = 0;
            while (rs.next()) {
                Id = rs.getInt("dedicacion");
                registro++;
            }
        } catch (Exception e) {
            System.out.println("No se mostro Metodo obtenerLisDedicacion!!");
        }
        return Id;

    }
}
