package com.example.exampleflyway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersInterface extends JpaRepository<Users,String> {

}
