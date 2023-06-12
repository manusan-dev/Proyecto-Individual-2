package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class GestionarEquipos extends javax.swing.JFrame {

    String user;
    public static int IDequipo_update;
    DefaultTableModel model = new DefaultTableModel();

    public GestionarEquipos() {
        initComponents();
        user = Login.user;
        setSize(630, 380);
        setTitle("Gestor de Datos - Sesión de " + user);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon fondoPantalla = new ImageIcon("src/main/java/images/wallpaper.jpg");
        Icon icono = new ImageIcon(fondoPantalla.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src/main/java/images/icono.png");
        setIconImage(miIcono);

        try {

            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_equipo, tipo_equipo, marca, status from equipos");
            ResultSet rs = pst.executeQuery();

            jTable_equipos = new JTable(model);
            jScrollPane_equipos.setViewportView(jTable_equipos);

            model.addColumn(" ");
            model.addColumn("Tipo de equipo");
            model.addColumn("Marca del equipo");
            model.addColumn("Estado");

            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.print("Error en el llenado de la tabla clientes " + e);
        }

        ObtenerDatosTabla();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane_equipos = new javax.swing.JScrollPane();
        jTable_equipos = new javax.swing.JTable();
        jLabel_footer = new javax.swing.JLabel();
        cmb_status = new javax.swing.JComboBox<>();
        jButton_mostrar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Equipos registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jScrollPane_equipos.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane_equipos.setForeground(new java.awt.Color(0, 0, 0));

        jTable_equipos.setBackground(new java.awt.Color(255, 255, 255));
        jTable_equipos.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jTable_equipos.setForeground(new java.awt.Color(0, 0, 0));
        jTable_equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_equipos.setIntercellSpacing(new java.awt.Dimension(1, 1));
        jTable_equipos.setMinimumSize(new java.awt.Dimension(60, 64));
        jScrollPane_equipos.setViewportView(jTable_equipos);

        getContentPane().add(jScrollPane_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        jLabel_footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_footer.setText("Desarrollado por Manuel Sánchez ®");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, -1, -1));

        cmb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo Ingreso", "No reparado", "En revisión", "Reparado", "Entregado" }));
        getContentPane().add(cmb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 130, -1));

        jButton_mostrar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_mostrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_mostrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_mostrar.setText("Mostrar");
        jButton_mostrar.setBorder(null);
        jButton_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_mostrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_mostrarActionPerformed

        String seleccion = cmb_status.getSelectedItem().toString(), query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst;

            if (seleccion.equals("Todos")) {
                query = "select id_equipo, tipo_equipo, marca, status from equipos";
                pst = cn.prepareStatement(query);
            } else {
                query = "select id_equipo, tipo_equipo, marca, status from equipos where status =?";
                pst = cn.prepareStatement(query);
                pst.setString(1, seleccion);
            }

            ResultSet rs = pst.executeQuery();

            jTable_equipos = new JTable(model);
            jScrollPane_equipos.setViewportView(jTable_equipos);

            model.addColumn("ID equipo");
            model.addColumn("Tipo");
            model.addColumn("Marca del equipo");
            model.addColumn("Estado");

            while ((rs.next())) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al recuperar los registros de equipos " + e);
        }

        ObtenerDatosTabla();

    }//GEN-LAST:event_jButton_mostrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_status;
    private javax.swing.JButton jButton_mostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JScrollPane jScrollPane_equipos;
    private javax.swing.JTable jTable_equipos;
    // End of variables declaration//GEN-END:variables

    public void ObtenerDatosTabla() {
        jTable_equipos.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int fila_point = jTable_equipos.rowAtPoint(e.getPoint());
                    int columna_point = 0;

                    if (fila_point > -1) {
                        IDequipo_update = (int) model.getValueAt(fila_point, columna_point);
                        new InformacionEquipoTecnico().setVisible(true);
                    }

                }
            }
        });
    }
}
