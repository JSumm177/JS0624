package com.example.javademo.model.equipment;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Ladder extends Tool{

    private final BigDecimal dailyCharge = BigDecimal.valueOf(1.99);
    private final boolean weekdayCharge = true;
    private final boolean weekendCharge = true;
    private final boolean holidayCharge = false;

    public Ladder() {
    }
}
