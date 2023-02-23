package com.example.demo.employers;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployersRepository extends JpaRepository <Employers,Integer> {

    @Query("SELECT e FROM Employers e WHERE e.Email = ?1")
    Optional<Employers> findEmployersbyEmail(String email);
    
}