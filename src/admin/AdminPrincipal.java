/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import models.InicioSesion;
import models.conexion;

/**
 *
 * @author JC
 */
public class AdminPrincipal extends javax.swing.JFrame {

    DefaultComboBoxModel modeloJornada;
    SpinnerListModel modeloSpinner;

    public AdminPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargaJornada();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo.png")));
    }

    private void registrarDocente() {
        try {
            String usuario_reg, contrasena_reg, nombre_user, apellido_user, estado_user;
            conexion cn = new conexion();
            Connection cc = cn.conectar();
            usuario_reg = jtxtCedula.getText();
            contrasena_reg = jpwdContraena.getText();
            nombre_user = jtxtNombre.getText();
            apellido_user = jtxtApellido.getText();
            estado_user = "0";
            String sql = "INSERT INTO usuarios(usuario_reg,contrasena_reg,nombre_user,apellido_user,estado_user,tipo_user) VALUES(?,?,?,?,?,?)";
            PreparedStatement psd = cc.prepareStatement(sql);
            psd.setString(1, usuario_reg);
            psd.setString(2, contrasena_reg);
            psd.setString(3, nombre_user);
            psd.setString(4, apellido_user);
            psd.setString(5, estado_user);
            psd.setString(6, "U");
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "SE HA REGISTRADO DE MANERA EXITOSA ");
                limpiartextos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El usuario ya existe, o no se puede realizar la operacion, intentelo mas tarde.");
        }
    }

    private void limpiartextos() {
        jtxtCedula.setText("");
        jtxtNombre.setText("");
        jtxtApellido.setText("");
        jpwdContraena.setText("");
    }

    private boolean controlDatosVacios() {

        if (jtxtCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese una cedula");
            jtxtCedula.requestFocus();
            return false;
        } else if (jtxtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese  nombre");
            jtxtNombre.requestFocus();
            return false;
        } else if (jtxtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese apellido");
            jtxtApellido.requestFocus();
            return false;
        } else if (jpwdContraena.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese contraseña");
            jpwdContraena.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private boolean controlTamanoDatos() {
        if (jtxtNombre.getText().length() > 20) {
            JOptionPane.showMessageDialog(null, "El nombre excede los 20 caracteres");
            jtxtNombre.requestFocus();
            return false;
        } else if (jtxtApellido.getText().length() > 20) {
            JOptionPane.showMessageDialog(null, "El apellido excede los 20 caracteres");
            jtxtApellido.requestFocus();
            return false;
        } else if (jpwdContraena.getText().length() > 20) {
            JOptionPane.showMessageDialog(null, "La clave excede los 20 caracteres");
            jpwdContraena.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private boolean validar(String cedula) {
        boolean cedulaCorrecta;
        try {
            if (cedula.length() == 10) {
                // Coeficientes de validación cédula
                // El decimo digito se lo considera dígito verificador
                int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                int verificador = Integer.parseInt(cedula.substring(9, 10));
                int suma = 0;
                int digito;
                for (int i = 0; i < (cedula.length() - 1); i++) {
                    digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                    suma += ((digito % 10) + (digito / 10));
                }

                cedulaCorrecta = ((suma % 10 == 0 && verificador == 0) || (10 - suma % 10 == verificador));
            } else {
                cedulaCorrecta = false;
            }
        } catch (Exception e) {
            cedulaCorrecta = false;
        }
        return cedulaCorrecta;
    }

    private void registro() {
        if (controlDatosVacios()) {
            
            if (controlTamanoDatos()) {
                registrarDocente();
            }
            
        }
    }

    private void cargaJornada() {
        String jornada[] = {"seleccione", "Mañana", "Tarde"};
        this.modeloJornada = new DefaultComboBoxModel();
        for (String i : jornada) {
            modeloJornada.addElement(i);
        }
        jcbxJornada.setModel(modeloJornada);
    }

    private void registrarHorario() {
        try {
            conexion cn = new conexion();
            Connection cc = cn.conectar();
            String tipo = this.modeloJornada.getElementAt(this.jcbxJornada.getSelectedIndex()).toString();
            if (tipo.equals("Mañana")) {
                tipo = "maniana";
            }else{
                tipo = "tarde";
            }
            
            String sql;
            sql = "INSERT INTO horarios(tipo_hor,inicio_hor,fin_hor,usuario_hor) VALUES ("
                    + "'"+tipo+"',"
                    + "'"+this.jspnIni.getValue().toString()+"',"
                    + "'"+this.jspnFin.getValue().toString()+"',"
                    + "'"+this.jtxtCedulaHorario.getText()+"')";
            
            PreparedStatement psd = cc.prepareStatement(sql);
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "SE HA REGISTRO DE MANERA EXITOSA ");
                this.jtxtCedulaHorario.setText("");
                this.jcbxJornada.setSelectedIndex(0);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El usuario no existe, o no se puede realizar la operacion, intentelo mas tarde.");
        }
    }

    private void registroHorario() {
        
            if (this.jcbxJornada.getSelectedIndex() != 0) {
                registrarHorario();
            } else {
                JOptionPane.showMessageDialog(null, "Selecciones una jornada");
            }
        
    }

    private void vistaHorario() {
        if (jcbxJornada.getSelectedIndex() == 1) {
            jlblHoras.setText("07:00 - 13:00");
            cargarSpinner(7,7, jspnIni);
            cargarSpinner(7,7, jspnFin);
        } else if (jcbxJornada.getSelectedIndex() == 2) {
            jlblHoras.setText("14:00 - 20:00");
            cargarSpinner(14,7, jspnIni);
            cargarSpinner(14,7, jspnFin);
        } else {
            jlblHoras.setText("");
        }
    }
    
        private void cargarSpinner(int ini, int fin, JSpinner spn) {
        String[] cantidad = new String[fin];
        Integer x = ini;
        for (int i = 0; i < fin; i++) {
            cantidad[i] = x.toString();
            x += 1;
        }
        modeloSpinner = new SpinnerListModel(cantidad);
        spn.setModel(modeloSpinner);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtCedula = new javax.swing.JTextField();
        jtxtNombre = new admin.TxtString();
        jtxtApellido = new admin.TxtString();
        jpwdContraena = new javax.swing.JPasswordField();
        jbtnRegistrar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbtnAnadir = new javax.swing.JButton();
        jbtnCancelarHorario = new javax.swing.JButton();
        jtxtCedulaHorario = new javax.swing.JTextField();
        jcbxJornada = new javax.swing.JComboBox<>();
        jlblHoras = new javax.swing.JLabel();
        jspnIni = new javax.swing.JSpinner();
        jspnFin = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setForeground(new java.awt.Color(153, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Usuario:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("Contraseña:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Nombre:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Apellido:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jtxtCedula.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jtxtCedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(jtxtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 270, -1));

        jtxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtNombre.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel2.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 270, -1));

        jtxtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtApellido.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel2.add(jtxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 270, -1));

        jpwdContraena.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jpwdContraena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(jpwdContraena, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 270, -1));

        jbtnRegistrar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jbtnRegistrar.setText("Registrar");
        jbtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 120, -1));

        jbtnCancelar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 240, 120, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registrar Docente", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Jornada:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Usuario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 51, -1, -1));

        jbtnAnadir.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jbtnAnadir.setText("Añadir");
        jbtnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAnadirActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 241, 126, -1));

        jbtnCancelarHorario.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jbtnCancelarHorario.setText("Cancelar");
        jbtnCancelarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarHorarioActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCancelarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 241, 126, -1));

        jtxtCedulaHorario.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jtxtCedulaHorario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jtxtCedulaHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 176, -1));

        jcbxJornada.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jcbxJornada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbxJornadaItemStateChanged(evt);
            }
        });
        jPanel1.add(jcbxJornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 176, -1));

        jlblHoras.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(jlblHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 152, 27));

        jspnIni.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(jspnIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 80, -1));

        jspnFin.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel1.add(jspnFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 79, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setText("-");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 10, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Añadir Horario", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("ADMINISTRACION HORARIOS - DOCENTES");

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegistrarActionPerformed
        // TODO add your handling code here:
        registro();
    }//GEN-LAST:event_jbtnRegistrarActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        // TODO add your handling code here:
        limpiartextos();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        InicioSesion i = new InicioSesion();
        this.dispose();
        i.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAnadirActionPerformed
        // TODO add your handling code here:
        registroHorario();
        cargarSpinner(0, 0, jspnFin);
        cargarSpinner(0, 0, jspnIni);
    }//GEN-LAST:event_jbtnAnadirActionPerformed

    private void jbtnCancelarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarHorarioActionPerformed
        // TODO add your handling code here:
        this.jtxtCedulaHorario.setText("");
        this.jcbxJornada.setSelectedIndex(0);
        this.jspnFin.setValue("0");
        this.jspnIni.setValue("0");
    }//GEN-LAST:event_jbtnCancelarHorarioActionPerformed

    private void jcbxJornadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbxJornadaItemStateChanged
        // TODO add your handling code here:
        vistaHorario();
    }//GEN-LAST:event_jcbxJornadaItemStateChanged

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
            java.util.logging.Logger.getLogger(AdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnAnadir;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnCancelarHorario;
    private javax.swing.JButton jbtnRegistrar;
    private javax.swing.JComboBox<String> jcbxJornada;
    private javax.swing.JLabel jlblHoras;
    private javax.swing.JPasswordField jpwdContraena;
    private javax.swing.JSpinner jspnFin;
    private javax.swing.JSpinner jspnIni;
    private admin.TxtString jtxtApellido;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JTextField jtxtCedulaHorario;
    private admin.TxtString jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
