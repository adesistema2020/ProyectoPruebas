package controlador.gestionusuario;

import crud.GestionNivelUser;
import crud.GestionUsuarioUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.NivelUsuario;
import modelo.Usuario;
import vistas.gestionusuario.UiNuevoUsuarioDir;

/**
 * @author AdeS
 */
public class CtrlNuevoUsuarioDir implements ActionListener {

    private Usuario modU;
    private NivelUsuario modNU;
    private GestionUsuarioUser crudGUU;
    private GestionNivelUser crudGNU;
    private UiNuevoUsuarioDir frm;

    public CtrlNuevoUsuarioDir() {
    }

    public CtrlNuevoUsuarioDir(UiNuevoUsuarioDir frmVentana) throws FileNotFoundException {
        modU = new Usuario();
        modNU = new NivelUsuario();
        crudGUU = new GestionUsuarioUser();
        crudGNU = new GestionNivelUser();
        frm = frmVentana;
    }

    public CtrlNuevoUsuarioDir(Usuario modU, GestionUsuarioUser crudGUU, UiNuevoUsuarioDir frm) throws FileNotFoundException {
        this.modU = modU;
        this.modNU = new NivelUsuario();
        this.crudGUU = crudGUU;
        this.crudGNU = new GestionNivelUser();
        this.frm = frm;
        this.frm.jBtnGuardar.addActionListener(this);
    }

    public CtrlNuevoUsuarioDir(NivelUsuario modNU, GestionNivelUser crudGNU, UiNuevoUsuarioDir frm) throws FileNotFoundException {
        modU = new Usuario();
        this.modNU = modNU;
        crudGUU = new GestionUsuarioUser();
        this.crudGNU = crudGNU;
        this.frm = frm;
    }

    public void iniciar() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.jBtnGuardar) {
            modU.setApellido(frm.jTxtApellido.getText());
            modU.setNombre(frm.jTxtNombre.getText());
            modU.setDni(Integer.parseInt(frm.jTxtDNI.getText()));
            modU.setLegajo(Integer.parseInt(frm.jTxtLegajo.getText()));
            modU.setMail(frm.jTxtMail.getText());

//////////////////
//////  Capturar el Id del nivel seleccionado en el Combo y pasarlo a setId_t_nivel, mediante el CRUD del nivel de Usuario
//////////////////   
//          System.out.println("NivelUsuario!!!!!"+frm.jcbxNivelUsuario.getItemAt(frm.jcbxNivelUsuario.getSelectedIndex()));
            modU.setId_t_nivel(crudGNU.obtenerIdNivel(frm.jcbxNivelUsuario.getItemAt(frm.jcbxNivelUsuario.getSelectedIndex())));
            modU.setUsuario(frm.jTxtNombreUsuario.getText());
            modU.setPassword(String.valueOf(frm.jPassContrasenia.getPassword()));
            System.out.println("es aqui!!");
        }

        try {
            if (crudGUU.ingresar(modU)) {

                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Se produjo un error al ingresar los datos");
                limpiar();

            }
        } catch (Exception ex) {
            System.out.println("No se pudo insertar nuevo usuario!!");
        }
    }

    public void limpiar() {
        frm.jTxtApellido.setText(null);
        frm.jTxtNombre.setText(null);
        frm.jTxtDNI.setText(null);
        frm.jTxtLegajo.setText(null);
        frm.jTxtMail.setText(null);
        frm.jcbxNivelUsuario.setSelectedIndex(0);
        frm.jTxtNombreUsuario.setText(null);
        frm.jPassContrasenia.setText(null);
    }
}
