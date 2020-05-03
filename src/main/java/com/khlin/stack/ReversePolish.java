package com.khlin.stack;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 逆波兰表达式是没有圆括号的
 */
public class ReversePolish {

    private static final Set<String> OPERATORS = new HashSet<String>(){
        {
            this.add("+");
            this.add("-");
            this.add("*");
            this.add("/");
        }
    };

    public BigDecimal calculate(String reversePolishExpression) {
        String[] parsedExpression = reversePolishExpression.split(" ");
        return this.calculate(Arrays.stream(parsedExpression).collect(Collectors.toList()));
    }

    public BigDecimal calculate(List<String> reversePolishExpression) {
        Stack<BigDecimal> stack = new Stack<>();
        for (String item : reversePolishExpression) {
            // 数字，直接入栈
            if(isNumber(item)) {
                stack.push(new BigDecimal(item));
            } else if (OPERATORS.contains(item)) {
                BigDecimal second = stack.pop();
                BigDecimal first = stack.pop();
                BigDecimal newResult = null;
                switch (item){
                    case "+":
                        newResult = first.add(second);
                        break;
                    case "-":
                        newResult = first.subtract(second);
                        break;
                    case "*":
                        newResult = first.multiply(second);
                        break;
                    case "/":
                        newResult = first.divide(second, 10, BigDecimal.ROUND_HALF_UP);
                        break;
                }
                stack.push(newResult);

            } else {
                throw new IllegalArgumentException("illegal symbol:" + item);
            }
        }

        return stack.pop();
    }

    private boolean isNumber(String numStr) {
        try {
            new BigDecimal(numStr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReversePolish().calculate("6 5 2 3 + 8 * + 3 + *"));
    }
}
