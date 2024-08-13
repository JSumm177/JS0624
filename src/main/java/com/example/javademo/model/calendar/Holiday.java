package com.example.javademo.model.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public record Holiday(String name, LocalDate date) {

    public static Holiday getLaborDay(int year) {
        // Calculate Labor Day based on the first Monday in September
        LocalDate laborDay = LocalDate.of(year, 9, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        return new Holiday("Labor Day", laborDay);
    }
}
