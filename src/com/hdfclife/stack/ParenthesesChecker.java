package com.hdfclife.stack;

import java.util.HashMap;

public class ParenthesesChecker {

    private static HashMap<Character, Character> hmap;

    static {
        hmap = new HashMap<>();
        hmap.put(')', '(');
        hmap.put(']', '[');
        hmap.put('}', '{');
    }

    public static boolean isValidParenthesis(String str) {

        ArrayClaimStack arrayClaimStack = new ArrayClaimStack(32);

        for (char ch : str.toCharArray()) {

            if (hmap.containsKey(ch)) {

                if(arrayClaimStack.isEmpty()){
                    return false;
                }

                char chTop = (char) arrayClaimStack.pop();

                if (chTop != hmap.get(ch)) {
                    return false;
                }

            } else if(hmap.containsValue(ch)) {
                arrayClaimStack.push(ch);
            }
        }
        return arrayClaimStack.isEmpty();
    }
}

