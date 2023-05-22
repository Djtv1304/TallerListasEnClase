import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TallerInterface {

    private JTabbedPane tabbedPane1;
    private JPanel JPanelPrincipal;
    private JButton agregarLibroButton;
    private JTextField textFieldNombreLibro;
    private JTextField textFieldNumPag;
    private JButton quemarLibrosButton;
    private JTabbedPane tabbedPane2;
    private JButton eliminarButton;
    private JTextField textFieldEliminarPorID;
    private JTextField textFieldEliminarPorNombre;
    private JTabbedPane tabbedPane3;
    private JTextField textFieldBuscarPorNombre;
    private JTextField textFieldBuscarPorID;
    private JButton buscarLibroButton;
    private JTextArea textArea1;
    private JButton calcularElTotalDeButton;
    private BibliotecaController Biblioteca = new BibliotecaController();
    public TallerInterface() {

        quemarLibrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Libro L1 = new Libro("Primer libro",10);
                Libro L2 = new Libro("Segundo libro",20);
                Libro L3 = new Libro("Tercer libro",40);

                Biblioteca.agregarLibro(L1);
                Biblioteca.agregarLibro(L2);
                Biblioteca.agregarLibro(L3);

            }
        });

        agregarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Libro L1 = new Libro(textFieldNombreLibro.getText(), Integer.parseInt(textFieldNumPag.getText()));
                Biblioteca.agregarLibro(L1);
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textFieldEliminarPorNombre.getText().equals("")) {
                    boolean resultado = Biblioteca.eliminarPorNombre(textFieldEliminarPorNombre.getText());
                    if (resultado) {
                        JOptionPane.showMessageDialog(null,"Eliminado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null,"Ingrese un nombre valido");
                    }
                } else {
                    boolean resultado = Biblioteca.eliminarPorId(Integer.parseInt(textFieldEliminarPorID.getText()));
                    if (resultado) {
                        JOptionPane.showMessageDialog(null,"Eliminado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null,"Ingrese un nombre valido");
                    }
                }
            }
        });

        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!textFieldBuscarPorNombre.getText().equals("")) {
                    Libro LibroEncontrado = Biblioteca.buscarPorNombre(textFieldBuscarPorNombre.getText());
                    if (LibroEncontrado != null) {
                        JOptionPane.showMessageDialog(null,"Encontrado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null,"Ingrese un nombre valido");
                    }
                } else {
                    Libro LibroEncontrado = Biblioteca.buscarPorId(Integer.parseInt(textFieldBuscarPorID.getText()));
                    if (LibroEncontrado != null) {
                        JOptionPane.showMessageDialog(null,"Encontrado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null,"Ingrese un nombre valido");
                    }
                }

            }
        });

        calcularElTotalDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!Biblioteca.getListaLibros().isEmpty()) {
                    int totalDePaginas = Biblioteca.calcularTotalPaginas();
                    textArea1.setText("El total de paginas en la bibliteca son: "+totalDePaginas);
                }
            }
        });
    }
}
