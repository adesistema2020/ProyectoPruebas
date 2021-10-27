package crud.gestionprofesor;

import dao.ProfesorDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.gestionprofesor.Profesor;

/**
 * @author AdeS
 */
public class GestionDataProfesor {

    private Connection connP;

    public GestionDataProfesor() throws IOException {
        connP = ProfesorDAO.getInstance().getProfesorDAO();
    }

    public boolean ingresar(Profesor profesor) {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO t_profesor ( nombreProf, apellido, direccion,dni, id_actiAcademica, id_carrera, id_materia)VALUE (?,?,?,?,?,?,?)";
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setString(1, profesor.getNombreProf());
            pstmt.setString(2, profesor.getApellido());
            pstmt.setString(3, profesor.getDireccion());
            pstmt.setInt(4, profesor.getDni());
            pstmt.setInt(5, profesor.getId_actiAcademica());
            pstmt.setInt(6, profesor.getId_carrera());
            pstmt.setInt(7, profesor.getId_materia());

            return true;
        } catch (SQLException e) {
            System.out.println("[GestionDataProfesor]" + e.getMessage());
            e.getMessage();
            return false;
        }
    }

    public int modificar(Profesor profesor) {
        int r = 0;
        PreparedStatement pstmt = null;
        String sql = "UPDATE t_profesor SET nombreProf=?, apellido=?, direccion=?, dni=?,id_actiAcademica=?, id_carrera=?, id_materia=? WHERE id_profesor";
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setString(1, profesor.getNombreProf());
            pstmt.setString(2, profesor.getApellido());
            pstmt.setString(3, profesor.getDireccion());
            pstmt.setInt(4, profesor.getDni());
            pstmt.setInt(5, profesor.getId_actiAcademica());
            pstmt.setInt(6, profesor.getId_carrera());
            pstmt.setInt(7, profesor.getId_materia());

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

    public boolean buscarNumDoc(Profesor profesor) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT *FROM t_profesor WHERE dni=?";
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, profesor.getDni());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                profesor.setId_profesor(rs.getInt("id_profesor"));
                profesor.setNombreProf(rs.getString("nombreProf"));
                profesor.setApellido(rs.getString("apellido"));
                profesor.setDireccion(rs.getString("direccion"));
                profesor.setDni(rs.getInt("dni"));
                profesor.setId_actiAcademica(rs.getInt("id_actiAcademica"));
                profesor.setId_carrera(rs.getInt("id_carrera"));
                profesor.setId_materia(rs.getInt("id_materia"));

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

    public boolean buscarApellido(Profesor profesor) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT *FROM t_profesor WHERE apellido=?";
        try {
            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(profesor.getApellido()));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                profesor.setId_profesor(rs.getInt("id_profesor"));
                profesor.setApellido(rs.getString("apellido"));
                profesor.setNombreProf(rs.getString("nombreProf"));
                profesor.setDireccion(rs.getString("direccion"));
                profesor.setDni(rs.getInt("dni"));
                profesor.setId_actiAcademica(rs.getInt("id_actiAcademica"));
                profesor.setId_carrera(rs.getInt("id_carrera"));
                profesor.setId_materia(rs.getInt("id_materia"));

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

    public ArrayList<Profesor> extraerListProfesores() {
        Statement st;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_profesor";
        ArrayList<Profesor> lista = new ArrayList<>();
        try {
            st = connP.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Profesor(
                        rs.getInt("id_profesor"),
                        rs.getString("apellido"),
                        rs.getString("nombreProf"),
                        rs.getString("direccion"),
                        rs.getInt("dni"),
                        rs.getInt("id_actiAcademica"),
                        rs.getInt("id_carrera"),
                        rs.getInt("id_materia")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Profesor> buscarNumDocList(Integer dni) {
        PreparedStatement pstmt;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_profesor WHERE num_documento =?";
        ArrayList<Profesor> listaNumDoc = new ArrayList<>();
        Profesor numDocProfesor;
        try {

            pstmt = connP.prepareStatement(sql);
            pstmt.setInt(1, dni);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                numDocProfesor = new Profesor();
                numDocProfesor.setId_profesor(rs.getInt(1));
                numDocProfesor.setApellido(rs.getString(2));
                numDocProfesor.setNombreProf(rs.getString(3));
                numDocProfesor.setDireccion(rs.getString(4));
                numDocProfesor.setDni(rs.getInt(5));
                numDocProfesor.setId_actiAcademica(rs.getInt(6));
                numDocProfesor.setId_carrera(rs.getInt(7));
                numDocProfesor.setId_materia(rs.getInt(8));

                listaNumDoc.add(numDocProfesor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("AQUI FALLO EL METODO buscarNumDoc en la CLASE GestionDatProfesor!!!!" + ex);
        }
        return listaNumDoc;
    }

    public ArrayList<Profesor> buscarApellidoList(String apellido) {
        PreparedStatement pstmt;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_profesor WHERE apellido LIKE ?";
        ArrayList<Profesor> listaApellido = new ArrayList<>();
        Profesor profesor;
        try {

            pstmt = connP.prepareStatement(sql);
            pstmt.setString(1, apellido + '%');
            rs = pstmt.executeQuery();
            while (rs.next()) {
                profesor = new Profesor();
                profesor.setId_profesor(rs.getInt(1));
                profesor.setApellido(rs.getString(2));
                profesor.setNombreProf(rs.getString(3));
                profesor.setDireccion(rs.getString(4));
                profesor.setDni(rs.getInt(5));
                profesor.setId_actiAcademica(rs.getInt(6));
                profesor.setId_carrera(rs.getInt(7));
                profesor.setId_materia(rs.getInt(8));

                listaApellido.add(profesor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("AQUI FALLO EL METODO buscarAppelido en la CLASE GestionDatProfesor!!!!" + ex);
        }
        return listaApellido;
    }

}
