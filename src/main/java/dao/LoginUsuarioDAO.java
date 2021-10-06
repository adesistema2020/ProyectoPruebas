package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import modelo.dataSource.SistemConec;

/**
 * @author AdeS
 */
public class LoginUsuarioDAO {

    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private static LoginUsuarioDAO instance;

    public LoginUsuarioDAO() throws FileNotFoundException {
        try {
            String url = "jdbc:mysql://localhost:3306/sistgestionusuarioV2.0";
            FileInputStream fis = new FileInputStream(SistemConec.FILEDBCONFIG);
            Properties prop = new Properties();
            prop.load(fis);
            this.conn = DriverManager.getConnection(url, prop);
            if (conn != null) {
                System.out.println("CONEXION EXITOSA A PEPE: " + conn.getCatalog());
            }
        } catch (SQLException ex) {
            System.out.println("SQLExeption:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("ERROR:" + ex.getErrorCode());

        } catch (IOException ex) {
            Logger.getLogger(LoginUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static LoginUsuarioDAO getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new LoginUsuarioDAO();
        }
        return instance;
    }
//    Revisar

    public Connection getLoginUsuarioDAO() {
        return conn;
    }

    public boolean getUsuario(Usuario usuario) {
        String sql = "SELECT * FROM t_registro WHERE usuario='" + usuario.getUsuario() + "'AND password ='" + usuario.getPassword() + "'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            return rs.first();
        } catch (Exception error) {
            error.printStackTrace();
        }
        return false;
    }
}
