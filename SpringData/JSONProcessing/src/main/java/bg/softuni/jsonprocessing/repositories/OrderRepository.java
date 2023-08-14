package bg.softuni.jsonprocessing.repositories;

import bg.softuni.jsonprocessing.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Product, Long> {


}
