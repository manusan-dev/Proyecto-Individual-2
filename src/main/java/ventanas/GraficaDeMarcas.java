package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GraficaDeMarcas extends javax.swing.JFrame {

    String user;
    int[] vector_marcas_cantidad = new int[11];
    String[] vector_marcas_nombre = new String[11];
    int Acer, Alienware, Apple, HP, Asus, Lenovo, Dell, Brother, Samsung, Xiaomi;

    public GraficaDeMarcas() {
        initComponents();
        user = Login.user;
        setSize(550, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Técnico - Sesión de " + user);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
                    "select marca,  count(marca) as Marcas from equipos group by marca");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;

                do {
                    vector_marcas_nombre[posicion] = rs.getString(1);
                    vector_marcas_cantidad[posicion] = rs.getInt(2);

                    if (vector_marcas_nombre[posicion].equalsIgnoreCase("Acer")) {
                        Acer = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Alienware")) {
                        Alienware = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Apple")) {
                        Apple = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("HP")) {
                        HP = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Asus")) {
                        Asus = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Lenovo")) {
                        Lenovo = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Brother")) {
                        Brother = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Samsung")) {
                        Samsung = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Dell")) {
                        Dell = vector_marcas_cantidad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Xiaomi")) {
                        Xiaomi = vector_marcas_cantidad[posicion];
                    }
                    posicion++;
                } while (rs.next());
            }

        } catch (SQLException e) {
            System.err.println("Error en la consulta " + e);
            JOptionPane.showMessageDialog(null, "Error al consultar datos. Contacte al Administrador.");
        }
        repaint();
    }

    //int Acer, , , , , , , , , ;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gráfica de Marcas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel_footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_footer.setText("Desarrollado por Manuel Sánchez ®");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GraficaDeMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaDeMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaDeMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaDeMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaDeMarcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int total_marcas = Acer + Alienware + Apple + HP + Asus + Lenovo + Dell + Brother + Samsung + Xiaomi;

        int grados_acer = Acer * 360 / total_marcas;
        int grados_alienware = Alienware * 360 / total_marcas;
        int grados_apple = Apple * 360 / total_marcas;
        int grados_hp = HP * 360 / total_marcas;
        int grados_asus = Asus * 360 / total_marcas;
        int grados_lenovo = Lenovo * 360 / total_marcas;
        int grados_dell = Dell * 360 / total_marcas;
        int grados_brother = Brother * 360 / total_marcas;
        int grados_samsung = Samsung * 360 / total_marcas;
        int grados_xiaomi = Xiaomi * 360 / total_marcas;

        //marca Acer - color morado
        g.setColor(new Color(175, 122, 197));
        g.fillArc(25, 100, 270, 270, 0, grados_acer);
        g.fillRect(310, 120, 20, 20);
        g.drawString(Acer + " de Acer", 340, 135);

        //marca Alienware - color verde
        g.setColor(new Color(0, 255, 0));
        g.fillArc(25, 100, 270, 270, grados_acer, grados_alienware);
        g.fillRect(310, 150, 20, 20);
        g.drawString(Alienware + " de Alienware", 340, 165);

        //marca Apple - color verde agua
        g.setColor(new Color(0, 255, 255));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware, grados_apple);
        g.fillRect(310, 180, 20, 20);
        g.drawString(Apple + " de Apple", 340, 195);

        //marca HP - color azul
        g.setColor(new Color(55, 0, 255));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple, grados_hp);
        g.fillRect(310, 210, 20, 20);
        g.drawString(HP + " de HP", 340, 225);

        //marca Asus - color blanco
        g.setColor(new Color(255, 255, 255));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_hp, grados_asus);
        g.fillRect(310, 240, 20, 20);
        g.drawString(Asus + " de Asus", 340, 255);

        //marca Lenovo - color amarillo
        g.setColor(new Color(247, 220, 111));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_hp + grados_asus, grados_lenovo);
        g.fillRect(310, 270, 20, 20);
        g.drawString(Lenovo + " de Lenovo", 340, 285);

        //marca Dell - color azul marino
        g.setColor(new Color(21, 42, 160));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_hp + grados_asus + grados_lenovo, grados_dell);
        g.fillRect(310, 300, 20, 20);
        g.drawString(Dell + " de Dell", 340, 315);

        //marca Brother - color azul naranja
        g.setColor(new Color(215, 96, 0));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_hp + grados_asus + grados_lenovo + grados_dell, grados_brother);
        g.fillRect(310, 330, 20, 20);
        g.drawString(Brother + " de Brother", 340, 345);

        //marca samsung - color rosa
        g.setColor(new Color(215, 96, 140));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_hp + grados_asus + grados_lenovo + grados_dell + grados_brother, grados_samsung);
        g.fillRect(430, 120, 20, 20);
        g.drawString(Samsung + " de Samsung", 460, 135);

        //marca xiaomi - color amarillo canario
        g.setColor(new Color(215, 196, 25));
        g.fillArc(25, 100, 270, 270, grados_acer + grados_alienware + grados_apple + grados_hp + grados_asus + grados_lenovo + grados_dell + grados_brother + grados_samsung, grados_xiaomi);
        g.fillRect(430, 150, 20, 20);
        g.drawString(Xiaomi + " de Xiaomi", 460, 165);
    }
}
