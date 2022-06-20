
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InicioSesion extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();

    public InicioSesion() {
        initComponents();
        jbtn_Tapar.setVisible(false);
        this.setLocationRelativeTo(null);
        unlogUsuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxt_Usuario = new javax.swing.JTextField();
        jbtn_Acceder = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jlbl_Aqui = new javax.swing.JLabel();
        jbtn_AccesoBiometrico = new javax.swing.JButton();
        jpsw_Contrasenia = new javax.swing.JPasswordField();
        jbtn_Ver = new javax.swing.JButton();
        jbtn_Tapar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setText("Inicio de Sesion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setText("Usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 121, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 177, -1, -1));

        jtxt_Usuario.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jPanel1.add(jtxt_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 118, 300, -1));

        jbtn_Acceder.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jbtn_Acceder.setText("Acceder");
        jbtn_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_AccederActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel4.setText("No tienes cuenta? Crea una");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        jlbl_Aqui.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jlbl_Aqui.setForeground(new java.awt.Color(51, 102, 255));
        jlbl_Aqui.setText("aquí");
        jlbl_Aqui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbl_AquiMouseClicked(evt);
            }
        });
        jPanel1.add(jlbl_Aqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, -1));

        jbtn_AccesoBiometrico.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtn_AccesoBiometrico.setText("Acceso Biometrico");
        jbtn_AccesoBiometrico.setEnabled(false);
        jPanel1.add(jbtn_AccesoBiometrico, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, 40));

        jpsw_Contrasenia.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jPanel1.add(jpsw_Contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 300, -1));

        jbtn_Ver.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jbtn_Ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_VerActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn_Ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 40, 40));

        jbtn_Tapar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jbtn_Tapar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_TaparActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn_Tapar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_AccederActionPerformed
        if(comprobarDatos()){
            logearUsuario();
            Principal pp = new Principal();
            pp.show();
            this.dispose();
        }
    }//GEN-LAST:event_jbtn_AccederActionPerformed

    private void jlbl_AquiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbl_AquiMouseClicked
        CrearCuenta cc = new CrearCuenta();
        cc.show();
        this.dispose();
    }//GEN-LAST:event_jlbl_AquiMouseClicked

    private void jbtn_VerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_VerActionPerformed
        jpsw_Contrasenia.setEchoChar((char) 0);
        jbtn_Ver.setVisible(false);
        jbtn_Tapar.setVisible(true);
        jpsw_Contrasenia.requestFocus();
    }//GEN-LAST:event_jbtn_VerActionPerformed

    private void jbtn_TaparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_TaparActionPerformed
        jpsw_Contrasenia.setEchoChar(('*'));
        jbtn_Tapar.setVisible(false);
        jbtn_Ver.setVisible(true);
        jpsw_Contrasenia.requestFocus();
    }//GEN-LAST:event_jbtn_TaparActionPerformed

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtn_Acceder;
    private javax.swing.JButton jbtn_AccesoBiometrico;
    private javax.swing.JButton jbtn_Tapar;
    private javax.swing.JButton jbtn_Ver;
    private javax.swing.JLabel jlbl_Aqui;
    private javax.swing.JPasswordField jpsw_Contrasenia;
    private javax.swing.JTextField jtxt_Usuario;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        try {
            String[] titulos = {"Usuario", "Nombre", "apellido"};
            String[] registros = new String[3];
            modelo = new DefaultTableModel(null, titulos);
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "select * from usuarios";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {

                registros[0] = rs.getString("usuario_reg");
                registros[1] = rs.getString("nombre_user");
                registros[2] = rs.getString("apellido_user");
                modelo.addRow(registros);
            }
            //jTable1.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private boolean comprobarDatos() {
        if (jtxt_Usuario.getText().isEmpty() || jtxt_Usuario.getText() == "") {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre de usuario");
            jtxt_Usuario.requestFocus(); //y le damos focus
        } else if (jpsw_Contrasenia.getText().isEmpty() || jpsw_Contrasenia.getText() == "") { //Comprobamos que el usuario ingreso la pass
            JOptionPane.showMessageDialog(null, "Ingrese la contraseña");
            jpsw_Contrasenia.requestFocus(); //sino le damos focus
        } else {
            //String nuevoPass = hash.shal(jpsw_Pass.getText()); //encriptamos la password
            String nuevoPass =(jpsw_Contrasenia.getText());
            try {
                conexion cc = new conexion();
                Connection cn = cc.conectar();
                String sql = "";
                sql = "select contrasena_reg FROM usuarios WHERE usuario_reg = ?";
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1, jtxt_Usuario.getText());
                ResultSet rs = psd.executeQuery();
                if (rs.next()) {
                    if (nuevoPass.equals(rs.getString("contrasena_reg"))) {
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario incorrecto");
                }
                return false;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
                return false;
            }

        }
        return false;
    }

    private void unlogUsuario() {
        try {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "UPDATE usuarios SET estado_user = '0' WHERE estado_user = '1'";
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void logearUsuario() {
        try {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "UPDATE usuarios SET estado_user = '1' WHERE usuario_reg = '"+jtxt_Usuario.getText()+"'";
            PreparedStatement psd = cn.prepareStatement(sql);
            psd.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}

