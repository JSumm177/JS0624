package com.example.javademo.model.equipment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Tool {
    private String code;
    private String type;
    private String brand;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Tool(String brand, String code) {
        this.setCode(code);
        this.setBrand(brand);
    }
}
