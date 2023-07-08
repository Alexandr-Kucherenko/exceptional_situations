import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {



    @Test
    void testRemoveProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(22,"телевизор", 20000);
        Product product2 = new Product(12,"телефон",5000);
        Product product3 = new Product(15,"книга", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(12);
        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    void testRemoveNoProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(22,"телевизор", 20000);
        Product product2 = new Product(12,"телефон",5000);
        Product product3 = new Product(15,"книга", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, ()-> repo.remove(32));
    }
    @Test
    void testAddNewProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(22,"телевизор", 20000);
        Product product2 = new Product(12,"телефон",5000);
        Product product3 = new Product(15,"книга", 500);
        Product product4 = new Product(32,"ноутбук",10000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        Product[] expected = {product1,product2, product3,product4};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    void testAddAvailableProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(22,"телевизор", 20000);
        Product product2 = new Product(12,"телефон",5000);
        Product product3 = new Product(15,"книга", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(AlreadyExistsException.class, ()-> repo.AddingProduct(22));
    }

}