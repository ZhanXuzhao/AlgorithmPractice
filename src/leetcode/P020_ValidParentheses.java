package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P020_ValidParentheses {
    private Map<Character, Character> mMap = new HashMap<>();
    {
        mMap.put(')', '(');
        mMap.put(']', '[');
        mMap.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (mMap.containsKey(c)) {
                char left = mMap.get(c);
                if (stack.empty()) {
                    return false;
                }
                char last = stack.pop();
                if (last != left) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private char getLeftForRight(char c) {
        switch (c) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                throw new IllegalArgumentException("IllegalArgumentException");
        }
    }

    @Test
    public void test() {
        String[] ss = {"]", "()", "()[]{}", "(]", "([)]", "{[]}"};
        for (String s : ss) {
            System.out.println(s + " -> " + isValid(s));
        }
    }
}
