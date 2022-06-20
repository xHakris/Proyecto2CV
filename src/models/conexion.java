
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexion {
    Connection connect = null;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //connect = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10499856","sql10499856","jyZKd7Q9hq");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/sql10499856","root","");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error..."+ex);
        }
        return connect;
    }
}
