package App;

import App.client.Views.ViewLogin;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Runnable runApplication = () -> new ViewLogin();
        SwingUtilities.invokeLater(runApplication);
    }
}
