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
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {
    
    public Principal() {
        initComponents();
        cargarHora();
        this.setLocationRelativeTo(null);
        cargarNombre();
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButton1.setText("Marcar Asistencia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("Horario de la Mañana");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel3.setText(":");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel4.setText(":");

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton2.setText("Reporte Asistencia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
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
                .addComponent(jlbl_Segundo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jlbl_Usuario)
                                .addGap(223, 223, 223)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(jButton1)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_Usuario)
                    .addComponent(jLabel2))
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_Reloj)
                    .addComponent(jlbl_Hora)
                    .addComponent(jLabel3)
                    .addComponent(jlbl_Minuto)
                    .addComponent(jLabel4)
                    .addComponent(jlbl_Segundo))
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controlarAtraso();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbl_Hora;
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
                            jlbl_Hora.setText("0"+hora.getHours());
                        } else{
                            jlbl_Hora.setText(""+hora.getHours());
                        }
                        if (hora.getMinutes() < 10) {
                            jlbl_Minuto.setText("0"+hora.getMinutes());
                        } else{
                            jlbl_Minuto.setText(""+hora.getMinutes());
                        }
                        if (hora.getSeconds() < 10) {
                            jlbl_Segundo.setText("0"+hora.getSeconds());
                        } else{
                            jlbl_Segundo.setText(""+hora.getSeconds());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        return contador;
    }

    private void controlarAtraso() {
//        if (jlbl_Hora <) {
//            
//        }
    }

    private void cargarNombre() {
        try {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "select nombre_user, apellido_user FROM usuarios WHERE estado_user = '1'";
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("nombre_user");
                String ape = rs.getString("apellido_user");
                jlbl_Usuario.setText("Bienvenido, "+nom+" "+ape);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
