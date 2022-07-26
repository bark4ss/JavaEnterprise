package by.teachMeSkills.JavaEE.testDemo;

import by.teachmeskills.JavaEE.testDemo.Calculator;
import org.hibernate.annotations.Source;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(2)
    void testCalcOne() {
        System.out.println("======TEST ONE EXECUTED=======");
        Assertions.assertEquals(25, calculator.add(2, 23));
    }

    @Tag("PROD")
    @Disabled
    @Test
    @Order(1)
    void testCalcTwo() {
        Assertions.assertEquals(6, calculator.add(2, 3), "======TEST TWO EXECUTED=======");
    }

    @DisplayName("Parameterized Tests Example")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "1,2,3",
            "2,3,5",
            "2,2,4"
    }

    )
    @Order(3)
    void testCalcThree(int a, int b, int sum) {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.assertEquals(sum, calculator.add(a, b));
    }

    @Test
    @Order(4)
    void testCalcFive() {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.fail("/TODO");
    }

    @Test
    @Order(5)
    void testMultiplyTwoAndTwoGivenFour(){
        int expected = 4;
        int actual = calculator.multiply(2,2);
        Assertions.assertEquals(expected,actual,"Should return four");
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
