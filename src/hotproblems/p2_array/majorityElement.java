package hotproblems.p2_array;

import org.junit.Test;

import java.util.HashMap;

public class majorityElement {

    public int majorityElement(int[] nums) {
        int count = 0, candidate = nums[0];
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            count += (n == candidate) ? 1 : -1;
        }
        return candidate;
    }

    @Test
    public void test() {
        assert majorityElement(new int[]{3, 2, 3}) == 3;
    }

    @Test
    public void test2() {
        assert majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}) == 2;
    }

    @Test
    public void test3() {
        assert majorityElement(new int[]{6, 5, 5}) == 5;
    }
}
