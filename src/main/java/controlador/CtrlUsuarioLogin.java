package controlador;

import dao.LoginUsuarioDAO;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vistas.UIValidarUsuario;
import vistas.gestionusuario.UIGestionUDirector;

/**
 * @author AdeS
 */
public class CtrlUsuarioLogin implements InterfaceValidacion {

    private UIValidarUsuario uiValidarUsuario;
    private LoginUsuarioDAO loginUsuarioDAO;
    private Usuario usuario;

    public CtrlUsuarioLogin() throws FileNotFoundException {
        loginUsuarioDAO = new LoginUsuarioDAO();
        usuario = new Usuario();
        uiValidarUsuario = new UIValidarUsuario(this);
    }

    @Override
    public void ingresarUsuario(String texto) {
        if (texto.length() > 1) {
            usuario.setUsuario(texto);
        }
    }

    @Override
    public void ingresarContrasenia(String texto) {
        if (texto.length() > 1) {
            usuario.setPassword(texto);
        }
    }

    @Override
    public void ingresar() {
        if (loginUsuarioDAO.getUsuario(usuario)) {
            

            UIGestionUDirector gestionUDirector = new UIGestionUDirector();
            gestionUDirector.setVisible(true);
            uiValidarUsuario.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrectas");
        }

    }

    @Override
    public void abrir() {
       uiValidarUsuario.setVisible(true);
    }
    
}
