package com.example.javademo.model.equipment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tool {
    @Id
    private Long id;
    private String code;
    private String type;
    private String brand;
}
