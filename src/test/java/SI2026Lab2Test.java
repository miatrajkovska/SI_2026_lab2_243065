import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void searchBookEveryStatementTest() {
        assertThrows(IllegalArgumentException.class, () -> library.searchBookByTitle(""));

        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertNull(library.searchBookByTitle("Unknown"));

        assertNotNull(library.searchBookByTitle("Clean Code"));
    }

    @Test
    void borrowBookEveryBranchTest(){
        //prazen title
        assertThrows(IllegalArgumentException.class,()->library.borrowBook("","Robert C. Martin"));

        //kniga ne postoi
        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertThrows(RuntimeException.class, () -> library.borrowBook("Unknown","Unknown"));

        //kniga e vekje iznajmena
        library.borrowBook("Clean Code","Robert C. Martin");
        assertThrows(RuntimeException.class, () -> library.borrowBook("Clean Code","Robert C. Martin"));

        //kniga e uspesno iznajmena
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        assertDoesNotThrow( ()-> library.borrowBook("The Hobbit","J.R.R. Tolkien"));

    }

    @Test
    void borrowBookMultipleConditionTest(){
        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));

        // TT
        assertThrows(IllegalArgumentException.class,
                () -> library.borrowBook("", ""));

        // TF
        assertThrows(IllegalArgumentException.class,
                () -> library.borrowBook("", "Robert C. Martin"));

        // FT
        assertThrows(IllegalArgumentException.class,
                () -> library.borrowBook("Clean Code", ""));

        //
        assertDoesNotThrow(() -> library.borrowBook("Clean Code", "Robert C. Martin"));
    }

    @Test
    void searchBookMultipleConditionTest() {
        // TT
        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertNotNull(library.searchBookByTitle("Clean Code"));

        // TF
        library.borrowBook("Clean Code", "Robert C. Martin");
        assertNull(library.searchBookByTitle("Clean Code"));

        // F, vtoroto nebitno
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        assertNull(library.searchBookByTitle("Unknown"));
    }

}