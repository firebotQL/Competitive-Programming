import java.util.*;

/**
*   Simple expression
*
*   Write a simple parser to parse a formula and calculate the result. Given a string containing only integer numbers, brackets, plus and minus signs, calculate and print the numeric answer. Assume that the formula will always follow correct syntax
*   Example input:
*             (2+2)-(3-(6-5))-4
*   Example output:
*             -2
*/

class MyClass {
    public static void main(String[] args) {
        compute_expression("(2+2)-(3-(6-5))-4");
    }

    public static void compute_expression(String expr) {
        boolean braces = true;
        int start = 0, i = 0, result = 0;

        while(braces) {
            braces = false;
            boolean calculated = false;
            for(i = 0; i < expr.length() && !calculated; i++) {
                switch(expr.charAt(i)) {
                    case '(':
                        start = i;
                        braces = true;
                        break;
                    case ')':
                        result = calculate(expr, start, i); 
                        calculated = true;
                        braces = true;
                        break;
                }
            }

            if (calculated) {
                expr = expr.substring(0, start) + result + expr.substring(i, expr.length());
            }
        }
        System.out.println(calculate(expr, 0, expr.length()));
    }
    
    public static int calculate(String expr, int start, int end) {
        String evaluate = expr.substring(start, end);
        int l = 0;
        char prev = '+';
        int result = 0;
        for(int r = 0; r < evaluate.length(); r++) {
            char curr = evaluate.charAt(r); 
            switch(curr) {
                case '-':
                case '+':
                    int number = Integer.parseInt(evaluate.substring(l, r));
                    result = applyOperator(result, number, prev);
                    prev = curr;
                    break;
            }
        } 
        int number = Integer.parseInt(evaluate.substring(l, evaluate.length()));
        result = applyOperator(result, number, prev);
        return result;
    }

    public static int applyOperator(int result, int number, char operator) {
        switch(operator) {
                case '-':
                    result -= number;
                    break;
                case '+':
                    result += number;
                    break;
        }
        return result;
    }
}