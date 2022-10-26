package App.services;

import javax.swing.*;
import java.awt.*;

public class ObjGraficosService {
    private static ObjGraficosService service;
    private ObjGraficosService(){
    }
    public static ObjGraficosService getService(){
        if(service == null) service = new ObjGraficosService();
        return service;
    }

    public JPanel getJPanel(int x, int y, int width, int height){
        JPanel jPanel = new JPanel();
        jPanel.setSize(width, height);
        jPanel.setLocation(x, y);
        jPanel.setLayout(null);
        return jPanel;
    }

    public JLabel getJLabel(String texto, int x, int y, int width, int height, String file){
        JLabel jLabel = new JLabel(texto);
        jLabel.setSize(width, height);
        jLabel.setLocation(x, y);
        jLabel.setIcon(new ImageIcon(file));
        return jLabel;
    }
    public JCheckBox getJCheckBox(String texto, int x, int y, int width, int height, String file){
        JCheckBox jCheckBox = new JCheckBox(texto);
        jCheckBox.setOpaque(false);
        jCheckBox.setFocusable(false);
        jCheckBox.setSize(width, height);
        jCheckBox.setLocation(x, y);
        jCheckBox.setIcon(new ImageIcon(file));
        jCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        return jCheckBox;
    }

    public JTextField getJTextField(String texto, int x, int y, int width, int height){
        JTextField jTextField = new JTextField(texto);
        jTextField.setSize(width, height);
        jTextField.setLocation(x, y);
        jTextField.setBackground(Color.white);
        jTextField.setHorizontalAlignment(SwingConstants.CENTER);
        jTextField.setCaretColor(Color.blue);
        return jTextField;
    }

    public JPasswordField getJPasswordField(String texto, int x, int y, int width, int height){
        JPasswordField jPasswordField = new JPasswordField(texto);
        jPasswordField.setSize(width, height);
        jPasswordField.setLocation(x, y);
        jPasswordField.setBackground(Color.white);
        jPasswordField.setCaretColor(Color.blue);
        jPasswordField.setEchoChar('*');
        jPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
        return jPasswordField;
    }
}
