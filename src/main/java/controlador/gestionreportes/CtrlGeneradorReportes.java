package controlador.gestionreportes;

import crud.gestionprofesor.GestionDataCarrera;
import dao.ProfesorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.gestionprofesor.Carrera;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import vistas.reporte.UIGestionSalidaReportes;

/**
 * @author AdeS
 */
public class CtrlGeneradorReportes implements ActionListener, KeyListener {

    private Connection connP;
    private Carrera modCra;
    private GestionDataCarrera crudDCra;
    private UIGestionSalidaReportes frmRep;
    DefaultTableModel modeloC = new DefaultTableModel();

    public CtrlGeneradorReportes() throws IOException {
        connP = ProfesorDAO.getInstance().getProfesorDAO();
    }

    public CtrlGeneradorReportes(UIGestionSalidaReportes frmRepSalida) throws IOException {
        modCra = new Carrera();
        crudDCra = new GestionDataCarrera();
        frmRep = frmRepSalida;

    }

    public CtrlGeneradorReportes(Carrera modCra, GestionDataCarrera crudDCra, UIGestionSalidaReportes frmRepSalida) throws IOException {
        this.modCra = modCra;
        this.crudDCra = crudDCra;
        this.frmRep = frmRep;

    }

    public void printReporteAuxiliares(String jrxmlfile, String salida, Integer codCarrera) {
//        try {
////            Map<String, Object> param = new HashMap();
////            param.put("Param_CodCarrera", codCarrera);
////            JasperReport jr = JasperCompileManager.compileReport(jrxmlfile);
////            JasperPrint jprint = JasperFillManager.fillReport(jr, param);
////
////            JasperExportManager.exportReportToPdfFile(jprint,
////                    "src/main/java/modelo/reportes/" + salida + ".pdf");
//
//            JasperReport reporte = null;
//            String path = "src\\main\\java\\modelo\\reportes";
//            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
//            JasperPrint jprint = JasperFillManager.fillReport(path, null, connP);
//            
//        } catch (Exception e) {
//        }
    }

    public void cargaTabla(JTable tablaCarrera) {
        tablaCarrera.setModel(modeloC);
        modeloC.addColumn("idCarrera");
        modeloC.addColumn("Cod de Carrera");
        modeloC.addColumn("Nom de Carrera");
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

    public void limpiarTablaCarrera() {
        for (int i = 0; i < frmRep.jTableDatosCarrera.getRowCount(); i++) {
            modeloC.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmRep.jBtnSelecCarrera) {
            int fila = frmRep.jTableDatosCarrera.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(frmRep, "Debe Seleccionar una Fila");
            } else {
                try {
                    frmRep.jTxtIdCarrera.setText(String.valueOf(frmRep.jTableDatosCarrera.getValueAt(fila, 0)));
                    frmRep.jTxtCodCarrera.setText(String.valueOf(frmRep.jTableDatosCarrera.getValueAt(fila, 1)));
                    frmRep.jTxtNomCarrera.setText(String.valueOf(frmRep.jTableDatosCarrera.getValueAt(fila, 2)));
                } catch (Exception ex) {
                    System.out.print(ex.toString());
                }
            }
        }
        if (e.getSource() == frmRep.jBtnGeneraReporte) {
//           printReporteAuxiliares(String jrxmlfile, String salida, Integer codCarrera)


          limpiarTablaCarrera();
            try {
                cargaTablaCarreras(frmRep.jTableDatosCarrera, 1, null);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlGeneradorReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getSource() == frmRep.jTxtBusquedaCodCarrera || e.getSource() == frmRep.jTxtBusquedaNomCarrera) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_SPACE)) {
                e.consume();
            }
        }
        if (e.getSource() == frmRep.jTxtCodCarrera) {
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
        if (e.getSource() == frmRep.jTxtBusquedaNomCarrera) {
            String nomCarrera = frmRep.jTxtBusquedaNomCarrera.getText();
            limpiarTablaCarrera();
            try {
                cargaTablaCarreras(frmRep.jTableDatosCarrera, 2, nomCarrera);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlGeneradorReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == frmRep.jTxtBusquedaCodCarrera) {
            int codCarrera = Integer.valueOf(frmRep.jTxtBusquedaCodCarrera.getText());
            limpiarTablaCarrera();
            try {
                cargaTablaCarreras(frmRep.jTableDatosCarrera, 3, codCarrera);
            } catch (SQLException ex) {
//                Logger.getLogger(CtrlGeneradorReportes.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(" fallo caso 3 KeyRelease Metodo cargaTablaCarreras !!!! TextBoc sin datos" + ex);
            }
        }
    }

}
