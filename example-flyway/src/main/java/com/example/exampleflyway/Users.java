package com.example.exampleflyway;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Table(name = "USERS")
@Entity
@Setter
@Getter
public class Users {
    @Id
    private String id;
    private String firstName;
    private String LastName;
}
