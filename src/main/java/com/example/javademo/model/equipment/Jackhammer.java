package com.example.javademo.model.equipment;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Jackhammer extends Tool{

    private final BigDecimal dailyCharge = BigDecimal.valueOf(2.99);
    private final boolean weekdayCharge = true;
    private final boolean weekendCharge = false;
    private final boolean holidayCharge = false;

    public Jackhammer() {
    }
}
