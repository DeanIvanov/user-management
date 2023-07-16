package com.example.usermanagement.repositories;

import com.example.usermanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getById(int id);

    List<User> findAll();

    User getByEmail(String email);

    User getByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsById(int id);

    List<User> findAllByOrderBySurnameAsc();

    List<User> findAllByOrderByDobAsc();

    List<User> findAllByNameOrSurnameOrEmailOrPhone(String name, String surname, String email, String phone);
}
