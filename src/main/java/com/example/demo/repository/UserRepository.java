package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


    //see klass aitab juurde saada ligipääsu andmebaasile
public interface UserRepository extends JpaRepository<User, Long> {

}
