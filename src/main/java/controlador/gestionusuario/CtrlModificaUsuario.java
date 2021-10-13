package controlador.gestionusuario;

import crud.GestionNivelUser;
import crud.GestionUsuarioUser;
import dao.LoginUsuarioDAO;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.NivelUsuario;
import modelo.Usuario;
import modelo.dataSource.SistemConec;
import vistas.gestionusuario.UIModificaUsuario;

/**
 * @author AdeS
 */
public class CtrlModificaUsuario implements ActionListener, KeyListener {

    DefaultTableModel modelo = new DefaultTableModel();
    private TableRowSorter trs;
    private Usuario modU;
    private NivelUsuario modNU;
    private GestionUsuarioUser crudGUU;
    private GestionNivelUser crudGNU;
    private UIModificaUsuario frmModifica;
//    private Connection conn;

    public CtrlModificaUsuario() throws FileNotFoundException {
        modU = new Usuario();
        modNU = new NivelUsuario();
        crudGUU = new GestionUsuarioUser();
        crudGNU = new GestionNivelUser();
    }

    public CtrlModificaUsuario(UIModificaUsuario frmModificaCarga) throws FileNotFoundException {
        modU = new Usuario();
        modNU = new NivelUsuario();
        crudGUU = new GestionUsuarioUser();
        crudGNU = new GestionNivelUser();
        frmModifica = frmModificaCarga;
    }

    public CtrlModificaUsuario(Usuario modU, GestionUsuarioUser crudGUU, UIModificaUsuario frmModifica) throws FileNotFoundException {
        this.modU = modU;
        this.modNU = new NivelUsuario();
        this.crudGUU = crudGUU;
        this.crudGNU = new GestionNivelUser();
        this.frmModifica = frmModifica;
//        this.frmModifica.jBtnBuscarDNI.addActionListener(this);
//        this.frmModifica.jBtnBuscarApellido.addActionListener(this);
//        this.frmModifica.jBtnBuscarUsuario.addActionListener(this);
        this.frmModifica.jBtnModifica.addActionListener(this);
        this.frmModifica.jBtnGuardaCambios.addActionListener(this);
    }

    public CtrlModificaUsuario(NivelUsuario modNU, GestionNivelUser crudGNU, UIModificaUsuario frmModifica) throws FileNotFoundException {
        modU = new Usuario();
        this.modNU = modNU;
        crudGUU = new GestionUsuarioUser();
        this.crudGNU = crudGNU;
        this.frmModifica = frmModifica;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == frmModifica.jBtnBuscarDNI) {
//            cargaTabla(frmModifica.jTableListadoUsuario);
//            String buscar = frmModifica.jBtnBuscarDNI.getText();
//            String where = "";
//
//            if (!"".equals(buscar)) {
////            where = "SELECT * FROM t_registro WHERE dni = '" + buscar + "'";
////            where = "SELECT crudGUU.buscarDNI(modU) WHERE dni = '" + buscar + "'";
//                where = crudGUU.buscarDNI(modU) + buscar + "'";
//
//                DefaultTableModel modelo = new DefaultTableModel();
//            }
//        }
        if (e.getSource() == frmModifica.jBtnModifica) {
            int fila = frmModifica.jTableListadoUsuario.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(frmModifica, "Debe Seleccionar una Fila");
            } else {
                try {
                    frmModifica.jTxtId.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 0)));
                    frmModifica.jTxtNombreUsuario.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 1)));
                    frmModifica.jTxtContrasenia.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 2)));
                    frmModifica.jTxtApellido.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 3)));
                    frmModifica.jTxtNombre.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 4)));
                    frmModifica.jTxtDNI.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 5)));
                    frmModifica.jTxtMail.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 6)));
                    frmModifica.jTxtLegajo.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 7)));
                    
                          System.out.println("NivelUsuario!!!!!"+((frmModifica.jTableListadoUsuario.getValueAt(fila, 8))));
           frmModifica.jTxtId_t_nivel.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 8)));
//////         modU.setId_t_nivel(crudGNU.obtenerIdNivel(frm.jcbxNivelUsuario.getItemAt(frm.jcbxNivelUsuario.getSelectedIndex())));
//                    frmModifica.jcbxNivelUsuario.getItemAt(modNU.setId_nivel(crudGNU.obtenerLisCaracter(frmModifica.jTxtId_t_nivel.getIt))));
//// buscar caracter de id_ nivel y seleccionar en el combo

                } catch (Exception ex) {
                    System.out.print(ex.toString());
                }
            }
        }
        if (e.getSource() == frmModifica.jBtnGuardaCambios) {
            ModificarUnUsuario();
            limpiarTabla();
            cargarRegistrosTabla(frmModifica.jTableListadoUsuario, 1, null);
        }
    }

//    public void KeyTyped(KeyEvent e) {
//        filtrarTabla();
//        }
//    
//    public void filtrarTabla(){
//        try {
//           trs.setRowFilter(RowFilter.regexFilter(frmModifica.jTxtBuscarApellido.getText(), 3));
//        } catch (Exception e) {
//        }
//    }
////////    Retomar busqued de elemento
//public void filtrarTabla (String query){
//TableRowSorter<DefaultTableModel>filtrar = new TableRowSorter<DefaultTableModel>(modelo);
//frmModifica.jTableListadoUsuario.setRowSorter(filtrar);
//
//filtrar.setRowFilter(RowFilter.regexFilter(query));
//}
//    public void KeyTyped(KeyEvent e) {
//        
//        }
////        String[] titulos = {"id", "usuario", "apellido", "nombre", "dni", "mail", "legajo", "Id_t_nivel"};
////        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
//        frmModifica.jTxtBuscarApellido.addKeyListener(new KeyAdapter() {
//            public void KeyReleased(KeyEvent ke) {
//
//                trs.setRowFilter(RowFilter.regexFilter("(?i)"+frmModifica.jTxtBuscarApellido.getText(), 3));
//            }
//        });
//        trs = new TableRowSorter(modelo);
//        System.out.println("controlador.gestionusuario.CtrlModificaUsuario.KeyTyped()" + trs);
//        frmModifica.jTableListadoUsuario.setRowSorter(trs);
//    }
////////////// Sellecciona fila de tabla y las muestras en caja de texto   
//    public void mouseClicked(MouseEvent e) {
//        if (frmModifica.jTableListadoUsuario.getSelectedRow() >= 0) {
//            try {
////                DefaultTableModel tm = (DefaultTableModel) frmModifica.jTableListadoUsuario.getModel();
//                int fila = frmModifica.jTableListadoUsuario.getSelectedRow();
//                frmModifica.jTxtId.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 0)));
//                frmModifica.jTxtNombreUsuario.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 1)));
//                frmModifica.jTxtContrasenia.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 2)));
//                frmModifica.jTxtApellido.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 3)));
//                frmModifica.jTxtNombre.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 4)));
//                frmModifica.jTxtDNI.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 5)));
//                frmModifica.jTxtMail.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 6)));
//                frmModifica.jTxtLegajo.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 7)));
//                frmModifica.jTxtId_t_nivel.setText(String.valueOf(frmModifica.jTableListadoUsuario.getValueAt(fila, 8)));
////                String selecciona = frmModifica.jTableListadoUsuario.getValueAt(fila, 0).toString();
////String id = String.valueOf(tm.getValueAt(frmModifica.jTableListadoUsuario.getSelectedRow(), 0));
////String usuario = String.valueOf(tm.getValueAt(frmModifica.jTableListadoUsuario.getSelectedRow(), 1));
////String password = String.valueOf(tm.getValueAt(frmModifica.jTableListadoUsuario.getSelectedRow(), 2));
////String apellido = String.valueOf(tm.getValueAt(frmModifica.jTableListadoUsuario.getSelectedRow(), 3));
////String nombre = String.valueOf(tm.getValueAt(frmModifica.jTableListadoUsuario.getSelectedRow(), 4));
////String dni = String.valueOf(tm.getValueAt(frmModifica.jTableListadoUsuario.getSelectedRow(), 5));
////String mail = String.valueOf(tm.getValueAt(frmModifica.jTableListadoUsuario.getSelectedRow(), 6));
////String legajo = String.valueOf(tm.getValueAt(frmModifica.jTableListadoUsuario.getSelectedRow(), 7));
////String Id_t_nivel = String.valueOf(tm.getValueAt(frmModifica.jTableListadoUsuario.getSelectedRow(), 8));
//
//            } catch (Exception ex) {
//                System.out.print(ex.toString());
//            }
//        }
//    }
    public void cargaTabla(JTable tabla) {
//        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("id");
        modelo.addColumn("usuario");
        modelo.addColumn("password");
        modelo.addColumn("apellido");
        modelo.addColumn("nombre");
        modelo.addColumn("dni");
        modelo.addColumn("mail");
        modelo.addColumn("legajo");
        modelo.addColumn("Id_t_nivel");

    }

    public void cargarRegistrosTabla(JTable tabla, int tipoBusqueda, Object dato) {
        Object[] columna = new Object[9];

        ArrayList<Usuario> registros = null;
        switch (tipoBusqueda) {
            case 1:
                registros = crudGUU.extraerTodos();
                break;
            case 2:
                registros = crudGUU.buscarApellido(String.valueOf(dato));
                break;
            case 3:
                registros = crudGUU.buscarUsuario(String.valueOf(dato));
//                System.out.println("controladoSystemr.gestionusuario.CtrlModificaUsuario.cargarRegistrosTabla() CASO 3" + registros);
                break;
            case 4:
//                System.out.println("controladoSystemr.gestionusuario.CtrlModificaUsuario.cargarRegistrosTabla() CASO 4" + crudGUU);
//                  System.out.println("controladoSystemr.gestionusuario.CtrlModificaUsuario.cargarRegistrosTabla() CASO 4" + registros);
                registros = crudGUU.buscarDNI(Integer.valueOf(String.valueOf(dato)));
//                System.out.println("controladoSystemr.gestionusuario.CtrlModificaUsuario.cargarRegistrosTabla() CASO 4" + registros);
                break;
            default:
//                System.err.println("Cargar registro tabla opcion busqueda invalida");
                registros = crudGUU.extraerTodos();
        }
        
        int usuariosGuardados = registros.size();

        for (int i = 0; i < usuariosGuardados; i++) {
            System.out.println("Cargando Fila a la Tabla");

            columna[0] = registros.get(i).getId();
            columna[1] = registros.get(i).getUsuario();
            columna[2] = registros.get(i).getPassword();
            columna[3] = registros.get(i).getApellido();
            columna[4] = registros.get(i).getNombre();
            columna[5] = registros.get(i).getDni();
            columna[6] = registros.get(i).getMail();
            columna[7] = registros.get(i).getLegajo();
            columna[8] = registros.get(i).getId_t_nivel();

            modelo.addRow(columna);
        }

    }

    public void ModificarUnUsuario() {

        int Id = Integer.parseInt(frmModifica.jTxtId.getText());
        String Apellido = frmModifica.jTxtApellido.getText();
        String Nombre = frmModifica.jTxtNombre.getText();
        int Dni = Integer.parseInt(frmModifica.jTxtDNI.getText());
        int Legajo = Integer.parseInt(frmModifica.jTxtLegajo.getText());
        String Mail = frmModifica.jTxtMail.getText();
        int Id_t_nivel = crudGNU.obtenerIdNivel(frmModifica.jcbxNivelUsuario.getItemAt(frmModifica.jcbxNivelUsuario.getSelectedIndex()));
        String Usuario = frmModifica.jTxtNombreUsuario.getText();
        String Password = String.valueOf(frmModifica.jTxtContrasenia.getPassword());

        modU.setId(Id);
        modU.setApellido(Apellido);
        modU.setNombre(Nombre);
        modU.setDni(Dni);
        modU.setLegajo(Legajo);
        modU.setMail(Mail);
        modU.setId_t_nivel(Id_t_nivel);
        modU.setUsuario(Usuario);
        modU.setPassword(Password);

        try {
            int modifica = crudGUU.modificar(modU);
            if (modifica == 1) {
                JOptionPane.showMessageDialog(frmModifica, "Usuario Modificado correctamente");
            } else {
                JOptionPane.showMessageDialog(frmModifica, "No se pudo modificar la información Metodo ModificaUnUsuario");
            }

        } catch (Exception e) {
            System.out.println("Se produjo un error de carga!!");
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < frmModifica.jTableListadoUsuario.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

//    public void limpiar() {
//        frmModifica.jTxtId.setText(null);
//        frmModifica.jTxtApellido.setText(null);
//        frmModifica.jTxtNombre.setText(null);
//        frmModifica.jTxtDNI.setText(null);
//        frmModifica.jTxtLegajo.setText(null);
//        frmModifica.jTxtMail.setText(null);
//        frmModifica.jTxtNombreUsuario.setText(null);
//        frmModifica.jTxtContrasenia.setText(null);
//        frmModifica.jTxtId_t_nivel.setText(null);
//    }
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == frmModifica.jTxtApellido || e.getSource() == frmModifica.jTxtBuscarUsuario) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_SPACE)) {
                e.consume();
            }
        }
        if (e.getSource() == frmModifica.jTxtBuscarDNI) {
            char c = e.getKeyChar();
            if (c < '0' || c > '9') {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == frmModifica.jTxtBuscarApellido) {
//             System.out.println(" Se Leyo el valor de JtxtBuscarApellido!!!!!"+frmModifica.jTxtBuscarApellido);
            String apellido = frmModifica.jTxtBuscarApellido.getText();
            limpiarTabla();
            cargarRegistrosTabla(frmModifica.jTableListadoUsuario, 2, apellido);

        }
        if (e.getSource() == frmModifica.jTxtBuscarUsuario) {
//             System.out.println(" Se Leyo el valor de JtxtBuscarUsuario!!!!!"+frmModifica.jTxtBuscarUsuario);
            String usuario = frmModifica.jTxtBuscarUsuario.getText();
            limpiarTabla();
            cargarRegistrosTabla(frmModifica.jTableListadoUsuario, 3, usuario);
//// idem al anterior If
        }

        if (e.getSource() == frmModifica.jTxtBuscarDNI) {
            try {
                int dni = Integer.valueOf(frmModifica.jTxtBuscarDNI.getText());
//                String dni = (frmModifica.jTxtBuscarDNI.getText());
                limpiarTabla();

//                System.out.println(" Se Leyo el valor de JtxtBuscarDni caso 4 KeyRelease!!!!!" + frmModifica.jTableListadoUsuario);
                cargarRegistrosTabla(frmModifica.jTableListadoUsuario, 4, dni);
                
            } catch (Exception ex) {
                System.err.println("aquiiiii falla caso 4 KeyRelease!!!!" + ex);
            }

////            Idemn al primer if
        }

    }
}
