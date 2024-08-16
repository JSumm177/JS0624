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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class JavaDemoApplication {
    private ChainsawRepository chainsawRepository;
    private LadderRepository ladderRepository;
    private JackhammerRepository jackhammerRepository;

    @Autowired
    public JavaDemoApplication(JavaDemoService javaDemoService) throws Exception {
        javaDemoService.run();
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaDemoApplication.class, args);
    }

    public static RentalAgreement checkout(Tool tool, int rentalDays, int discountPercent, LocalDate checkoutDate) {
        return null;
    }


}
