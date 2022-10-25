package App.client.Views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class ViewLogin extends JFrame {
    private JTextField tNombreUsuario;
    private JLabel lEslogan, lForgotPassword, lButtonSignIn, lButtonLogIn, lUser, lPasswordShow, lImageLogIn;
    private JCheckBox checkRememberPassword;
    private JPanel pDerecha, pIzquierda;
    private JPasswordField tPassword;
    //private JComboBox cbTipoUsuario;
    private Color colorPrincipal, colorSecundario, colorTerciario, colorCuarto, colortransparente;
    private Font fontPrincipal, fontTitulo, fontComentarios;
    private Cursor cursorMano;
    private Border bInferiorNegro;

    public ViewLogin() {
        setTitle("Login");
        createColors();
        createFonts();
        createCursors();
        createBorders();
        createJPanels();
        createJLabels();
        createJCheckBoxes();
        createJTexFields();
        createJPasswordFields();
        //createJComboBoxes();

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    public void createCursors() {
        cursorMano = new Cursor(Cursor.HAND_CURSOR);
    }

    public void createBorders() {
        bInferiorNegro = BorderFactory.createMatteBorder(0, 0, 2, 0, colorCuarto);
    }

    public void createJPanels() {
        pIzquierda = new JPanel();
        pIzquierda.setSize(500, 600);
        pIzquierda.setLocation(0, 0);
        pIzquierda.setBackground(Color.white);
        pIzquierda.setLayout(null);

        pDerecha = new JPanel();
        pDerecha.setSize(500, 600);
        pDerecha.setLocation(500, 0);
        pDerecha.setBackground(Color.white);
        pDerecha.setLayout(null);

        add(pIzquierda);
        add(pDerecha);
    }

    public void createJLabels() {
        lImageLogIn = new JLabel();
        lImageLogIn.setSize(500,500);
        lImageLogIn.setLocation((pIzquierda.getWidth() - lImageLogIn.getWidth())/2,5);
        lImageLogIn.setIcon(new ImageIcon("resources/Images/Login.gif"));
        pIzquierda.add(lImageLogIn);


        lEslogan = new JLabel("USER LOGIN");
        lEslogan.setSize(175, 30);
        lEslogan.setFont(fontTitulo);
        lEslogan.setLocation((pDerecha.getWidth() - lEslogan.getWidth()) / 2, 90); /*Cuando un elemento se quiere colocar en el centro con respecto
                                        ya sea a su panel padre o a la ventana. Para esto se debe hacer un
                                        cálculo que es: (Ancho de panel - Ancho Objeto)/ 2   */
        lEslogan.setForeground(Color.darkGray);
        lEslogan.setHorizontalAlignment(SwingConstants.CENTER);//centra el texto con respecto al size; o de su label
        pDerecha.add(lEslogan);

        lForgotPassword = new JLabel("Forgot Password?");
        lForgotPassword.setSize(140, 20);
        lForgotPassword.setFont(fontPrincipal);
        lForgotPassword.setLocation((pDerecha.getWidth() + lForgotPassword.getWidth()) / 2 - 30, 250);
        lForgotPassword.setForeground(Color.DARK_GRAY);
        lForgotPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lForgotPassword.setCursor(cursorMano);
        pDerecha.add(lForgotPassword);

        lButtonLogIn = new JLabel("e");
        lButtonLogIn.setSize(127, 39);
        lButtonLogIn.setIcon(new ImageIcon("resources/Images/button log in_active.png"));
        lButtonLogIn.setLocation((pDerecha.getWidth() - lButtonLogIn.getWidth()) / 2, 320);
        lButtonLogIn.setCursor(cursorMano);
        pDerecha.add(lButtonLogIn);
        lButtonLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lButtonLogIn.setIcon(new ImageIcon("resources/Images/button log in_hover.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lButtonLogIn.setIcon(new ImageIcon("resources/Images/button log in_click.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lButtonLogIn.setIcon(new ImageIcon("resources/Images/button log in_active.png"));
            }
        });

        lUser = new JLabel();
        lUser.setIcon(new ImageIcon("resources/Images/user.png"));
        lUser.setBounds(65, 150, 24, 24);
        pDerecha.add(lUser);

        lPasswordShow = new JLabel();
        lPasswordShow.setIcon(new ImageIcon("resources/Images/eye.png"));
        lPasswordShow.setBounds(65, 210, 24, 24);
        pDerecha.add(lPasswordShow);
        lPasswordShow.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                lPasswordShow.setIcon(new ImageIcon("resources/Images/hide.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lPasswordShow.setIcon(new ImageIcon("resources/Images/eye.png"));
            }
        });
    }

    public void createJCheckBoxes() {
        checkRememberPassword = new JCheckBox("Remember Password");
        checkRememberPassword.setSize(145, 20);
        checkRememberPassword.setFont(fontPrincipal);
        checkRememberPassword.setLocation((pDerecha.getWidth() - checkRememberPassword.getWidth()) / 2 - 80, 250);
        checkRememberPassword.setOpaque(false);
        checkRememberPassword.setFocusable(false);
        checkRememberPassword.setIcon(new ImageIcon("resources/Images/chechremember default.png"));
        checkRememberPassword.setSelectedIcon(new ImageIcon("resources/Images/checkremember active.png"));
        checkRememberPassword.setHorizontalAlignment(SwingConstants.CENTER);
        checkRememberPassword.setCursor(cursorMano);
        pDerecha.add(checkRememberPassword);
    }

    public void createJTexFields() {
        String placeholder;
        tNombreUsuario = new JTextField("Usuario");
        tNombreUsuario.setForeground(colortransparente);
        tNombreUsuario.setSize(300, 40);
        tNombreUsuario.setLocation((pDerecha.getWidth() - tNombreUsuario.getWidth()) / 2, 140);// (Ancho de panel - Ancho Objeto)/ 2
        tNombreUsuario.setFont(fontPrincipal);
        tNombreUsuario.setBackground(Color.white);
        tNombreUsuario.setBorder(bInferiorNegro);
        tNombreUsuario.setCaretColor(Color.blue);// la linea que parpadea asignar color
        tNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);//colocar el ingreso de texto en el centro
        pDerecha.add(tNombreUsuario);

        tNombreUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tNombreUsuario.setText("");
                tNombreUsuario.setForeground(colorTerciario);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(tNombreUsuario.getText().isEmpty()){
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    tNombreUsuario.setText("Usuario");
                    tNombreUsuario.setForeground(colortransparente);
                }
            }
        });

    }


    public void createJPasswordFields() {
        tPassword = new JPasswordField("Password");
        tPassword.setSize(300, 40);
        tPassword.setLocation((pDerecha.getWidth() - tPassword.getWidth()) / 2, 200);// (Ancho de panel - Ancho Objeto)/ 2
        tPassword.setForeground(Color.DARK_GRAY);
        tPassword.setCaretColor(Color.blue);// la linea que parpadea asignar color
        tPassword.setBorder(bInferiorNegro);
        tPassword.setHorizontalAlignment(SwingConstants.CENTER);//colocar el ingreso de texto en el centro
        pDerecha.add(tPassword);
    }

    /*public void createJComboBoxes(){
        cbTipoUsuario = new JComboBox();
        cbTipoUsuario.addItem("Maestro");
        cbTipoUsuario.addItem("Alumno");
        cbTipoUsuario.addItem("Administrador");
        cbTipoUsuario.setSize(220, 30);
        cbTipoUsuario.setLocation((pDerecha.getWidth() - cbTipoUsuario.getWidth()) / 2, 185);// (Ancho de panel - Ancho Objeto)/ 2
        cbTipoUsuario.setForeground(Color.DARK_GRAY);
        cbTipoUsuario.setBackground(Color.white);
        ((JLabel)cbTipoUsuario.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        /*Para centrar el texto del combobox, primero se debe pedir los objetos que se encuentran dentro del combobox
        para eso se usa.getRenderer() y luego se cast a JLabel para poder acceder al método setHorizontalAlignment
        pDerecha.add(cbTipoUsuario);
    }
     */
    public void createColors() {
        colorPrincipal = new Color(234, 234, 234);
        colorSecundario = new Color(255, 46, 99);
        colorTerciario = new Color(37, 42, 52);
        colorCuarto = new Color(8, 217, 214);
        colortransparente = new Color(220, 220, 224);
    }

    public void createFonts() {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/Fonts/Roboto/Roboto-Regular.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/Fonts/Roboto/Roboto-Black.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/Fonts/Cascadia Code/CascadiaCode.ttf")));

        } catch (IOException | FontFormatException e) {
            System.out.println("Error al cargar la fuente");
        }
        fontPrincipal = new Font("Roboto", Font.BOLD, 12);
        fontTitulo = new Font("Roboto Black", Font.PLAIN, 30);
        fontComentarios = new Font("Cascadia Code", Font.PLAIN, 20);
    }

}
