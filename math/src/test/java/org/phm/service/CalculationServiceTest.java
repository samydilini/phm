package org.phm.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.phm.Solution;

import static org.junit.jupiter.api.Assertions.*;

class CalculationServiceTest {
    private CalculationService calculationService;

    @BeforeEach
    public void setUp() {
        calculationService = new CalculationService();
    }

    @Test
    public void calculateTwoNumbers() {
        ////(1)+(2)-(1X2)=1
        Solution solution = calculationService.calculate(new int[]{1, 2});
        assertEquals("(1)+(2)-(1X2)", solution.equation());
        assertEquals(1, solution.answer());

        //(3)+(4) - (3X4)
        Solution solution2 = calculationService.calculate(new int[]{3, 4});
        assertEquals("(3)+(4)-(3X4)", solution2.equation());
        assertEquals(-5, solution2.answer());

    }

    @Test
    public void calculateThreeNumbers() {
        //1,2,3
        //(1)+(2)+(3)−(1×2)−(1×3)−(2×3)+(1×2×3)
        //1
        Solution solution = calculationService.calculate(new int[]{1, 2, 3});
        assertEquals("(1)+(2)+(3)-(1X2)-(1X3)-(2X3)+(1X2X3)", solution.equation());
        assertEquals(1, solution.answer());

        //2,4,6
        //(2)+(4)+(6)−(2×4)−(2×6)−(4×6)+(2×4×6)
        //16
        Solution solution2 = calculationService.calculate(new int[]{2, 4, 6});
        assertEquals("(2)+(4)+(6)-(2X4)-(2X6)-(4X6)+(2X4X6)", solution2.equation());
        assertEquals(16, solution2.answer());

    }

    @Test
    public void calculateFourNumbers() {
        //1,2,3,4
        //(1)+(2)+(3)+(4)−(1×2)−(1×3)−(1×4)−(2×3)−(2×4)−(3×4)+(1×2×3)+(1×2×4)+(1×3×4)+(2×3×4)−(1×2×3×4)

        Solution solution = calculationService.calculate(new int[]{1, 2, 3, 4});
        assertEquals("(1)+(2)+(3)+(4)-(1X2)-(1X3)-(1X4)-(2X3)-(2X4)-(3X4)+(1X2X3)+(1X2X4)+(1X3X4)+(2X3X4)-(1X2X3X4)", solution.equation());
        assertEquals(1, solution.answer());

    }

}