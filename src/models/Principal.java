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
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class Principal extends javax.swing.JFrame {
    conexion cc = new conexion();
    Connection cn = cc.conectar();
    String usuario = "";
    private DefaultTableModel tablaRegistros,tablaHorarios;

    public Principal() {
        initComponents();
        cargarHora();
        this.setLocationRelativeTo(null);
        cargarNombre();
        String horarios[] = {"Usuario","Nombre","Hora Inicio Jornada","Hora Fin Jornada","Tipo Jornada"};
        String registros[] = {"Usuario","Nombre","Hora del Registro","Fecha","Tipo Registro"};
        tablaRegistros = new DefaultTableModel(null, registros);
        tablaHorarios = new DefaultTableModel(null, horarios);
        jtbl_Registros.setModel(tablaRegistros);
        jtbl_Horarios.setModel(tablaHorarios);
        cargarTablaHorario();
        cargarTablaRegistro();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Horarios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_Registros = new javax.swing.JTable();

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
        jlbl_Horario.setText("horario de la Mañana");

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

        jLabel1.setText("Bienvenido al");

        jtbl_Horarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtbl_Horarios);

        jtbl_Registros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtbl_Registros);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jlbl_Horario))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jlbl_Usuario))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtn_registrar)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlbl_Reloj)
                                        .addGap(28, 28, 28)
                                        .addComponent(jlbl_Hora)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbl_Minuto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbl_Segundo)))
                        .addGap(0, 104, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_Horario)
                    .addComponent(jLabel1))
                .addGap(49, 49, 49)
                .addComponent(jlbl_Usuario)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_Reloj)
                    .addComponent(jlbl_Hora)
                    .addComponent(jLabel3)
                    .addComponent(jlbl_Minuto)
                    .addComponent(jLabel4)
                    .addComponent(jlbl_Segundo))
                .addGap(18, 18, 18)
                .addComponent(jbtn_registrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtn_registrar;
    private javax.swing.JLabel jlbl_Hora;
    private javax.swing.JLabel jlbl_Horario;
    private javax.swing.JLabel jlbl_Minuto;
    private javax.swing.JLabel jlbl_Reloj;
    private javax.swing.JLabel jlbl_Segundo;
    private javax.swing.JLabel jlbl_Usuario;
    private javax.swing.JTable jtbl_Horarios;
    private javax.swing.JTable jtbl_Registros;
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

    private void cargarTablaHorario() {
        String nombre, apellido, horaI, horaF, tipo;
        try{
            String sql = "SELECT a.nombre_user, a.apellido_user, b.inicio_hor, b.fin_hor, b.tipo_hor FROM usuarios as a, horarios as b WHERE a.usuario_reg='"+usuario+"' ";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                nombre = rs.getString("nombre_user");
                apellido = rs.getString("apellido_user");
                horaI = rs.getString("inicio_hor");
                horaF = rs.getString("fin_hor");
                tipo = rs.getString("tipo_hor");
                
                String dato[] = new String[5];
                
                dato[0] = usuario;
                dato[1] = nombre+" "+apellido;
                dato[2] = horaI+":00";
                dato[3] = horaF+":00";
                if (tipo.equals("maniana")) {
                    dato[4] = "Mañana";
                } else if(tipo.equals("tarde")){
                    dato[4] = "Tarde";
                }
                tablaHorarios.addRow(dato);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    private void cargarTablaRegistro() {
        String nombre, apellido, hora, min, seg, fecha, tipo;
        try{
            String sql = "SELECT a.nombre_user, a.apellido_user, b.hora_reg, b.minuto_reg, b.segundo_reg, b.fecha_reg, b.tipo_reg FROM usuarios as a, registros as b WHERE a.usuario_reg='"+usuario+"'";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                nombre = rs.getString("nombre_user");
                apellido = rs.getString("apellido_user");
                hora = rs.getString("hora_reg");
                min = rs.getString("minuto_reg");
                seg = rs.getString("segundo_reg");
                fecha = rs.getString("fecha_reg");
                tipo = rs.getString("tipo_reg");
                
                
                String dato[] = new String[6];
                
                dato[0] = usuario;
                dato[1] = nombre+" "+apellido;
                dato[2] = hora+":"+min+":"+seg;
                dato[3] = fecha;
                if (tipo.equals("maniana")) {
                    dato[4] = "Entrada";
                } else if(tipo.equals("tarde")){
                    dato[4] = "Salida";
                }
                tablaRegistros.addRow(dato);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
