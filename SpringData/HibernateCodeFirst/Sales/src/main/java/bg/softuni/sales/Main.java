package bg.softuni.sales;

import bg.softuni.sales.entities.Customer;
import bg.softuni.sales.entities.Product;
import bg.softuni.sales.entities.Sale;
import bg.softuni.sales.entities.StoreLocation;
import bg.softuni.sales.utils.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        entityManager.getTransaction().begin();

        Product product = new Product();
        product.setName("Test_product");
        product.setQuantity(10.00);
        product.setPrice(BigDecimal.valueOf(20));

        entityManager.persist(product);

        Customer customer = new Customer();
        customer.setName("Pesho");

        entityManager.persist(customer);

        StoreLocation storeLocation = new StoreLocation();
        storeLocation.setLocationName("test_name");

        entityManager.persist(storeLocation);

        Sale sale = new Sale();
        sale.setCustomer(customer);
        sale.setProduct(product);
        sale.setStoreLocation(storeLocation);
        sale.setDate(Date.from(Instant.now()));

        entityManager.persist(sale);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
