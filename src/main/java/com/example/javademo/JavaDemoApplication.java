package com.example.javademo;

import com.example.javademo.model.checkout.RentalAgreement;
import com.example.javademo.model.equipment.Chainsaw;
import com.example.javademo.model.equipment.Jackhammer;
import com.example.javademo.model.equipment.Ladder;
import com.example.javademo.model.equipment.Tool;
import com.example.javademo.repository.ChainsawRepository;
import com.example.javademo.repository.JackhammerRepository;
import com.example.javademo.repository.LadderRepository;
import com.example.javademo.service.JavaDemoService;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class JavaDemoApplication {
    private final ChainsawRepository chainsawRepository;
    private final LadderRepository ladderRepository;
    private final JackhammerRepository jackhammerRepository;

    @Autowired
    public JavaDemoApplication(JavaDemoService javaDemoService, ChainsawRepository chainsawRepository, LadderRepository ladderRepository, JackhammerRepository jackhammerRepository) throws Exception {
        javaDemoService.run();
        this.chainsawRepository = chainsawRepository;
        this.ladderRepository = ladderRepository;
        this.jackhammerRepository = jackhammerRepository;
//        String dateString = "9/3/15";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
//        LocalDate localDate = LocalDate.parse(dateString, formatter);
//        RentalAgreement rentalAgreement = checkout("JAKR",5,10,localDate);
//        rentalAgreement.printAgreement();
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaDemoApplication.class, args);
    }

    public RentalAgreement checkout(String code, int rentalDays, int discountPercent, LocalDate checkoutDate) {
        if (rentalDays < 1) {
            throw new IllegalArgumentException("Rental day count must be 1 or greater");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount percent must be between 0 and 100");
        }

        Tool tool = findToolByCode(code);
        if (tool == null) {
            throw new IllegalArgumentException("Tool with code " + code + " not found");
        }

        LocalDate dueDate = checkoutDate.plusDays(rentalDays);
        int chargeDays;
        BigDecimal dailyCharge;
        if (tool instanceof Chainsaw chainsaw) {
            chargeDays = chainsaw.calculateChargeDays(checkoutDate,dueDate);
            dailyCharge = chainsaw.getDailyCharge();
        } else if (tool instanceof Ladder ladder) {
            chargeDays = ladder.calculateChargeDays(checkoutDate,dueDate);
            dailyCharge = ladder.getDailyCharge();
        } else if (tool instanceof Jackhammer jackhammer) {
            chargeDays = jackhammer.calculateChargeDays(checkoutDate,dueDate);
            dailyCharge = jackhammer.getDailyCharge();
        } else {
            // Handle unknown tool type
            throw new IllegalStateException("Unexpected tool type: " + tool.getClass());
        }

        // Calculate charges
        BigDecimal preDiscountCharge = BigDecimal.valueOf(chargeDays).multiply(dailyCharge).setScale(2, RoundingMode.HALF_UP);
        BigDecimal discountAmount = preDiscountCharge.multiply(BigDecimal.valueOf(discountPercent / 100.0)).setScale(2, RoundingMode.HALF_UP);
        BigDecimal finalCharge = preDiscountCharge.subtract(discountAmount);

        return new RentalAgreement(tool.getCode(),tool.getType(), tool.getBrand(),rentalDays,checkoutDate,dueDate,dailyCharge,chargeDays,preDiscountCharge,discountPercent,discountAmount,finalCharge);
    }

    private Tool findToolByCode(String code) {
        Chainsaw chainsaw = chainsawRepository.findByCode(code);
        if (chainsaw != null) {
            return chainsaw;
        }

        Ladder ladder = ladderRepository.findByCode(code);
        if (ladder != null) {
            return ladder;
        }

        return jackhammerRepository.findByCode(code);
    }
}
