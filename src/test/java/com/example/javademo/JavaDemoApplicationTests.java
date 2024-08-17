package com.example.javademo;

import com.example.javademo.model.checkout.RentalAgreement;
import com.example.javademo.model.equipment.Chainsaw;
import com.example.javademo.model.equipment.Jackhammer;
import com.example.javademo.model.equipment.Ladder;
import com.example.javademo.repository.ChainsawRepository;
import com.example.javademo.repository.JackhammerRepository;
import com.example.javademo.repository.LadderRepository;
import com.example.javademo.service.JavaDemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class JavaDemoApplicationTests {
    @Mock
    private ChainsawRepository chainsawRepository;
    @Mock
    private LadderRepository ladderRepository;
    @Mock
    private JackhammerRepository jackhammerRepository;
    @Mock
    private JavaDemoService javaDemoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Given
        Chainsaw chainsaw = new Chainsaw("Stihl", "CHNS");
        Mockito.when(chainsawRepository.findByCode("CHNS")).thenReturn(chainsaw);
        Ladder ladder = new Ladder("Werner", "LADW");
        Mockito.when(ladderRepository.findByCode("LADW")).thenReturn(ladder);
        Jackhammer jackhammerR = new Jackhammer("Ridgid", "JAKR");
        Mockito.when(jackhammerRepository.findByCode("JAKR")).thenReturn(jackhammerR);
        Jackhammer jackhammerD = new Jackhammer("DeWalt", "JAKD");
        Mockito.when(jackhammerRepository.findByCode("JAKD")).thenReturn(jackhammerD);
    }
    private RentalAgreement performCheckout(String toolCode,int rentalDays, int discountPercent, LocalDate checkoutDate) throws Exception {
        JavaDemoApplication javaDemoApplication = new JavaDemoApplication(javaDemoService, chainsawRepository, ladderRepository, jackhammerRepository);
        return javaDemoApplication.checkout(toolCode, rentalDays, discountPercent, checkoutDate);
    }
    @Test
    public void testInvalidDiscount() throws Exception {
        Object[] testCase = {"JAKR", LocalDate.of(2015, 9, 3), 5, 101};
        String toolCode = (String) testCase[0];
        LocalDate checkoutDate = (LocalDate) testCase[1];
        int rentalDays = (Integer) testCase[2];
        int discountPercent = (Integer) testCase[3];
        assertThrows(IllegalArgumentException.class, () -> performCheckout(toolCode, rentalDays, discountPercent, checkoutDate));
    }

    @Test
    public void test2() throws Exception {
        Object[] testCase = {"LADW", LocalDate.of(2020, 7, 2), 3, 10};
        String toolCode = (String) testCase[0];
        LocalDate checkoutDate = (LocalDate) testCase[1];
        int rentalDays = (Integer) testCase[2];
        int discountPercent = (Integer) testCase[3];

        RentalAgreement rentalAgreement = performCheckout(toolCode, rentalDays, discountPercent, checkoutDate);
        rentalAgreement.printAgreement();

        // Assertions
        assertEquals("LADW", rentalAgreement.getCode());
        assertEquals("Ladder", rentalAgreement.getType());
        assertEquals("Werner", rentalAgreement.getBrand());
        assertEquals(3, rentalAgreement.getRentalDays());
        assertEquals(LocalDate.of(2020, 7, 2), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2020, 7, 5), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(1.99),
                rentalAgreement.getDailyRentalCharge());
        assertEquals(3, rentalAgreement.getChargeDays());
        assertEquals(BigDecimal.valueOf(5.97), rentalAgreement.getPreDiscountCharge());
        assertEquals(10, rentalAgreement.getDiscountPercent());
        assertEquals("0.60",
                rentalAgreement.getDiscountAmount().toString());
        assertEquals(BigDecimal.valueOf(5.37), rentalAgreement.getFinalCharge());

    }

    @Test
    public void test3() throws Exception {
        Object[] testCase = {"CHNS", LocalDate.of(2015, 7, 2), 5, 25};
        String toolCode = (String) testCase[0];
        LocalDate checkoutDate = (LocalDate) testCase[1];
        int rentalDays = (Integer) testCase[2];
        int discountPercent = (Integer) testCase[3];

        RentalAgreement rentalAgreement = performCheckout(toolCode, rentalDays, discountPercent, checkoutDate);
        rentalAgreement.printAgreement();

    }

    @Test
    public void test4() throws Exception {
        Object[] testCase = {"JAKD", LocalDate.of(2015, 9, 3), 6, 0};
        String toolCode = (String) testCase[0];
        LocalDate checkoutDate = (LocalDate) testCase[1];
        int rentalDays = (Integer) testCase[2];
        int discountPercent = (Integer) testCase[3];

        RentalAgreement rentalAgreement = performCheckout(toolCode, rentalDays, discountPercent, checkoutDate);
        rentalAgreement.printAgreement();

    }

    @Test
    public void test5() throws Exception {
        Object[] testCase = {"JAKR", LocalDate.of(2015, 7, 2), 9, 0};
        String toolCode = (String) testCase[0];
        LocalDate checkoutDate = (LocalDate) testCase[1];
        int rentalDays = (Integer) testCase[2];
        int discountPercent = (Integer) testCase[3];

        RentalAgreement rentalAgreement = performCheckout(toolCode, rentalDays, discountPercent, checkoutDate);
        rentalAgreement.printAgreement();

    }

    @Test
    public void test6() throws Exception {
        Object[] testCase = {"JAKR", LocalDate.of(2020, 7, 2), 4, 50};

        String toolCode = (String) testCase[0];
        LocalDate checkoutDate = (LocalDate) testCase[1];
        int rentalDays = (Integer) testCase[2];
        int discountPercent = (Integer) testCase[3];

        RentalAgreement rentalAgreement = performCheckout(toolCode, rentalDays, discountPercent, checkoutDate);
        rentalAgreement.printAgreement();
    }


}
