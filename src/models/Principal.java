/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class Principal extends javax.swing.JFrame {
    conexion cc = new conexion();
    Connection cn = cc.conectar();
    String usuario = "";

    public Principal() {
        initComponents();
        cargarHora();
        this.setLocationRelativeTo(null);
        cargarNombre();
        cargarTablaAsistencias();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbl_Reloj = new javax.swing.JLabel();
        jlbl_Hora = new javax.swing.JLabel();
        jlbl_Minuto = new javax.swing.JLabel();
        jlbl_Segundo = new javax.swing.JLabel();
        jlbl_Usuario = new javax.swing.JLabel();
        jbtn_registrar = new javax.swing.JButton();
        jlbl_Horario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbl_Reloj.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jlbl_Reloj.setText("Hora actual:");

        jlbl_Hora.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jlbl_Hora.setText("00");

        jlbl_Minuto.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jlbl_Minuto.setText("00");

        jlbl_Segundo.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jlbl_Segundo.setText("00");

        jlbl_Usuario.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jlbl_Usuario.setText("Nombre Apellido");

        jbtn_registrar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jbtn_registrar.setText("Registrar entrada");
        jbtn_registrar.setEnabled(false);
        jbtn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_registrarActionPerformed(evt);
            }
        });

        jlbl_Horario.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jlbl_Horario.setText("Horario de la Mañana");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel3.setText(":");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel4.setText(":");

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton2.setText("Reporte Diario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbl_Usuario)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbl_Reloj)
                                .addGap(28, 28, 28)
                                .addComponent(jlbl_Hora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbl_Minuto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbl_Segundo))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jlbl_Horario))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jbtn_registrar)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jlbl_Horario)
                .addGap(50, 50, 50)
                .addComponent(jlbl_Usuario)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_Reloj)
                    .addComponent(jlbl_Hora)
                    .addComponent(jLabel3)
                    .addComponent(jlbl_Minuto)
                    .addComponent(jLabel4)
                    .addComponent(jlbl_Segundo))
                .addGap(27, 27, 27)
                .addComponent(jbtn_registrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_registrarActionPerformed
        insertarRegistro();
        cargarTablaAsistencias();
        
    }//GEN-LAST:event_jbtn_registrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reporte();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtn_registrar;
    private javax.swing.JLabel jlbl_Hora;
    private javax.swing.JLabel jlbl_Horario;
    private javax.swing.JLabel jlbl_Minuto;
    private javax.swing.JLabel jlbl_Reloj;
    private javax.swing.JLabel jlbl_Segundo;
    private javax.swing.JLabel jlbl_Usuario;
    // End of variables declaration//GEN-END:variables

    private void cargarHora() {
        Thread hilo = new Thread(getHora());
        hilo.start();
    }

    public Runnable getHora() {
        Runnable contador = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Date hora = new Date(System.currentTimeMillis());
                        Thread.sleep(1000);
                        if (hora.getHours() < 10) {
                            jlbl_Hora.setText("0" + hora.getHours());
                        } else {
                            jlbl_Hora.setText("" + hora.getHours());
                        }
                        if (hora.getMinutes() < 10) {
                            jlbl_Minuto.setText("0" + hora.getMinutes());
                        } else {
                            jlbl_Minuto.setText("" + hora.getMinutes());
                        }
                        if (hora.getSeconds() < 10) {
                            jlbl_Segundo.setText("0" + hora.getSeconds());
                        } else {
                            jlbl_Segundo.setText("" + hora.getSeconds());
                        }
                        activadorBoton();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        return contador;
    }

    private void cargarNombre() {
        try {
            String sql = "";
            sql = "select usuario_reg, nombre_user, apellido_user FROM usuarios WHERE estado_user = '1'";
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("nombre_user");
                String ape = rs.getString("apellido_user");
                usuario = rs.getString("usuario_reg");              //GUARDAMOS EL USERNAME DE QUIEN SE CONECTO
                jlbl_Usuario.setText("Bienvenido, " + nom + " " + ape);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void reporte() {
        try {
            String arch = System.getProperty("user.dir") + "/src/reporte/reporteCV.jrxml";

            JasperReport reporte = JasperCompileManager.compileReport(arch);

            JasperPrint print = JasperFillManager.fillReport(reporte, null, cc.conectar());

            JFrame frame = new JFrame();
            frame.getContentPane().add(new MiJRViewer(print));
            frame.pack();
            frame.setResizable(false);
            frame.setSize(900, 350);
            frame.setLocationRelativeTo(null);
            frame.setTitle("Registros");
            frame.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void activadorBoton() {
        int inih = 0;
        int finh = 0;
        
        if (Integer.valueOf(jlbl_Hora.getText()) <= 13) {
            inih = Integer.valueOf(conseguirHorario("inicio","maniana"));  //inicio en el horario
            finh = Integer.valueOf(conseguirHorario("fin","maniana"));     //final en el horario
            jlbl_Horario.setText("Horario de la Mañana");
        } else {
            inih = Integer.valueOf(conseguirHorario("inicio","tarde"));  //inicio en el horario
            finh = Integer.valueOf(conseguirHorario("fin","tarde"));     //final en el horario
            jlbl_Horario.setText("Horario de la Tarde");
        }
        
        int hora = Integer.valueOf(jlbl_Hora.getText());         //hora actual
        int min = Integer.valueOf(jlbl_Minuto.getText());        //minuto actual
        int aux = inih-1;
        int aux2 = finh-1;
        
        if ((hora == aux && min >= 50) || (hora == inih && min <= 15)) {
            jbtn_registrar.setEnabled(true);
            jbtn_registrar.setText("Registrar Entrada");
        } else if ((hora == aux2 && min >= 55) || (hora == finh && min <= 10)) {
            jbtn_registrar.setEnabled(true);
            jbtn_registrar.setText("Registrar Salida");
        } else{
            jbtn_registrar.setEnabled(false);
            jbtn_registrar.setText("No disponible");
        }
        
    }

    private void insertarRegistro() {
        String tipo = "";
        if (Integer.valueOf(jlbl_Hora.getText()) <= 13) {
            tipo = conseguirHorario("tipo","maniana");
        } else {
            tipo = conseguirHorario("tipo","tarde");
        }
        try {
            String sql = "INSERT INTO registros VALUES(?,?,?,?,?,?)";
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.setString(1, usuario);
            psd.setString(2, tipo);
            psd.setString(3, "2022-06-24");
            psd.setString(4, jlbl_Hora.getText());
            psd.setString(5, jlbl_Minuto.getText());
            psd.setString(6, jlbl_Segundo.getText());
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Se ha picado correctamente.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }

    private String conseguirHorario(String tipo, String horario) {
        
        try {
            String sql = "select "+tipo+"_hor FROM horarios WHERE usuario_hor = '"+usuario+"' AND tipo_hor = '"+horario+"'";
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            if (rs.next()) {
                return rs.getString(tipo+"_hor");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return "";
    }

    private void cargarTablaAsistencias() {
        
    }
}
