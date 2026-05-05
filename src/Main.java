import DAO.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Libro;
import java.util.List;
import java.util.Arrays;

void main() {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:biblioteca.odb");
    EntityManager em = emf.createEntityManager();
    LibroDAO dao = new LibroDAO(em);


    System.out.println("--- 1. Todos los libros");
    dao.obtenerTodos().forEach(System.out::println);

    System.out.println("\n2. Libros de género 'Novela'");
    dao.obtenerPorGenero("Novela").forEach(System.out::println);

    System.out.println("\n3. Libros con menos de 3 ejemplares");
    dao.obtenerEscasos().forEach(System.out::println);

    System.out.println("\n4. Libros publicados a partir del 2000");
    dao.obtenerDesde2000().forEach(System.out::println);

    System.out.println("\n5. Libros de autor que contiene 'King'");
    dao.obtenerPorAutor("King").forEach(System.out::println);

    System.out.println("\n6. Top 5 libros más caros");
    dao.obtenerTop5Precio().forEach(System.out::println);

    System.out.println("\n7. Número total de libros: " + dao.contarLibros());

    System.out.println("\n8. Precio medio de la biblioteca: " + dao.obtenerPrecioMedio());

    System.out.println("\n9. Libro más antiguo: " + dao.obtenerMasAntiguo().getTitulo());

    System.out.println("\n10. Agrupación por género (conteo)");
    dao.contarPorGenero().forEach(arr -> System.out.println(Arrays.toString(arr)));

    System.out.println("\n11. Precio medio por género");
    dao.precioMedioPorGenero().forEach(arr -> System.out.println(Arrays.toString(arr)));

    System.out.println("\n12. Géneros con más de 100 ejemplares");
    dao.generosConMasDe100Ejemplares().forEach(System.out::println);


    em.close();
    emf.close();
}


