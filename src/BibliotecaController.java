import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BibliotecaController {
    ArrayList<Libro> listaLibros = new ArrayList<Libro>();

    public BibliotecaController() {
        listaLibros = new ArrayList<>();
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public Libro buscarPorNombre(String nombreLibro) {
        for (Libro libro : listaLibros) {
            if (libro.getNombre().equals(nombreLibro)) {
                return libro;
            }
        }
        return null;  // Si no se encuentra el libro, se devuelve null
    }

    public Libro buscarPorId(int idLibro) {
        ordenarPorId();  // Ordenar la lista por ID antes de la búsqueda binaria
        int indice = busquedaBinaria(idLibro);
        if (indice != -1) {
            return listaLibros.get(indice);
        }
        return null;  // Si no se encuentra el libro, se devuelve null
    }

    private void ordenarPorId() {
        Collections.sort(listaLibros, new Comparator<Libro>() {
            @Override
            public int compare(Libro libro1, Libro libro2) {
                return Integer.compare(libro1.getIdLibro(), libro2.getIdLibro());
            }
        });
    }

    private int busquedaBinaria(int idLibro) {
        int inicio = 0;
        int fin = listaLibros.size() - 1;

        while (inicio <= fin) {

            int medio = inicio + (fin - inicio) / 2;
            Libro libro = listaLibros.get(medio);
            int idMedio = libro.getIdLibro();

            if (idMedio == idLibro) {
                return medio;
            } else if (idMedio < idLibro) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }

        }

        return -1;  // Si no se encuentra el libro, se devuelve -1
    }

    public int calcularTotalPaginas() {
        return calcularTotalPaginasRecursivo(0);
    }

    private int calcularTotalPaginasRecursivo(int index) {
        if (index >= listaLibros.size()) {
            return 0;
        }

        Libro libro = listaLibros.get(index);
        int paginasActuales = libro.getNumeroPaginas();
        int paginasRestantes = calcularTotalPaginasRecursivo(index + 1);

        return paginasActuales + paginasRestantes;
    }

    public boolean eliminarPorId(int idLibro) {
        int indice = buscarIndicePorId(idLibro);
        if (indice != -1) {
            listaLibros.remove(indice);
            return true;
        }
        return false;
    }

    public boolean eliminarPorNombre(String nombreLibro) {
        int indice = buscarIndicePorNombre(nombreLibro);
        if (indice != -1) {
            listaLibros.remove(indice);
            return true;
        }
        return false;
    }

    private int buscarIndicePorId(int idLibro) {
        ordenarPorId();  // Ordenar la lista por ID antes de realizar la búsqueda binaria
        return busquedaBinaria(idLibro);
    }

    private int buscarIndicePorNombre(String nombreLibro) {
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libro = listaLibros.get(i);
            if (libro.getNombre().equals(nombreLibro)) {
                return i;
            }
        }
        return -1;  // Si no se encuentra el libro, se devuelve -1
    }

}
