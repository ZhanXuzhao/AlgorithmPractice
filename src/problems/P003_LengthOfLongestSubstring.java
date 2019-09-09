package problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class P003_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        int max = 0;
        for (int l = 0, r = 0; r < cs.length; r++) {
            if (map.containsKey(cs[r])) {
                l = Math.max(l, map.get(cs[r]) + 1);
            }
            map.put(cs[r], r);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    @Test
    public void test() {
        String s = "12341243";

        System.out.println("result: " + lengthOfLongestSubstring(s));


    }
}
