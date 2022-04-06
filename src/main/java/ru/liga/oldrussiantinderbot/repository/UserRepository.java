package ru.liga.oldrussiantinderbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.oldrussiantinderbot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {
}
