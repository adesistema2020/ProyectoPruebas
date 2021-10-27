package crud.gestionprofesor;

import dao.ProfesorDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.gestionprofesor.Materia;

/**
 * @author AdeS
 */
public class GestionDataMateria {

    private Connection connP;

    public GestionDataMateria() throws IOException {
        connP = ProfesorDAO.getInstance().getProfesorDAO();
    }
    
     public boolean ingresar(Materia materia) {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO t_materia (codMateria, nomMateria, id_carrera) VALUE (?,?)";
        try {
            pstmt = connP.prepareStatement(sql);            
            pstmt.setInt(1, materia.getCodMateria());
            pstmt.setString(2, materia.getNomMateria());
            pstmt.setInt(3,materia.getId_Carrera());
            return true;
        } catch (SQLException e) {
            System.out.println("[GestionDataMateria]" + e.getMessage());
            e.getMessage();
            return false;
        }
    }

    public int modificar(Materia materia) {
        int r = 0;
        PreparedStatement pstmt = null;
        String sql = "UPDATE t_materia SET codMateria=?, nomMateria=?, id_carrera=? WHERE id_materia";
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, materia.getCodMateria());
            pstmt.setString(2, materia.getNomMateria());
            pstmt.setInt(3, materia.getId_Carrera());
            pstmt.setInt(4, materia.getId_materia());
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

    public boolean buscarUnaMateria(Materia materia) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM t_materia WHERE id_materia=?";
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, materia.getId_materia());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setCodMateria(rs.getInt("codMateria"));
                materia.setNomMateria(rs.getString("nomMateria"));
                materia.setId_Carrera(rs.getInt("id_carrera"));
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
    
      public ArrayList<Materia> extraerTodas() throws SQLException {
        Statement st;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_materia";
        ArrayList<Materia> lista = new ArrayList<>();
        try {
            st = connP.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Materia(
                        rs.getInt("id_materia"),
                        rs.getInt("codMateria"),
                        rs.getString("nomMateria"),
                        rs.getInt("id_carrera")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
     public ArrayList<Materia> buscarNomMateria(String nomMateria ) {
        PreparedStatement pstmt;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_materia WHERE nomMateria LIKE ?";
        ArrayList<Materia> listaMat = new ArrayList<>();
        Materia materia;
        try {

            pstmt = connP.prepareStatement(sql);
////            Todos los apellidos que comienzen con 
            pstmt.setString(1, nomMateria+ '%');
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Leyendo Fila De Tabla" +rs);
                materia = new Materia();
                materia.setId_materia(rs.getInt(1));
                materia.setCodMateria(rs.getInt(2));
                materia.setNomMateria(rs.getString(3));
                materia.setId_Carrera(rs.getInt(4));
                listaMat.add(materia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaMat;
    }
     
      public ArrayList<Materia> buscarCodigoMat(Integer codMateria) {
        PreparedStatement pstmt;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_materia WHERE codMateria =?";
        ArrayList<Materia> listCod_materia = new ArrayList<>();
        Materia CodMat;
        try {

            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, codMateria);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                CodMat = new Materia();                
                CodMat.setId_materia(rs.getInt(1));
                CodMat.setCodMateria(rs.getInt(2));
                CodMat.setNomMateria(rs.getString(3));
                CodMat.setId_Carrera(rs.getInt(1));
                
                listCod_materia.add(CodMat);
//                System.out.println("muestra lista cod_carrera" +CodCarr);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("aquiiiii fallo MET buscarCodigoCarr CLAS GestionDataCarrera !!!!"+ex);
        }
        return listCod_materia;
    }
}
