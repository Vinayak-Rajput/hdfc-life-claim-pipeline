package com.hdfclife.stack;

public class PostfixEvaluator {

    public static int evaluate(String str) {

        LinkedClaimStack linkedClaimStack = new LinkedClaimStack();

        String[] tokens = str.split(" ");

        for(String token : tokens) {

            if(!"+-*/".contains(token)) {
                linkedClaimStack.push(Integer.parseInt(token));
            }

            else {

                int operand2 = linkedClaimStack.pop();
                int operand1 = linkedClaimStack.pop();

                int result = switch (token) {
                    case "+" -> operand1 + operand2;
                    case "-" -> operand1 - operand2;
                    case "*" -> operand1 * operand2;
                    case "/" -> operand1 / operand2;
                    default -> throw new IllegalArgumentException("Invalid Operator for Expression.");

                };

                linkedClaimStack.push(result);
            }

        }

        if (linkedClaimStack.size() != 1)
            throw new RuntimeException("Invalid Postfix Expression");

        return linkedClaimStack.pop();
    }
}
