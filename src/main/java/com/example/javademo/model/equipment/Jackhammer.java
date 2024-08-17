package com.example.javademo.model.equipment;

import com.example.javademo.model.calendar.Holiday;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Jackhammer extends Tool{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final BigDecimal dailyCharge = BigDecimal.valueOf(2.99);
    private final boolean weekdayCharge = true;
    private final boolean weekendCharge = false;
    private final boolean holidayCharge = false;

    public Jackhammer(String brand, String code) {
        super(brand,code);
        this.setType("Jackhammer");
    }

    public int calculateChargeDays(LocalDate checkoutDate, LocalDate dueDate) {
        int chargeDays = 0;
        LocalDate currentDate = checkoutDate;

        while (currentDate.isBefore(dueDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            boolean isWeekday = dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
            boolean isHoliday = currentDate == Holiday.getIndependenceDay(currentDate.getYear()).date() || currentDate == Holiday.getLaborDay(currentDate.getYear()).date();
            if (this.isWeekdayCharge() && isWeekday || this.isWeekendCharge() && !isWeekday || this.isHolidayCharge() && isHoliday) {
                chargeDays++;
            }

            currentDate = currentDate.plusDays(1);
        }

        return chargeDays;
    }
}
