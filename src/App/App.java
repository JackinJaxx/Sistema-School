package App;

import App.client.Controller.ControllerLogin;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Runnable runApplication = () -> new ControllerLogin();
        SwingUtilities.invokeLater(runApplication);
    }
}
