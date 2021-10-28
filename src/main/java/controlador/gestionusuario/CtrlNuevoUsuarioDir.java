package controlador.gestionusuario;

import crud.GestionNivelUser;
import crud.GestionUsuarioUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class CtrlNuevoUsuarioDir implements ActionListener, KeyListener {

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

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == frm.jTxtApellido || e.getSource() == frm.jTxtNombre || e.getSource() == frm.jTxtNombreUsuario) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_SPACE)&& (c != (char) KeyEvent.VK_DELETE)) {
                e.consume();
                JOptionPane.showMessageDialog(frm,
                        "Solo se permiten los caracteres de la " + " a " + " a la " + " z " + " y de la " + " A " + " a la " + " Z ");
            }
        }
        if (e.getSource() == frm.jTxtDNI || e.getSource() == frm.jTxtLegajo) {
            char c = e.getKeyChar();
            if (c < '0' || c > '9') {
                e.consume();
                JOptionPane.showMessageDialog(frm, " Solo se permiten los caracteres " + " 0 " + " al " + " 1 ");
            }
        }

    }
    

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (frm.jTxtMail.getText().isEmpty()) {}
        else if (!frm.jTxtMail.getText().contains("@") || !frm.jTxtMail.getText().contains(".")) {}
        else {
            JOptionPane.showMessageDialog(frm, "Su correo no es valido, debe contener " + 
                    " @ " + " y un " + " . ");
        }
    }

}

