package crud.gestionprofesor;

import dao.ProfesorDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.gestionprofesor.Categoria;

/**
 * @author AdeS
 */
public class GestionDataCategoria {

    private Connection connP;

    public GestionDataCategoria() throws IOException {
        connP = ProfesorDAO.getInstance().getProfesorDAO();
    }

    public boolean ingresar(Categoria categoria) {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO t_categoria ( nomCategoria) VALUE (?)";
        try {
            pstmt = connP.prepareStatement(sql);
//            pstmt.setInt(1, categoria.getId_profesor());
            pstmt.setString(1, categoria.getNomCategoria());
            return true;
        } catch (SQLException e) {
            System.out.println("[GestionDataCategoria]" + e.getMessage());
            e.getMessage();
            return false;
        }
    }

    public int modificar(Categoria categoria) {
        int r = 0;
        PreparedStatement pstmt = null;
        String sql = "UPDATE t_categoria SET nomCategoria=? WHERE id_categoria";
        try {
            pstmt = connP.prepareStatement(sql);
//            pstmt.setInt(1, categoria.getId_profesor());
            pstmt.setString(1, categoria.getNomCategoria());
            pstmt.setInt(2, categoria.getId_categoria());
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

    public boolean buscarUnaCategoria(Categoria categoria) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM t_categoria WHERE id_catgoria=?";
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, categoria.getId_categoria());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                categoria.setId_categoria(rs.getInt("id_categoria"));
//                categoria.setId_profesor(rs.getInt("id_profesor"));
                categoria.setNomCategoria(rs.getString("nomCategoria"));
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
////////////////////////////    
    
 public ArrayList<String> ObtenerCategoria() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<String> listaNomCat = new ArrayList<>();
        String sql = " SELECT * FROM t_categoria";
        System.out.println("aqui se ejecuto Metodo ArrayList ObtenerCategoria!!");
        try {
            pstmt = connP.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                listaNomCat.add(rs.getString("nomCategoria"));
            }
        } catch (SQLException e) {
        }
        return listaNomCat;
    }

    public int obtenerIdCategoria(String nomCategoria) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int Id = 0;
        String sql = " SELECT id_catgoria FROM t_categoria WHERE  nomCategoria= ?";
        System.out.println("se mostro aqui Metodo obtenerIdCategoria!!");
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setString(1, nomCategoria);
            rs = pstmt.executeQuery();

            int registro = 0;
            while (rs.next()) {
                Id = rs.getInt("id_categoria");
                registro++;
            }
        } catch (Exception e) {
            System.out.println("No se mostro Metodo obtenerIdCategoria!!");
        }
        return Id;

    }
    
     public int obtenerLisNomCategoria(Integer id_categoria) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int Id = 0;
        String sql = " SELECT nomCategoria FROM t_categoria WHERE id_categoria = ?";
        System.out.println("se mostro aqui Metodo obtenerLisNomCategoria!!");
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, id_categoria);
            rs = pstmt.executeQuery();
            
            int registro = 0;
            while (rs.next()) {
                Id = rs.getInt("nomCategoria");
                registro++;
            }
        } catch (Exception e) {
            System.out.println("No se mostro Metodo obtenerLisNomCategoria!!");
        }
        return Id;

    }
}
