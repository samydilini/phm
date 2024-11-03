package org.phm;

import java.util.ArrayList;
import java.util.List;

public class CalculationService {

    public Solution calculate(int[] numbers) {
        StringBuilder expression = new StringBuilder();
        int result = 0;

        // Step 1: Add individual numbers to the result and expression without a leading '+' sign
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0) {
                expression.append("+");
            }
            result += numbers[i];
            expression.append("(").append(numbers[i]).append(")");
        }

        // Step 2: Generate combinations of 2 or more numbers for the inclusion-exclusion calculation
        for (int stage = 2; stage <= numbers.length; stage++) {
            List<int[]> combinations = generateCombinations(numbers, stage);
            for (int[] combination : combinations) {
                int product = 1;
                expression.append(stage % 2 == 0 ? "−" : "+").append("(");

                // Calculate the product and build the expression string
                for (int j = 0; j < combination.length; j++) {
                    product *= combination[j];
                    expression.append(combination[j]);
                    if (j < combination.length - 1) {
                        expression.append("X");
                    }
                }
                expression.append(")");

                // Alternate between subtracting and adding based on the size of the combination
                result += (stage % 2 == 0 ? -1 : 1) * product;
            }
        }

        return new Solution(expression.toString(), result);
    }

    // Generate all combinations of a given size from the input array
    private List<int[]> generateCombinations(int[] numbers, int combinationSize) {
        List<int[]> combinations = new ArrayList<>();
        generateCombinationsHelper(numbers, new int[combinationSize], 0, 0, combinations);
        return combinations;
    }

    private void generateCombinationsHelper(int[] numbers, int[] combination, int start, int depth, List<int[]> combinations) {
        if (depth == combination.length) {
            combinations.add(combination.clone());
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            combination[depth] = numbers[i];
            generateCombinationsHelper(numbers, combination, i + 1, depth + 1, combinations);
        }
    }

}
