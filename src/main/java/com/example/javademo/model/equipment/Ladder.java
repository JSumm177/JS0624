package com.example.javademo.model.equipment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Ladder extends Tool{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final BigDecimal dailyCharge = BigDecimal.valueOf(1.99);
    private final boolean weekdayCharge = true;
    private final boolean weekendCharge = true;
    private final boolean holidayCharge = false;
    public Ladder(String brand, String code) {
        super(brand,code);
        this.setType("Ladder");
    }
}
