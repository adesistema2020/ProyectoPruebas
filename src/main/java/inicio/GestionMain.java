package inicio;

import controlador.CtrlUsuarioLogin;
import controlador.gestionusuario.CtrlNuevoUsuarioDir;
import crud.GestionNivelUser;
import crud.GestionUsuarioUser;
import java.io.FileNotFoundException;
import java.io.IOException;
import modelo.Usuario;
import vistas.gestionusuario.UiNuevoUsuarioDir;

/**
 * @author AdeS
 */
public class GestionMain {

    public GestionMain() throws FileNotFoundException {

    }

    public static void main(String[] args) throws FileNotFoundException {

        CtrlUsuarioLogin ctrlUsuarioLogin = new CtrlUsuarioLogin();
//        try {
//            new GestionMain();
//        } catch (IOException ex) {
//            System.out.println("Error :" + ex.getMessage());
//        } catch (Exception x) {
//            System.out.println("Error :" + x.getMessage());
//        }
        ctrlUsuarioLogin.abrir();
//     GestionNivelUser gestionNivelUser = new GestionNivelUser();
//     gestionNivelUser.mostrarTabNiveles();
//     gestionNivelUser.mostrarCaracter();
//     gestionNivelUser.mostrarIdNivel();
//GestionUsuarioUser gestionUsuarioUser = new GestionUsuarioUser();

    }
}
