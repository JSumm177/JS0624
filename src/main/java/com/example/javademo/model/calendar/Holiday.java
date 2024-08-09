package com.example.javademo.model.calendar;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Getter
@Setter
public class Holiday {
    private final String name;
    private final LocalDate date;

    public Holiday(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public static Holiday getLaborDay(int year) {
        // Calculate Labor Day based on the first Monday in September
        LocalDate laborDay = LocalDate.of(year, 9, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        return new Holiday("Labor Day", laborDay);
    }
}
