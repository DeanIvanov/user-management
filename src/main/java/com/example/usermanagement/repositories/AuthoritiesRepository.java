package com.example.usermanagement.repositories;

import com.example.usermanagement.models.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {

    Authorities getByUsername(String email);

}