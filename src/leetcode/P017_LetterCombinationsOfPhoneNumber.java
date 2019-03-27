package leetcode;

import org.junit.Test;

import java.util.*;

public class P017_LetterCombinationsOfPhoneNumber {
    Map<Character, String> map = new HashMap<>();

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null | digits.length() == 0) {
            return res;
        }
        res.add("");
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char c : map[Character.getNumericValue(digits.charAt(i))].toCharArray()) {
                    res.add(t + c);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        String s = "23";
//        String s = "";
        System.out.println(letterCombinations(s));

    }
}
