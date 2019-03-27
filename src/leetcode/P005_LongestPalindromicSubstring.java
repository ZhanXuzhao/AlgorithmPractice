package leetcode;

import org.junit.Test;

public class P005_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] cs = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < cs.length; i++) {
            int len1 = expandAroundCenter(cs, i, i);
            int len2 = expandAroundCenter(cs, i, i + 1);
            int max = Math.max(len1, len2);
            if (max > (end - start)) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(char[] cs, int left, int right) {
        int length = 0;
        while (left >= 0 && right <= cs.length - 1) {
            if (cs[left] == cs[right]) {
                length = right - left + 1;
                left--;
                right++;
            } else {
                break;
            }
        }
        return length;
    }

    @Test
    public void test() {
        String[] strings = {"", "a", "aa", "aba", "abba", "abcda"};
        for (String s : strings) {
            System.out.println(s + " : " + longestPalindrome(s));
        }
    }


}
