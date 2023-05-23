import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TallerInterface extends JFrame {

    private JTabbedPane tabbedPane1;
    public JPanel JPanelPrincipal;
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

                Libro L1 = new Libro("Primer libro","Primera Editorial","Primer Volumen",1,10);
                Libro L2 = new Libro("Segundo libro","Segunda Editorial","Segundo Volumen",2,20);
                Libro L3 = new Libro("Tercer libro","Tercera Editorial","Tercer Volumen",3,40);

                Biblioteca.agregarLibro(L1);
                Biblioteca.agregarLibro(L2);
                Biblioteca.agregarLibro(L3);

                JOptionPane.showMessageDialog(null,"Datos quemados correctamente");

            }
        });

        agregarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Libro L1 = new Libro(textFieldNombreLibro.getText(),"Editorial Ingresada","Volumen Ingresado",5, Integer.parseInt(textFieldNumPag.getText()));
                boolean status = Biblioteca.agregarLibro(L1);
                if (status) {
                    JOptionPane.showMessageDialog(null,"Libro agregado correctamente");
                }

            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textFieldEliminarPorNombre.getText().equals("")) {
                    boolean resultado = Biblioteca.eliminarPorNombre(textFieldEliminarPorNombre.getText());
                    if (resultado) {
                        JOptionPane.showMessageDialog(null,"Libro eliminado correctamente\n" +
                                "Recuerde calcular nuevamente el numero total de paginas");
                    } else {
                        JOptionPane.showMessageDialog(null,"Ingrese un nombre valido");
                    }
                    textFieldEliminarPorNombre.setText("");
                    textFieldEliminarPorID.setText("");
                } else {
                    boolean resultado = Biblioteca.eliminarPorId(Integer.parseInt(textFieldEliminarPorID.getText()));
                    if (resultado) {
                        JOptionPane.showMessageDialog(null,"Libro eliminado correctamente\n" +
                                "Recuerde calcular nuevamente el numero total de paginas");
                    } else {
                        JOptionPane.showMessageDialog(null,"Ingrese un ID valido");
                    }
                    textFieldEliminarPorID.setText("");
                    textFieldEliminarPorNombre.setText("");
                }
            }
        });

        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!textFieldBuscarPorNombre.getText().equals("")) {
                    Libro LibroEncontrado = Biblioteca.buscarPorNombre(textFieldBuscarPorNombre.getText());
                    if (LibroEncontrado != null) {
                        JOptionPane.showMessageDialog(null,"Nombre del libro: " + LibroEncontrado.getNombre() + "\n"+
                        "Editorial del libro: " + LibroEncontrado.getEditorial() + "\n"+
                        "Volumen del libro: " + LibroEncontrado.getVolumen() + "\n"+
                        "Numero de Edicion: " + LibroEncontrado.getNumeroEdicion() + "\n"+
                        "ID Libro: " + LibroEncontrado.getIdLibro() + "\n"+
                        "Numero de paginas: " + LibroEncontrado.getNumeroPaginas() + "\n");
                    } else {
                        JOptionPane.showMessageDialog(null,"Ingrese un nombre valido");
                    }
                    textFieldBuscarPorNombre.setText("");
                    textFieldBuscarPorID.setText("");
                } else {
                    Libro LibroEncontrado = Biblioteca.buscarPorId(Integer.parseInt(textFieldBuscarPorID.getText()));
                    if (LibroEncontrado != null) {
                        JOptionPane.showMessageDialog(null,"Nombre del libro: " + LibroEncontrado.getNombre() + "\n"+
                                "Editorial del libro: " + LibroEncontrado.getEditorial() + "\n"+
                                "Volumen del libro: " + LibroEncontrado.getVolumen() + "\n"+
                                "Numero de Edicion: " + LibroEncontrado.getNumeroEdicion() + "\n"+
                                "ID Libro: " + LibroEncontrado.getIdLibro() + "\n"+
                                "Numero de paginas: " + LibroEncontrado.getNumeroPaginas()+"\n");
                    } else {
                        JOptionPane.showMessageDialog(null,"Ingrese un ID valido");
                    }
                    textFieldBuscarPorNombre.setText("");
                    textFieldBuscarPorID.setText("");
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
