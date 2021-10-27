package inicio;

import controlador.CtrlUsuarioLogin;
import controlador.gestionreportes.CtrlGeneradorReportes;
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

    public static void main(String[] args) throws FileNotFoundException, IOException {

        CtrlUsuarioLogin ctrlUsuarioLogin = new CtrlUsuarioLogin();

        ctrlUsuarioLogin.abrir();
        
//        CtrlGeneradorReportes repAuxiliares = new CtrlGeneradorReportes();
//        repAuxiliares.printReporteAuxiliares("src/main/java/vistas/reporte/ReporteFinalLp2020", "ReporteAux", 916);
//        System.out.println("aquiiiiiRepor");
    }
}
