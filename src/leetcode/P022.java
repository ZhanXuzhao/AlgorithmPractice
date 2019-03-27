package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P022 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrace(list, "", 0, 0, n);
        return list;
    }

    private void backtrace(List<String> list, String s, int open, int close, int max) {
        if (s.length() == max * 2) {
            list.add(s);
            return;
        }
        if (open < max) backtrace(list, s + "(", open + 1, close, max);
        if (close < open) backtrace(list, s + ")", open, close + 1, max);
    }

    @Test
    public void test() {
        System.out.println(generateParenthesis(4));
    }

}
