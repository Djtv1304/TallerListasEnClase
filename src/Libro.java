public class Libro {
    private String nombre;
    private static int contadorLibros = 0;  // Variable estática para contar el número de libros
    private int idLibro;  // ID del libro
    private int numeroPaginas;  // Número de páginas del libro

    public Libro(String nombre, int numeroPaginas) {
        this.nombre = nombre;
        this.idLibro = ++contadorLibros;  // Incrementar el contador y asignar el nuevo ID al libro
        this.numeroPaginas = numeroPaginas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
