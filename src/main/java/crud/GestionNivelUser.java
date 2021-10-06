package crud;

import dao.LoginUsuarioDAO;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.NivelUsuario;

/**
 * @author AdeS
 */
public class GestionNivelUser {

    private Connection conn;

    public GestionNivelUser() throws FileNotFoundException {
        conn = LoginUsuarioDAO.getInstance().getLoginUsuarioDAO();
    }

    public boolean ingresar(NivelUsuario nivelUsuario) {
        PreparedStatement pstmt = null;

        String sql = " INSERT INTO t_nivel_usuario (id_nivel, caracter) VALUES (?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nivelUsuario.getCaracter());
            pstmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.getMessage();

            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(NivelUsuario nivelUsuario) {
        PreparedStatement pstmt = null;

        String sql = " UP DATE t_nivel_usuario SET caracter=? WHWRE id_nivel=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nivelUsuario.getCaracter());
            pstmt.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.getMessage();
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(NivelUsuario nivelUsuario) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = " SELECT * FROM t_nivel_usuario WHERE id_nivel=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nivelUsuario.getId_nivel());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                nivelUsuario.setCaracter(rs.getString("Caracter"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.getMessage();
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

////////////////////////////////    
    public boolean mostrarTabNiveles() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = " SELECT * FROM t_nivel_usuario";
        System.out.println("se mostro aqui Metodo mostrarTabNiveles!!");
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            int registro = 0;
            while (rs.next()) {
                System.out.println("id_nivel: " + rs.getInt("id_nivel"));
                System.out.println("Caracter: " + rs.getString("caracter"));

                registro++;
            }
        } catch (Exception e) {
            System.out.println("No se mostro Metodo mostrarTabNiveles!!");
        }

        return true;

    }

    public boolean mostrarCaracter() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = " SELECT caracter FROM t_nivel_usuario";
        System.out.println("se mostro aqui Metodo mostrarCaracter!!");
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            int registro = 0;
            while (rs.next()) {
                System.out.println("Caracter: " + rs.getString("caracter"));

                registro++;
            }
        } catch (Exception e) {
            System.out.println("No se mostro Metodo mostrarTabNiveles!!");
        }

        return true;

    }

    public boolean mostrarIdNivel() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = " SELECT id_nivel FROM t_nivel_usuario";
        System.out.println("se mostro aqui Metodo mostrarIdNivel!!");
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            int registro = 0;
            while (rs.next()) {
                System.out.println("id_nivel: " + rs.getInt("id_nivel"));

                registro++;
            }
        } catch (Exception e) {
            System.out.println("No se mostro Metodo mostrarIdNivel!!");
        }

        return true;

    }

//    public ArrayList<NivelUsuario> mostrarNivelUsuario() {
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        ArrayList<NivelUsuario> listaNivelUsuario = new ArrayList<>();
//        String sql = " SELECT * FROM t_nivel_usuario";
//        
//        System.out.println("aqui se ejecuto Metodo ArrayList mostrarNivelUsuario!!");
//        try {
//            pstmt = conn.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                NivelUsuario nivelUsuario = new NivelUsuario();
//                nivelUsuario.setId_nivel(rs.getInt("id_nivel"));
//                nivelUsuario.setCaracter(rs.getString("caracter"));
//                listaNivelUsuario.add(nivelUsuario);
//            }
//        } catch (SQLException e) {
//        }
//        return listaNivelUsuario;
//    }
    public ArrayList<String> ObtenerNiveles() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<String> listaNivelUsuario = new ArrayList<>();
        String sql = " SELECT * FROM t_nivel_usuario";
        System.out.println("aqui se ejecuto Metodo ArrayList mostrarNivelUsuario!!");
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
//                NivelUsuario nivelUsuario = new NivelUsuario();
//                nivelUsuario.setId_nivel(rs.getInt("id_nivel"));
//                nivelUsuario.setCaracter(rs.getString("caracter"));
                listaNivelUsuario.add(rs.getString("caracter"));
            }
        } catch (SQLException e) {
        }
        return listaNivelUsuario;
    }

    public int obtenerIdNivel(String caracter) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int Id = 0;
        String sql = " SELECT id_nivel FROM t_nivel_usuario WHERE caracter = ?";
        System.out.println("se mostro aqui Metodo mostrarIdNivel!!");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, caracter);

            rs = pstmt.executeQuery();

            int registro = 0;
            while (rs.next()) {
                Id = rs.getInt("id_nivel");
//                System.out.println("id_nivel: " + rs.getInt("id_nivel"));
//                System.out.println("Caracter: " + rs.getString("caracter"));

                registro++;
            }
        } catch (Exception e) {
            System.out.println("No se mostro Metodo mostrarIdNivel!!");
        }
        return Id;

    }
    
     public int obtenerLisCaracter(Integer id_nivel) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int Id = 0;
        String sql = " SELECT carcater FROM t_nivel_usuario WHERE id_nivel = ?";
        System.out.println("se mostro aqui Metodo mostrarCaracter!!");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id_nivel);

            rs = pstmt.executeQuery();

            int registro = 0;
            while (rs.next()) {
                Id = rs.getInt("caracter");
//                System.out.println("id_nivel: " + rs.getInt("id_nivel"));
//                System.out.println("Caracter: " + rs.getString("caracter"));

                registro++;
            }
        } catch (Exception e) {
            System.out.println("No se mostro Metodo mostrarIdNivel!!");
        }
        return Id;

    }
}
