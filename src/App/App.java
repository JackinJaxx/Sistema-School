package App;

import App.Views.ViewLogin;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Runnable runApplication = new Runnable() {
            @Override
            public void run() {
                ViewLogin login = new ViewLogin();
            }
        };
        SwingUtilities.invokeLater(runApplication);
    }
}
