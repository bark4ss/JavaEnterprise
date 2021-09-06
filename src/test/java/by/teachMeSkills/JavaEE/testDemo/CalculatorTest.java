package by.teachMeSkills.JavaEE.testDemo;

import by.teachmeskills.JavaEE.testDemo.Calculator;
import org.hibernate.annotations.Source;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll executed");
    }

    @BeforeEach
    void setupThis() {
        System.out.println("@BeforeEach executed");
    }

    @Tag("DEV")
    @Test
    void testCalcOne() {
        System.out.println("======TEST ONE EXECUTED=======");
        Assertions.assertEquals(4, Calculator.add(2, 2));
    }

    @Tag("PROD")
    @Disabled
    @Test
    void testCalcTwo() {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.assertEquals(6, Calculator.add(2, 3));
    }

    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "1,2,4",
            "2,3,5",
            "2,2,4"
    }

    )
    void testCalcThree(int a, int b, int sum) {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.assertEquals(sum, Calculator.add(a, b));
    }

    @Test
    void testCalcFive() {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.fail("/TODO");
    }

    @AfterEach
    void tearThis() {
        System.out.println("@AfterEach executed");
    }

    @AfterAll
    static void tear() {
        System.out.println("@AfterAll executed");
    }
}
