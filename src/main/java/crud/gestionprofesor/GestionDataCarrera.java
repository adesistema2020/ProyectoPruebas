package crud.gestionprofesor;

import dao.ProfesorDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.gestionprofesor.Carrera;

/**
 * @author AdeS
 */
public class GestionDataCarrera {

    private Connection connP;

    public GestionDataCarrera() throws IOException {
        connP = ProfesorDAO.getInstance().getProfesorDAO();
    }

    public boolean ingresar(Carrera carrera) {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO t_carrera (codCarrera, nomCarrera) VALUE (?,?)";
        try {
            pstmt = connP.prepareStatement(sql);
//                                                                              pstmt.setInt(1, carrera.getId_profesor());
            pstmt.setInt(1, carrera.getCodCarrera());
            pstmt.setString(2, carrera.getNomCarrera());
            return true;
        } catch (SQLException e) {
            System.out.println("[GestionDataCarrera]" + e.getMessage());
            e.getMessage();
            return false;
        }
    }

    public int modificar(Carrera carrera) {
        int r = 0;
        PreparedStatement pstmt = null;
        String sql = "UPDATE t_carrera SET  codCarrera=?, nomCarrera=? WHERE id_carrera";
        try {
            pstmt = connP.prepareStatement(sql);
//                                                                               pstmt.setInt(1, carrera.getId_profesor());
            pstmt.setInt(1, carrera.getCodCarrera());
            pstmt.setString(2, carrera.getNomCarrera());
//                                                                               pstmt.setInt(4, carrera.getId_profesor());
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

    public boolean buscarUnaCarrera(Carrera carrera) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM t_carrera WHERE id_carrera=?";
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, carrera.getId_carrera());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                carrera.setId_carrera(rs.getInt("id_carrera"));
//                                                                                carrera.setId_profesor(rs.getInt("id_profesor"));
                carrera.setCodCarrera(rs.getInt("codCarrera"));
                carrera.setNomCarrera(rs.getString("nomCarrera"));
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

    public ArrayList<Carrera> extraerTodas() throws SQLException {
        Statement st;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_carrera";
        ArrayList<Carrera> lista = new ArrayList<>();
        try {
            st = connP.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Carrera(
                        rs.getInt("id_carrera"),
                        rs.getInt("codCarrera"),
                        rs.getString("nomCarrera")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
     public ArrayList<Carrera> buscarNomCarrera(String nomCarrera ) {
        PreparedStatement pstmt;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_carrera WHERE nomCarrera LIKE ?";
        ArrayList<Carrera> listaCarr = new ArrayList<>();
        Carrera carrera;
        try {

            pstmt = connP.prepareStatement(sql);
////            Todos los apellidos que comienzen con 
            pstmt.setString(1, nomCarrera+ '%');
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Leyendo Fila De Tabla" +rs);
                carrera = new Carrera();
                carrera.setId_carrera(rs.getInt(1));
                carrera.setCodCarrera(rs.getInt(2));
                carrera.setNomCarrera(rs.getString(3));
             
                listaCarr.add(carrera);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCarr;
    }
     
      public ArrayList<Carrera> buscarCodigoCarr(Integer codCarrera) {
        PreparedStatement pstmt;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_carrera WHERE codCarrera =?";
        ArrayList<Carrera> listCod_carrera = new ArrayList<>();
        Carrera CodCarr;
        try {

            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, codCarrera);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                CodCarr = new Carrera();                
                CodCarr.setId_carrera(rs.getInt(1));
                CodCarr.setCodCarrera(rs.getInt(2));
                CodCarr.setNomCarrera(rs.getString(3));
                
                listCod_carrera.add(CodCarr);
//                System.out.println("muestra lista cod_carrera" +CodCarr);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("aquiiiii fallo MET buscarCodigoCarr CLAS GestionDataCarrera !!!!"+ex);
        }
        return listCod_carrera;
    }
}
