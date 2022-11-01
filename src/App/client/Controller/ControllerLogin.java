package App.client.Controller;

import App.client.Model.Alumnos;
import App.client.Model.CRUDAlumnos;
import App.client.Model.CRUDMaestros;
import App.client.Model.Maestros;
import App.client.Views.ViewLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControllerLogin {
    private final ViewLogin viewLogin;

    public ControllerLogin() {
        viewLogin = new ViewLogin();
        initEvents();
    }

    public void initEvents() {
        eventsJLabels();
        eventsJTextFields();

    }

    public void validateLogin() {
        //viewLogin.dispose();
        Thread threadQueryAlumnos = new Thread(() -> {
            CRUDAlumnos crudAlumnos = new CRUDAlumnos();
            for (Object objAlumnos : crudAlumnos.read()) {
                Alumnos alumnos = (Alumnos) objAlumnos;
                if (alumnos.getCorreo().equals(viewLogin.gettNombreUsuario().getText()) && alumnos.getPassword().equals(String.valueOf(viewLogin.gettPassword().getPassword()))) {
                    JOptionPane.showMessageDialog(viewLogin, "Bienvenido " + alumnos.getNombre() + " " + alumnos.getApellidoPaterno() + " " + alumnos.getApellidoMaterno());
                    //viewLogin.dispose();
                }
            }
        });
        //viewLogin.dispose();
        Thread threadQueryMaestros = new Thread(() -> {
            CRUDMaestros crudMaestros = new CRUDMaestros();
            for (Object objMaestros : crudMaestros.read()) {
                Maestros maestros = (Maestros) objMaestros;
                if (maestros.getCorreo().equals(viewLogin.gettNombreUsuario().getText()) && maestros.getPassword().equals(String.valueOf(viewLogin.gettPassword().getPassword()))) {
                    JOptionPane.showMessageDialog(viewLogin, "Bienvenido " + maestros.getNombre() + " " + maestros.getApellidoPaterno() + " " + maestros.getApellidoMaterno());
                    //viewLogin.dispose();
                }
            }
        });
        threadQueryAlumnos.start();
        threadQueryMaestros.start();
    }

    public void eventsJLabels() { //events de los jlabels
        viewLogin.getlButtonLogIn().addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewLogin.getlButtonLogIn().setIcon(new ImageIcon("resources/Images/button log in_hover.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                viewLogin.getlButtonLogIn().setIcon(new ImageIcon("resources/Images/button log in_click.png"));
                validateLogin();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                viewLogin.getlButtonLogIn().setIcon(new ImageIcon("resources/Images/button log in_active.png"));
            }
        });

        viewLogin.getlPasswordShow().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (viewLogin.getlPasswordShow().getIcon().toString().equals("resources/Images/hide.png")) {
                    viewLogin.getlPasswordShow().setIcon(new ImageIcon("resources/Images/eye.png"));
                    if (String.valueOf(viewLogin.gettPassword().getPassword()).equals("")) {
                        viewLogin.gettPassword().setText("Password");
                    }
                    viewLogin.gettPassword().setEchoChar('*');
                    viewLogin.gettPassword().setFont(viewLogin.getFontPrincipal());
                } else {
                    viewLogin.getlPasswordShow().setIcon(new ImageIcon("resources/Images/hide.png"));
                    viewLogin.gettPassword().setEchoChar((char) 0);
                    if (String.valueOf(viewLogin.gettPassword().getPassword()).equals("Password")) {
                        viewLogin.gettPassword().setText("");
                    }
                }
            }
        });
    }

    public void eventsJTextFields() {
        viewLogin.gettNombreUsuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewLogin.gettNombreUsuario().setText("");
                viewLogin.gettNombreUsuario().setForeground(viewLogin.getColorTerciario());
            }
        });
        viewLogin.gettNombreUsuario().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (viewLogin.gettNombreUsuario().getText().isEmpty()) {
                    viewLogin.gettNombreUsuario().setText("Usuario");
                    viewLogin.gettNombreUsuario().setForeground(viewLogin.getColortransparente());
                }
            }
        });

        viewLogin.gettPassword().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == viewLogin.gettPassword()) {
                    viewLogin.gettPassword().setText("");
                    viewLogin.gettPassword().setForeground(viewLogin.getColorTerciario());
                }
            }
        });
        viewLogin.gettPassword().addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(viewLogin.gettPassword().getPassword()).equals("")) {
                    viewLogin.gettPassword().setText("Password");
                    viewLogin.gettPassword().setForeground(Color.DARK_GRAY);
                }
            }
        });
    }
}
