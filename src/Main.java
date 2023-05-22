import javax.swing.*;

public class Main {
    //Diego Toscano y Oscar Almeida
    public static void main(String[] args) {

        TallerInterface Interface = new TallerInterface();
        Interface.setBounds(200,400,600,600);
        Interface.setVisible(true);
        Interface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Interface.setContentPane(Interface.JPanelPrincipal);
    }
}