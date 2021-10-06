package vistas.gestionusuario;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author AdeS
 */
public class UIGestionUDirector extends javax.swing.JFrame {

    /**
     * Creates new form UIGestionUDirector
     */
    public UIGestionUDirector() {
        initComponents();
        setTitle("SISTEMA GESTION DE DIRECCION DE DEPARTAMENTO");
        setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuNuevoUsuarioDir = new javax.swing.JMenuItem();
        jMenuModificaUsuarioDir = new javax.swing.JMenuItem();
        jMenuBuscar = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBuscarUsuarioDir = new javax.swing.JMenuItem();
        jMenuBuscarUsuarioAdtvo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setName(""); // NOI18N

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        jMenu1.setText("Usuarios");

        jMenuNuevoUsuarioDir.setText("Nuevo Usuario Director");
        jMenuNuevoUsuarioDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNuevoUsuarioDirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuNuevoUsuarioDir);

        jMenuModificaUsuarioDir.setText("Modificar Usuario Director");
        jMenuModificaUsuarioDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuModificaUsuarioDirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuModificaUsuarioDir);

        jMenuBar1.add(jMenu1);

        jMenuBuscar.setText("Bitacora");

        jMenu3.setText("Buscar");

        jMenuBuscarUsuarioDir.setText("Usuario Director");
        jMenu3.add(jMenuBuscarUsuarioDir);

        jMenuBuscarUsuarioAdtvo.setText("Usuario Administrativo");
        jMenu3.add(jMenuBuscarUsuarioAdtvo);

        jMenuBuscar.add(jMenu3);

        jMenuBar1.add(jMenuBuscar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuNuevoUsuarioDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNuevoUsuarioDirActionPerformed
        UiNuevoUsuarioDir ventanaNuevoUsuario;
        try {
            ventanaNuevoUsuario = new UiNuevoUsuarioDir();

            ventanaNuevoUsuario.setVisible(true);
            jDesktopPane1.add(ventanaNuevoUsuario);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UIGestionUDirector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UIGestionUDirector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuNuevoUsuarioDirActionPerformed

    private void jMenuModificaUsuarioDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuModificaUsuarioDirActionPerformed
        UIModificaUsuario ventanaModificaUsuario;
        try {
            ventanaModificaUsuario = new UIModificaUsuario();
            
            ventanaModificaUsuario.setVisible(true);
            jDesktopPane1.add(ventanaModificaUsuario);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UIGestionUDirector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UIGestionUDirector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuModificaUsuarioDirActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu jMenuBuscar;
    public javax.swing.JMenuItem jMenuBuscarUsuarioAdtvo;
    public javax.swing.JMenuItem jMenuBuscarUsuarioDir;
    public javax.swing.JMenuItem jMenuModificaUsuarioDir;
    public javax.swing.JMenuItem jMenuNuevoUsuarioDir;
    // End of variables declaration//GEN-END:variables
}
