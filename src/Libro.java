public class Libro {
    private String nombre;
    private String editorial;
    private String volumen;
    private int NumeroEdicion;
    private static int contadorLibros = 0;  // Variable estática para contar el número de libros
    private int idLibro;  // ID del libro
    private int numeroPaginas;  // Número de páginas del libro

    public Libro(String nombre,String editorial,String volumen,int NumeroEdicion, int numeroPaginas) {
        this.nombre = nombre;
        this.idLibro = ++contadorLibros;  // Incrementar el contador y asignar el nuevo ID al libro
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.volumen = volumen;
        this.NumeroEdicion = NumeroEdicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getVolumen() {
        return volumen;
    }

    public int getNumeroEdicion() {
        return NumeroEdicion;
    }

    public static int getContadorLibros() {
        return contadorLibros;
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
