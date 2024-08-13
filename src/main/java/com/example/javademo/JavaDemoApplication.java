package com.example.javademo;

import com.example.javademo.model.checkout.RentalAgreement;
import com.example.javademo.model.equipment.Chainsaw;
import com.example.javademo.model.equipment.Jackhammer;
import com.example.javademo.model.equipment.Ladder;
import com.example.javademo.model.equipment.Tool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class JavaDemoApplication {

    public static void main(String[] args) {
        Chainsaw chnSaw = new Chainsaw("Stihl","CHNS");
        Ladder ladder = new Ladder("Werner", "LADW");
        Jackhammer jackhammerD = new Jackhammer("Dewalt", "JAKD");
        Jackhammer jackhammerR = new Jackhammer("Rigid", "JAKR");

    }
    public static RentalAgreement checkout(Tool tool, int rentalDays, int discountPercent, LocalDate checkoutDate) {
        return null;
    }
}
