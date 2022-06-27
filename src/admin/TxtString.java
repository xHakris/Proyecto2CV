package admin;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import uta.ejcp.pedidos.excepciones.MisExcepciones;

public class TxtString extends JTextField {

    public TxtString() {
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

//        this.addFocusListener(new java.awt.event.FocusAdapter() {
//            @Override
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                jtxtnum1FocusLost(evt);
//            }
//        });
    }

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {
        try {
            validarlet(evt);
            this.requestFocus();
        } catch (MisExcepciones ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

//    private void jtxtnum1FocusLost(java.awt.event.FocusEvent evt) {
//        if (this.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Ingrese el dato.");
//            this.requestFocus();
//        }
//    }

    private void validarlet(java.awt.event.KeyEvent evt) throws MisExcepciones {
        char caracter = evt.getKeyChar();
        if (!Character.isLetter(caracter)) {
            evt.consume();
            throw new MisExcepciones("Ingrese solo Letras.");
        }
    }

    public Integer getTextAsInteger() {
        if (this.getText() == null || this.getText().isEmpty()) {
            this.setText("0");
            return 0;
        }
        return Integer.valueOf(this.getText());
    }
}
