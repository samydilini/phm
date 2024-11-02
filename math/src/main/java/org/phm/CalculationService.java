package org.phm;

public class CalculationService {
    //return a record with number and string
    public Solution calculate(int[] numbers) {

        String mathSign = null;
        StringBuilder expression = new StringBuilder();
        boolean setMathSign = false;
        int answer = 0;
        for (int stage = 1; stage <= numbers.length; stage++) {
            mathSign = mathSign == null || mathSign.equals("-") ? "+" : "-";

            for (int i = 0; i < numbers.length; i = i + stage) {
                if (setMathSign) expression.append(mathSign);
                setMathSign = true;
                expression.append("(");
                expression.append(numbers[i]);
                int loopValue = numbers[i];
                int nextValue = stage - 1;
                if (nextValue > 0 && i + nextValue < numbers.length) {
                    expression.append("X");
                    expression.append(numbers[i + nextValue]);
                    loopValue = loopValue * numbers[i + nextValue];
                }
                expression.append(")");
                answer = mathSign.equals("+") ? answer + loopValue : answer - loopValue;


            }

        }
        System.out.println(expression);
        return new Solution(expression.toString(), answer);

    }
}
