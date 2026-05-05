package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String autor;
    private String isbn;
    private int anyoPublicacion;
    private String genero;
    private double precio;
    private int ejemplaresDisponibles;
    private boolean esBestSeller;

    // Constructor vacío requerido por JPA
    public Libro() {}

    // Constructor sin ID (según tus requisitos)
    public Libro(String titulo, String autor, String isbn, int anyoPublicacion,
                 String genero, double precio, int ejemplaresDisponibles, boolean esBestSeller) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anyoPublicacion = anyoPublicacion;
        this.genero = genero;
        this.precio = precio;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
        this.esBestSeller = esBestSeller;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    // ... (resta de getters y setters omitidos por brevedad, asegúrate de añadirlos todos)

    @Override
    public String toString() {
        return "Libro{id=" + id + ", titulo='" + titulo + "', autor='" + autor + "'}";
    }
}