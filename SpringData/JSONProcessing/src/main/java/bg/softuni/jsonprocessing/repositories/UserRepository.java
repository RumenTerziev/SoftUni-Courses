package bg.softuni.jsonprocessing.repositories;

import bg.softuni.jsonprocessing.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
