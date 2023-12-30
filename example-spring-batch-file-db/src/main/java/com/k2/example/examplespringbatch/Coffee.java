package com.k2.example.examplespringbatch;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {

    private String brand;
    private String origin;
    private String characteristics;
    private String hashCode;
}
