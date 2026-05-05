package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import modelo.Libro;

import java.util.List;

public class LibroDAO {
    private EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    public void insertarLibro(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    public void borrarLibro(int id) {
        Libro libro = em.find(Libro.class, id);
        if (libro != null) {
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        }
    }

    public Libro obtenerLibro(int id) {
        return em.find(Libro.class, id);
    }

    public List<Libro> obtenerTodos() {
        return em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
    }

    public List<Libro> obtenerPorGenero(String genero) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.genero = :genero", Libro.class)
                .setParameter("genero", genero).getResultList();
    }

    public List<Libro> obtenerEscasos() {
        return em.createQuery("SELECT l FROM Libro l WHERE l.ejemplaresDisponibles < 3", Libro.class)
                .getResultList();
    }

    public List<Libro> obtenerDesde2000() {
        return em.createQuery("SELECT l FROM Libro l WHERE l.anyoPublicacion >= 2000", Libro.class)
                .getResultList();
    }

    public List<Libro> obtenerPorAutor(String autor) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.autor LIKE :autor", Libro.class)
                .setParameter("autor", "%" + autor + "%").getResultList();
    }

    public List<Libro> obtenerTop5Precio() {
        return em.createQuery("SELECT l FROM Libro l ORDER BY l.precio DESC", Libro.class)
                .setMaxResults(5).getResultList();
    }

    public long contarLibros() {
        return em.createQuery("SELECT COUNT(l) FROM Libro l", Long.class).getSingleResult();
    }

    public double obtenerPrecioMedio() {
        return em.createQuery("SELECT AVG(l.precio) FROM Libro l", Double.class).getSingleResult();
    }

    public Libro obtenerMasAntiguo() {
        return em.createQuery("SELECT l FROM Libro l ORDER BY l.anyoPublicacion ASC", Libro.class)
                .setMaxResults(1).getSingleResult();
    }

    public List<Object[]> contarPorGenero() {
        return em.createQuery("SELECT l.genero, COUNT(l) FROM Libro l GROUP BY l.genero", Object[].class).getResultList();
    }

    public List<Object[]> precioMedioPorGenero() {
        return em.createQuery("SELECT l.genero, AVG(l.precio) FROM Libro l GROUP BY l.genero", Object[].class).getResultList();
    }

    public List<String> generosConMasDe100Ejemplares() {
        return em.createQuery("SELECT l.genero FROM Libro l GROUP BY l.genero HAVING SUM(l.ejemplaresDisponibles) > 100", String.class).getResultList();
    }
}
