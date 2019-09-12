package hotproblems.p1_string;

import org.junit.Test;

public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (table[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    @Test
    public void test() {
        assert firstUniqChar("leetcode") == 0;
    }

    @Test
    public void test2() {
        assert firstUniqChar("loveleetcode") == 2;
    }
}
