package controlador.gestionprofesor;

import crud.gestionprofesor.GestionDataCarrera;

import crud.gestionprofesor.GestionDataCategoria;
import crud.gestionprofesor.GestionDataDedicacion;

import crud.gestionprofesor.GestionDataMateria;

import crud.gestionprofesor.GestionDataProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.gestionprofesor.Carrera;
import modelo.gestionprofesor.Categoria;

import modelo.gestionprofesor.Dedicacion;

import modelo.gestionprofesor.Materia;

import modelo.gestionprofesor.Profesor;
import vistas.gestionprofesor.UINuevoIngresoProf;

/**
 * @author AdeS
 */
public class CtrlIngresoProfesor implements ActionListener, KeyListener {

    private Profesor modProf;

    private Carrera modCra;
    private Materia modMat;
    private Categoria modCat;
    private Dedicacion modDcion;
    private GestionDataProfesor crudDProf;
    private GestionDataCarrera crudDCra;
    private GestionDataMateria crudDMat;
    private GestionDataCategoria crudDCat;
    private GestionDataDedicacion crudDDcion;
    private UINuevoIngresoProf frm;

    DefaultTableModel modeloC = new DefaultTableModel();
    DefaultTableModel modeloM = new DefaultTableModel();

    public CtrlIngresoProfesor() {
    }

    public CtrlIngresoProfesor(UINuevoIngresoProf frmFormulario) throws IOException {
        modProf = new Profesor();
        modCra = new Carrera();
        modMat = new Materia();
        modCat = new Categoria();
        modDcion = new Dedicacion();
        crudDProf = new GestionDataProfesor();
        crudDCra = new GestionDataCarrera();
        crudDMat = new GestionDataMateria();
        crudDCat = new GestionDataCategoria();
        crudDDcion = new GestionDataDedicacion();
        frm = frmFormulario;

    }

    public CtrlIngresoProfesor(Profesor modProf, GestionDataProfesor crudDProf, UINuevoIngresoProf frm) throws IOException {
        this.modProf = modProf;
        modCra = new Carrera();
        modMat = new Materia();
        modCat = new Categoria();
        modDcion = new Dedicacion();
        this.crudDProf = crudDProf;
        crudDCra = new GestionDataCarrera();
        crudDMat = new GestionDataMateria();
        crudDCat = new GestionDataCategoria();
        crudDDcion = new GestionDataDedicacion();
        this.frm = frm;
        this.frm.jBtnGuardar.addActionListener(this);
        this.frm.jBtnSelecCarrera.addActionListener(this);
        this.frm.jBtnSelecMateria.addActionListener(this);
    }

    public CtrlIngresoProfesor(Carrera modCra, GestionDataCarrera crudDCra, UINuevoIngresoProf frm) throws IOException {
        modProf = new Profesor();
        this.modCra = modCra;
        modMat = new Materia();
        modCat = new Categoria();
        modDcion = new Dedicacion();
        crudDProf = new GestionDataProfesor();
        this.crudDCra = crudDCra;
        crudDMat = new GestionDataMateria();
        crudDCat = new GestionDataCategoria();
        crudDDcion = new GestionDataDedicacion();
        this.frm = frm;
    }

    public CtrlIngresoProfesor(Materia modMat, GestionDataMateria crudDMat, UINuevoIngresoProf frm) throws IOException {
        modProf = new Profesor();
        modCra = new Carrera();
        this.modMat = modMat;
        modCat = new Categoria();
        modDcion = new Dedicacion();
        crudDProf = new GestionDataProfesor();
        crudDCra = new GestionDataCarrera();
        this.crudDMat = crudDMat;
        crudDCat = new GestionDataCategoria();
        crudDDcion = new GestionDataDedicacion();
        this.frm = frm;

    }

    public CtrlIngresoProfesor(Categoria modCat, GestionDataCategoria crudDCat, UINuevoIngresoProf frm) throws IOException {
        modProf = new Profesor();
        modCra = new Carrera();
        modMat = new Materia();
        this.modCat = modCat;
        modDcion = new Dedicacion();
        crudDProf = new GestionDataProfesor();
        crudDCra = new GestionDataCarrera();
        crudDMat = new GestionDataMateria();
        this.crudDCat = crudDCat;
        crudDDcion = new GestionDataDedicacion();
        this.frm = frm;

    }

    public CtrlIngresoProfesor(Dedicacion modDcion, GestionDataDedicacion crudDDcion, UINuevoIngresoProf frm) throws IOException {
        modProf = new Profesor();
        modCra = new Carrera();
        modMat = new Materia();
        modCat = new Categoria();
        this.modDcion = modDcion;
        crudDProf = new GestionDataProfesor();
        crudDCra = new GestionDataCarrera();
        crudDMat = new GestionDataMateria();
        crudDCat = new GestionDataCategoria();
        this.crudDDcion = crudDDcion;
        this.frm = frm;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frm.jBtnSelecCarrera) {
            int fila = frm.jTableDatosCarrera.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(frm, "Debe Seleccionar una Fila");
            } else {
                try {
                    frm.jTxtIdCarrera.setText(String.valueOf(frm.jTableDatosCarrera.getValueAt(fila, 0)));
                    frm.jTxtCodCarrera.setText(String.valueOf(frm.jTableDatosCarrera.getValueAt(fila, 1)));
                    frm.jTxtNomCarrera.setText(String.valueOf(frm.jTableDatosCarrera.getValueAt(fila, 2)));
                } catch (Exception ex) {
                    System.out.print(ex.toString());
                }
            }
        }
        if (e.getSource() == frm.jBtnSelecMateria) {
            int fila = frm.jTableDatosMateria.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(frm, "Debe Seleccionar una Fila");
            } else {
                try {
                    frm.jTxtIdMateria.setText(String.valueOf(frm.jTableDatosMateria.getValueAt(fila, 0)));
                    frm.jTxtCodMateria.setText(String.valueOf(frm.jTableDatosMateria.getValueAt(fila, 1)));
                    frm.jTxtNomMateria.setText(String.valueOf(frm.jTableDatosMateria.getValueAt(fila, 2)));
                } catch (Exception ex) {
                    System.out.print(ex.toString());
                }
            }
        }
        if (e.getSource() == frm.jBtnGuardar) {
//            modProf.setId_profesor(Integer.parseInt(frm.jTxtIdProfesor.getText()));
            modProf.setApellido(frm.jTxtApellido.getText());
            modProf.setNombreProf(frm.jTxtNombre.getText());
            modProf.setDni(Integer.parseInt(frm.jTxtNumeroDoc.getText()));
            modProf.setDireccion(frm.jTxtDireccion.getText());
            modCra.setCodCarrera(Integer.parseInt(frm.jTxtCodCarrera.getText()));
            modCra.setNomCarrera(frm.jTxtNomCarrera.getText());
            modMat.setCodMateria(Integer.parseInt(frm.jTxtCodMateria.getText()));
            modMat.setNomMateria(frm.jTxtNomMateria.getText());
        }
    }

    public void cargaTabla(JTable tablaCarrera) {
        tablaCarrera.setModel(modeloC);
        modeloC.addColumn("idCarrera");
        modeloC.addColumn("Cod de Carrera");
        modeloC.addColumn("Nom de Carrera");
    }

    public void cargaTablaM(JTable tablaMaterias) {
        tablaMaterias.setModel(modeloM);
        modeloM.addColumn("idMateria");
        modeloM.addColumn("Cod de Materia");
        modeloM.addColumn("Nom de Materia");
    }

    public void cargaTablaCarreras(JTable tablaCarrera, int tipoBusquedaCarr, Object dato) throws SQLException {
        Object[] columna = new Object[3];

        ArrayList<Carrera> registros = null;
        switch (tipoBusquedaCarr) {
            case 1:
                registros = crudDCra.extraerTodas();
                break;
            case 2:
                registros = crudDCra.buscarNomCarrera(String.valueOf(dato));
                break;
            case 3:
                registros = crudDCra.buscarCodigoCarr(Integer.valueOf(String.valueOf(dato)));
                break;
            default:
                registros = crudDCra.extraerTodas();
        }
        int carrerasDisponibles = registros.size();

        for (int i = 0; i < carrerasDisponibles; i++) {
            System.out.println("Cargando Fila a la Tabla Carreras");

            columna[0] = registros.get(i).getId_carrera();
            columna[1] = registros.get(i).getCodCarrera();
            columna[2] = registros.get(i).getNomCarrera();

            modeloC.addRow(columna);
        }
    }

    public void cargaTablaMaterias(JTable tablaMateria, int tipoBusquedaMat, Object dato) throws SQLException {
        Object[] columna = new Object[3];

        ArrayList<Materia> registros = null;
        switch (tipoBusquedaMat) {
            case 1:
                registros = crudDMat.extraerTodas();
                break;
            case 2:
                registros = crudDMat.buscarNomMateria(String.valueOf(dato));
                break;
            case 3:
                registros = crudDMat.buscarCodigoMat(Integer.valueOf(String.valueOf(dato)));
                break;
            default:
                registros = crudDMat.extraerTodas();
        }
        int carrerasDisponibles = registros.size();

        for (int i = 0; i < carrerasDisponibles; i++) {
            System.out.println("Cargando Fila a la Tabla Materia");

            columna[0] = registros.get(i).getId_materia();
            columna[1] = registros.get(i).getCodMateria();
            columna[2] = registros.get(i).getNomMateria();

            modeloM.addRow(columna);
        }
    }

    public void limpiarTablaCarrera() {
        for (int i = 0; i < frm.jTableDatosCarrera.getRowCount(); i++) {
            modeloC.removeRow(i);
            i = i - 1;
        }
    }

    public void limpiarTablaMateria() {
        for (int i = 0; i < frm.jTableDatosMateria.getRowCount(); i++) {
            modeloM.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == frm.jTxtApellido || e.getSource() == frm.jTxtNombre || e.getSource() == frm.jTxtDireccion
                || e.getSource() == frm.jTxtBusquedaNomCarrera || e.getSource() == frm.jTxtBusquedaNomMateria
                || e.getSource() == frm.jTxtNomCarrera || e.getSource() == frm.jTxtNomMateria
                || e.getSource() == frm.jTxtCategoriaProf || e.getSource() == frm.jTxtDedicacion) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_SPACE)) {
                e.consume();
            }
        }
        if (e.getSource() == frm.jTxtCodCarrera || e.getSource() == frm.jTxtCodMateria || e.getSource() == frm.jTxtNumeroDoc
                || e.getSource() == frm.jTxtBusquedaCodCarrera || e.getSource() == frm.jTxtBusquedaCodMateria) {
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
        if (e.getSource() == frm.jTxtBusquedaNomCarrera) {
            String NomCarrera = frm.jTxtBusquedaNomCarrera.getText();
            limpiarTablaCarrera();
            try {
                cargaTablaCarreras(frm.jTableDatosCarrera, 2, NomCarrera);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlIngresoProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == frm.jTxtBusquedaCodCarrera) {
            int CodCarrera = Integer.valueOf(frm.jTxtBusquedaCodCarrera.getText());
            limpiarTablaCarrera();
            try {
                cargaTablaCarreras(frm.jTableDatosCarrera, 3, CodCarrera);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlIngresoProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException e1){
            System.out.println("Debe ingresar un Codigo valido!!");
        }
        }
//////////////////////////        
        if (e.getSource() == frm.jTxtBusquedaNomMateria) {
            String NomMateria = frm.jTxtBusquedaNomMateria.getText();
            limpiarTablaMateria();
            try {
                cargaTablaMaterias(frm.jTableDatosMateria, 2, NomMateria);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlIngresoProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == frm.jTxtBusquedaCodMateria) {
            int CodMateria = Integer.valueOf(frm.jTxtBusquedaCodMateria.getText());
            limpiarTablaMateria();
            try {
                cargaTablaMaterias(frm.jTableDatosMateria, 3, CodMateria);
            } catch (SQLException ex) {
                System.err.println("aqui falla caso 3 KeyRelease BusquedaCodMateria!!!!" + ex);
//                Logger.getLogger(CtrlIngresoProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (NumberFormatException e2){
            System.out.println("Debe ingresar un Codigo valido!!");
        }
        }

    }
}
