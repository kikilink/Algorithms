package com.khlin.stack;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 中缀表达式计算器
 */
public class Infix {

    private static final Map<String, Integer> OPERATORS_PRIORITY = new HashMap<String, Integer>() {
        {
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
            this.put("(", 3);
            this.put(")", 3);
        }
    };

    public BigDecimal calculate(String infixExpression) {
        return reversePolish(calculateExpression(infixExpression));
    }

    private boolean isPartOfNumber(char c) {
        return (c >= '0' && c <= '9') || '.' == c;
    }

    private List<String> calculateExpression(String infixExpression) {
        List<String> operands = new ArrayList<>();
        List<String> expression = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        infixExpression = preprocess(infixExpression);

        char[] expressionArray = infixExpression.toCharArray();
        for (int index = 0; index <= infixExpression.length() - 1; index++) {
            char c = expressionArray[index];
            if (' ' == c) {
                continue;
            }
            String item = String.valueOf(c);
            if (isPartOfNumber(c)) {
                operands.add(item);
            } else if (OPERATORS_PRIORITY.containsKey(item)) {
                // 把两个符号间的数字拼接起来
                if (!operands.isEmpty()) {
                    String numStr = operands.stream().collect(Collectors.joining());
                    if (!isNumber(numStr)) {
                        throw new IllegalArgumentException("illegal argument." + numStr);
                    }
                    operands.clear();
                    expression.add(numStr);
                }

                // 开始弹栈
                if (operators.isEmpty()) {
                    operators.push(item);
                } else {
                    // 分三种情况讨论
                    switch (item) {
                        case "(":
                            operators.push(item);
                            break;
                        case ")":
                            String lastOperator = operators.peek();
                            // 一直找到左括号，把所有的符号都弹出来
                            boolean noMoreOperators = false;
                            while (!"(".equals(lastOperator)) {
                                lastOperator = operators.pop();
                                expression.add(lastOperator);
                                if (operators.isEmpty()) {
                                    noMoreOperators = true;
                                    break;
                                }
                                lastOperator = operators.peek();
                            }

                            if (!noMoreOperators) {
                                operators.pop();
                            }
                            break;
                        default:
                            String theLastOperator = operators.peek();
                            // 只要栈的比它大，就弹
                            while (OPERATORS_PRIORITY.get(theLastOperator).compareTo(OPERATORS_PRIORITY.get(item)) >= 0) {
                                // 找到左括号了，不能继续比较
                                if ("(".equals(theLastOperator)) {
                                    break;
                                }
                                // 弹出
                                expression.add(operators.pop());
                                if (operators.isEmpty()) {
                                    break;
                                }
                                theLastOperator = operators.peek();
                            }
                            // 弹完再把当前符号压进去
                            operators.push(item);
                    }
                }
            }
        }


        if (!operands.isEmpty()) {
            expression.add(operands.stream().collect(Collectors.joining()));
        }

        while (!operators.isEmpty()) {
            expression.add(operators.pop());
        }

        return expression;
    }

    private String preprocess(String infixExpression) {
        String processedString = infixExpression.replace(" ", "");
        if (processedString.startsWith("-")) {
            processedString = "0" + processedString;
        }

        processedString = processedString.replace("(-", "(0-");
        return processedString;
    }

    private BigDecimal reversePolish(List<String> reversePolishExpression) {
        Stack<BigDecimal> stack = new Stack<>();
        for (String item : reversePolishExpression) {
            // 数字，直接入栈
            if (isNumber(item)) {
                stack.push(new BigDecimal(item));
            } else if (OPERATORS_PRIORITY.containsKey(item)) {
                BigDecimal second = stack.pop();
                BigDecimal first = stack.pop();
                BigDecimal newResult = null;
                switch (item) {
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
                        newResult = first.divide(second, 2, BigDecimal.ROUND_HALF_UP);
                        break;
                }
                stack.push(newResult);

            } else {
                throw new IllegalArgumentException("illegal symbol:" + item);
            }
        }

        return stack.pop().setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private boolean isNumber(String numStr) {
        try {
            new BigDecimal(numStr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
