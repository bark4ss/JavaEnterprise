package by.teachMeSkills.JavaEE.testDemo;

import by.teachmeskills.JavaEE.testDemo.Calculator;
import org.hibernate.annotations.Source;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    void setup() {
        System.out.println("@BeforeAll executed");
        calculator = new Calculator();
    }

    @BeforeEach
    void setupThis() {
        System.out.println("@BeforeEach executed");
    }

    @Tag("DEV")
    @Test
    void testCalcOne() {
        System.out.println("======TEST ONE EXECUTED=======");
        Assertions.assertEquals(4, calculator.add(2, 2));
    }

    @Tag("PROD")
    @Disabled
    @Test
    void testCalcTwo() {
        Assertions.assertEquals(6, calculator.add(2, 3), "======TEST TWO EXECUTED=======");
    }

    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "1,2,3",
            "2,3,5",
            "2,2,4"
    }

    )
    void testCalcThree(int a, int b, int sum) {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.assertEquals(sum, calculator.add(a, b));
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
