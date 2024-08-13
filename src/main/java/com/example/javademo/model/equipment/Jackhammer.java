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
public class Jackhammer extends Tool{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or other strategies
    private Long id;
    private final BigDecimal dailyCharge = BigDecimal.valueOf(2.99);
    private final boolean weekdayCharge = true;
    private final boolean weekendCharge = false;
    private final boolean holidayCharge = false;

    public Jackhammer(String brand, String code) {
        super();
        this.setType("Jackhammer");
    }
}
