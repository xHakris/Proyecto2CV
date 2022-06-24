
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
        jpsw_Contrasenia = new javax.swing.JPasswordField();
        jbtn_Ver = new javax.swing.JButton();
        jbtn_Tapar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setText("Inicio de Sesion");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setText("Contraseña");

        jtxt_Usuario.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N

        jbtn_Acceder.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jbtn_Acceder.setText("Acceder");
        jbtn_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_AccederActionPerformed(evt);
            }
        });

        jpsw_Contrasenia.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N

        jbtn_Ver.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jbtn_Ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_VerActionPerformed(evt);
            }
        });

        jbtn_Tapar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jbtn_Tapar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_TaparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jtxt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addGap(19, 19, 19)
                        .addComponent(jpsw_Contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtn_Ver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtn_Tapar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jbtn_Acceder, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(185, 185, 185))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(jtxt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpsw_Contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtn_Ver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtn_Tapar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jbtn_Acceder)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_AccederActionPerformed
        if(comprobarDatos()){
            if (comprobarAdmin()==true) {
                this.dispose();
                MenuAdmin ma = new MenuAdmin();
                ma.show();
            }else{
                logearUsuario();
                Principal pp = new Principal();
                pp.activadorBoton();
                pp.show();
                this.dispose();
            }
        }
        
    }//GEN-LAST:event_jbtn_AccederActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtn_Acceder;
    private javax.swing.JButton jbtn_Tapar;
    private javax.swing.JButton jbtn_Ver;
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
    
    private boolean comprobarAdmin() {
        try {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "select tipo_user FROM usuarios WHERE usuario_reg = '"+jtxt_Usuario.getText()+"'";
            PreparedStatement psd = cn.prepareStatement(sql);
            ResultSet rs = psd.executeQuery();
            if (rs.next()) {
                if (rs.getString("tipo_user").equals("A")) {
                    return true;
                }
            }
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
}

