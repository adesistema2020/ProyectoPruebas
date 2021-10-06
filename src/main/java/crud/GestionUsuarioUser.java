package crud;

import com.mysql.cj.protocol.Resultset;
import dao.LoginUsuarioDAO;
import java.awt.List;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

/**
 * @author AdeS
 */
public class GestionUsuarioUser {

    private Connection conn;

    public GestionUsuarioUser() throws FileNotFoundException {
        conn = LoginUsuarioDAO.getInstance().getLoginUsuarioDAO();
    }

    public boolean ingresar(Usuario user) {
        PreparedStatement pstmt = null;
        String sql = " INSERT INTO t_registro (usuario, password, apellido, nombre, dni, mail, legajo, id_t_nivel) VALUES (?,?,?,?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsuario());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getApellido());
            pstmt.setString(4, user.getNombre());
            pstmt.setInt(5, user.getDni());
            pstmt.setString(6, user.getMail());
            pstmt.setInt(7, user.getLegajo());
            pstmt.setInt(8, user.getId_t_nivel());
            pstmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("[GestionUsuarioUser]" + e.getMessage());
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

    public int modificar(Usuario user) {
        int r = 0;
        PreparedStatement pstmt = null;
        String sql = " UPDATE t_registro SET usuario=?, password=?, apellido=?, nombre=?, dni=?, mail=?, legajo=?, id_t_nivel=? WHERE id=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsuario());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getApellido());
            pstmt.setString(4, user.getNombre());
            pstmt.setInt(5, user.getDni());
            pstmt.setString(6, user.getMail());
            pstmt.setInt(7, user.getLegajo());
            pstmt.setInt(8, user.getId_t_nivel());
            pstmt.setInt(9, user.getId());
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
//            return 0;
        } finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                System.err.println(e);
//            }
        }
        return r;
    }

    public boolean buscarDNI(Usuario user) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = " SELECT * FROM t_registro WHERE dni=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getDni());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setApellido(rs.getString("apellido"));
                user.setNombre(rs.getString("nombre"));
                user.setDni(rs.getInt("dni"));
                user.setMail(rs.getString("mail"));
                user.setLegajo(rs.getInt("legajo"));
                user.setId_t_nivel(rs.getInt("Id_t_nivel"));

                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(sql);
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

    public boolean buscarApellido(Usuario user) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = " SELECT * FROM t_registro WHERE apellido=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(user.getApellido()));
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setApellido(rs.getString("apellido"));
                user.setNombre(rs.getString("nombre"));
                user.setDni(rs.getInt("dni"));
                user.setMail(rs.getString("mail"));
                user.setLegajo(rs.getInt("legajo"));
                user.setId_t_nivel(rs.getInt("Id_t_nivel"));
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

    public boolean buscarNomUsuario(Usuario user) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_registro WHERE usuario=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(user.getUsuario()));
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setApellido(rs.getString("apellido"));
                user.setNombre(rs.getString("nombre"));
                user.setDni(rs.getInt("dni"));
                user.setMail(rs.getString("mail"));
                user.setLegajo(rs.getInt("legajo"));
                user.setId_t_nivel(rs.getInt("Id_t_nivel"));
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

//    public  Resultset getConsultaTabla(int CantidadColumnas){
//    PreparedStatement pstmt = null;
////        Statement st;
//        ResultSet rs = null;
//        String sql = " SELECT usuario, password, apellido, nombre, dni, mail, legajo FROM t_registro";
//        try {
//            pstmt = conn.prepareStatement(sql);
////        st=conn.createStatement();
//            rs = pstmt.executeQuery();
////        rs= st.executeQuery(Consulta);
//        } catch (Exception e) {
//            System.out.print(e.toString());
//        }
//        return (Resultset) rs;
//    }
//public ArrayList <Usuario> extraerTodos(){
//        Statement st;
//        ResultSet rs = null;
//        String sql = " SELECT usuario, password, apellido, nombre, dni, mail, legajo FROM t_registro";
//        ArrayList <Usuario> lista = new ArrayList <>();
//        try {
//                st=conn.createStatement();
//                rs= st.executeQuery(sql);
//                while(rs.next()){
//                lista.add(new Usuario(
//                        rs.getString("usuario"),
//                        rs.getString("password"),
//                        rs.getString("apellido"),
//                        rs.getString("nombre"),
//                        rs.getInt("dni"),
//                        rs.getString("mail"),
//                        rs.getInt("legajo")));
//                }
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    }
//        return lista;
//}
    public ArrayList<Usuario> extraerTodos() {
        Statement st;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_registro";
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Leyendo Fila De Tabla");
                lista.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("usuario"),
                        rs.getString("password"),
                        rs.getString("apellido"),
                        rs.getString("nombre"),
                        rs.getInt("dni"),
                        rs.getString("mail"),
                        rs.getInt("legajo"),
                        rs.getInt("Id_t_nivel")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Usuario> buscarApellido(String apellido ) {
        PreparedStatement pstmt;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_registro WHERE apellido LIKE ?";
        ArrayList<Usuario> listaAp = new ArrayList<>();
        Usuario usuario;
        try {

            pstmt = conn.prepareStatement(sql);
////            Todos los apellidos que comienzen con 
            pstmt.setString(1, apellido+ '%');
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Leyendo Fila De Tabla" +rs);
                usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setPassword(rs.getString(3));
                usuario.setApellido(rs.getString(4));
                usuario.setNombre(rs.getString(5));
                usuario.setDni(rs.getInt(6));
                usuario.setMail(rs.getString(7));
                usuario.setLegajo(rs.getInt(8));
                usuario.setId_t_nivel(rs.getInt(9));
                listaAp.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAp;
    }
    
     public ArrayList<Usuario> buscarDNI(Integer dni) {
        PreparedStatement pstmt;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_registro WHERE dni =?";
        ArrayList<Usuario> listaDni = new ArrayList<>();
        Usuario DniUsuario;
        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dni);
//            pstmt.setInt(1, (int) dni);
            rs = pstmt.executeQuery();
            while (rs.next()) {
//                System.out.println("Leyendo Fila De Tabla Busca dni" +sql);
                DniUsuario = new Usuario();
                 
                DniUsuario.setId(rs.getInt(1));
                DniUsuario.setUsuario(rs.getString(2));
                DniUsuario.setPassword(rs.getString(3));
                DniUsuario.setApellido(rs.getString(4));
                DniUsuario.setNombre(rs.getString(5));
                DniUsuario.setDni(rs.getInt(6));
                DniUsuario.setMail(rs.getString(7));
                DniUsuario.setLegajo(rs.getInt(8));
                DniUsuario.setId_t_nivel(rs.getInt(9));
                
                listaDni.add(DniUsuario);
                System.out.println("muestra lista dni" +DniUsuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("aquiiiii fallo buscaDNI!!!!"+ex);
        }
        return listaDni;
    }
     
    public ArrayList<Usuario> buscarUsuario(String usuario) {
        PreparedStatement pstmt;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_registro WHERE usuario LIKE ?";
        ArrayList<Usuario> listUsuario = new ArrayList<>();
        Usuario Nusuario;
        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario+ '%');
            rs = pstmt.executeQuery();
            while (rs.next()) {
//                System.out.println("Leyendo Fila De Tabla" +rs);
                Nusuario = new Usuario();
                Nusuario.setId(rs.getInt(1));
                Nusuario.setUsuario(rs.getString(2));
                Nusuario.setPassword(rs.getString(3));
                Nusuario.setApellido(rs.getString(4));
                Nusuario.setNombre(rs.getString(5));
                Nusuario.setDni(rs.getInt(6));
                Nusuario.setMail(rs.getString(7));
                Nusuario.setLegajo(rs.getInt(8));
                Nusuario.setId_t_nivel(rs.getInt(9));
                listUsuario.add(Nusuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listUsuario;
    }

//    public DefaultTableModel extraerTodo() {
//        Statement st;
//        ResultSet rs = null;
//        String[] titulos = {"usuario", "password", "apellido", "nombre", "dni", "mail", "legajo"};
//        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
//        String[] registros = new String[7];
//        String sql = " SELECT usuario, password, apellido, nombre, dni, mail, legajo FROM t_registro";
//        try {
//            st = conn.createStatement();
//            rs = st.executeQuery(sql);
//            while (rs.next()) {
//                registros[0] = rs.getString("usuario");
//                registros[1] = rs.getString("password");
//                registros[2] = rs.getString("apellido");
//                registros[3] = rs.getString("nombre");
//                registros[4] = String.valueOf(rs.getInt("dni"));
//                registros[5] = rs.getString("mail");
//                registros[6] = String.valueOf(rs.getInt("legajo"));
//                modelo.addRow(registros);
//            }
////            return modelo;
//        } catch (Exception e) {
//            System.err.println(e);
////            return null;
//        }
//        return modelo;
//    }
}
