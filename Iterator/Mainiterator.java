// 1. Interfaz Iterador: Declara las operaciones necesarias para recorrer una colección.
public interface Iterator {
    boolean hasNext();
    Object getNext();
}

// 2. Interfaz Colección (Iterable): Declara un método para producir un iterador.
public interface IterableCollection {
    Iterator createIterator();
}

// --- CLASES DEL DOMINIO ---

public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// 3. Colección Concreta: Implementa la colección y devuelve una instancia de su iterador específico.
import java.util.ArrayList;
import java.util.List;

public class Library implements IterableCollection {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Iterator createIterator() {
        // La colección conoce qué iterador instanciar y se pasa a sí misma como referencia.
        return new BookIterator(this);
    }
}

// 4. Iterador Concreto: Implementa el recorrido de la colección concreta.
public class BookIterator implements Iterator {
    private Library library;
    private int currentIndex = 0;

    public BookIterator(Library library) {
        this.library = library;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < library.getBooks().size();
    }

    @Override
    public Object getNext() {
        if (this.hasNext()) {
            Book book = library.getBooks().get(currentIndex);
            currentIndex++;
            return book;
        }
        return null;
    }
}

// 5. Código Cliente: Trabaja con las colecciones e iteradores a través de sus interfaces.
public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.addBook(new Book("El Señor de los Anillos"));
        myLibrary.addBook(new Book("Cien Años de Soledad"));
        myLibrary.addBook(new Book("1984"));

        // El cliente no necesita saber que la biblioteca usa un ArrayList internamente.
        Iterator iterator = myLibrary.createIterator();

        System.out.println("Recorriendo la biblioteca:");
        while (iterator.hasNext()) {
            Book book = (Book) iterator.getNext();
            System.out.println("- " + book.getTitle());
        }
    }
}
