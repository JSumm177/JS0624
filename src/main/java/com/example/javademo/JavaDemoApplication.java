package com.example.javademo;

import com.example.javademo.model.checkout.RentalAgreement;
import com.example.javademo.model.equipment.Ladder;
import com.example.javademo.model.equipment.Tool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

public class JavaDemoApplication {

    public static void main(String[] args) {
        Tool chnSaw = new Tool();
        chnSaw.setBrand("Stihl");
        chnSaw.setType("ChainSaw");
        chnSaw.setCode("CHNS");
    }
    public static RentalAgreement checkout(Tool tool, int rentalDays, int discountPercent, LocalDate checkoutDate) {
        return null;
    }
}
