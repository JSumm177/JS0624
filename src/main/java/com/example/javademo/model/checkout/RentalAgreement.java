package com.example.javademo.model.checkout;

import com.example.javademo.model.equipment.Tool;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class RentalAgreement {
    public void printAgreement(Tool tool) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");

        System.out.println("Tool code: " + tool.getCode());
        System.out.println("Tool type: " + tool.getType());
        // ... other details
//        System.out.println("End date: " + endDate.format(dateFormatter));
//        System.out.println("Final charge: " + currencyFormatter.format(totalCharge));
//        System.out.println("Discount: " + percentFormatter.format(discount));
    }
}
