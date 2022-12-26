import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    @Test
    public void testRepositoryAddProducts() {
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(1, "StarWars 1", 500, "Lucas");
        Book book2 = new Book(2, "StarWars 2", 600, "Lucas");
        Book book3 = new Book(3, "The Lord of the Rings", 700, "Tolkien");
        Smartphone smartphone1 = new Smartphone(4, "iPhone14", 1000, "Apple");
        Smartphone smartphone2 = new Smartphone(5, "GalaxyS22", 900, "Samsung");
        Smartphone smartphone3 = new Smartphone(6, "Mate50", 800, "Huawei");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRepositoryRemoveProducts() {
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(1, "StarWars 1", 500, "Lucas");
        Book book2 = new Book(2, "StarWars 2", 600, "Lucas");
        Book book3 = new Book(3, "The Lord of the Rings", 700, "Tolkien");
        Smartphone smartphone1 = new Smartphone(4, "iPhone14", 1000, "Apple");
        Smartphone smartphone2 = new Smartphone(5, "GalaxyS22", 900, "Samsung");
        Smartphone smartphone3 = new Smartphone(6, "Mate50", 800, "Huawei");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.removeByID(3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

}
