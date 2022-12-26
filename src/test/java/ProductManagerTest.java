import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test
    public void testAddZeroProduct() {
        ProductRepository repo = new ProductRepository();
        Product[] actual = repo.findAll();
        Product[] expected = new Product[0];

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddOneProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "StarWars 1", 500, "Lucas");
        manager.add(book1);
        Product[] actual = repo.findAll();
        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddProducts() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "StarWars 1", 500, "Lucas");
        Book book2 = new Book(2, "StarWars 2", 600, "Lucas");
        Book book3 = new Book(3, "The Lord of the Rings", 700, "Tolkien");
        Smartphone smartphone1 = new Smartphone(3, "iPhone14", 1000, "Apple");
        Smartphone smartphone2 = new Smartphone(4, "GalaxyS22", 900, "Samsung");
        Smartphone smartphone3 = new Smartphone(5, "Mate50", 800, "Huawei");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByMultipleProducts() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "StarWars 1", 500, "Lucas");
        Book book2 = new Book(2, "StarWars 2", 600, "Lucas");
        Book book3 = new Book(3, "The Lord of the Rings", 700, "Tolkien");
        Smartphone smartphone1 = new Smartphone(4, "iPhone14", 1000, "Apple");
        Smartphone smartphone2 = new Smartphone(5, "GalaxyS22", 900, "Samsung");
        Smartphone smartphone3 = new Smartphone(6, "Mate50", 800, "Huawei");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("StarWars");
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByOneProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "StarWars 1", 500, "Lucas");
        Book book2 = new Book(2, "StarWars 2", 600, "Lucas");
        Book book3 = new Book(3, "The Lord of the Rings", 700, "Tolkien");
        Smartphone smartphone1 = new Smartphone(3, "iPhone14", 1000, "Apple");
        Smartphone smartphone2 = new Smartphone(4, "GalaxyS22", 900, "Samsung");
        Smartphone smartphone3 = new Smartphone(5, "Mate50", 800, "Huawei");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("GalaxyS22");
        Product[] expected = {smartphone2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchByZeroProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "StarWars 1", 500, "Lucas");
        Book book2 = new Book(2, "StarWars 2", 600, "Lucas");
        Book book3 = new Book(3, "The Lord of the Rings", 700, "Tolkien");
        Smartphone smartphone1 = new Smartphone(3, "iPhone14", 1000, "Apple");
        Smartphone smartphone2 = new Smartphone(4, "GalaxyS22", 900, "Samsung");
        Smartphone smartphone3 = new Smartphone(5, "Mate50", 800, "Huawei");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("MacBook");
        Product[] expected = new Product[0];

        Assertions.assertArrayEquals(expected, actual);

    }
}
