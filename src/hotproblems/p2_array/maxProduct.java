package hotproblems.p2_array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class maxProduct {
    Map<String, Integer> map = new HashMap<>();

    public int maxProduct(int[] nums) {
        int preMax = nums[0], preMin = nums[0], curMax = nums[0], curMin = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(Math.max(preMax * nums[i], preMin * nums[i]), nums[i]);
            curMin = Math.min(Math.min(preMax * nums[i], preMin * nums[i]), nums[i]);
            preMax = curMax;
            preMin = curMin;
            res = Math.max(res, curMax);
        }
        return res;
    }

    @Test
    public void test() {
        assert maxProduct(new int[]{2, 3, -2, 4}) == 6;
    }

    @Test
    public void test2() {
        assert maxProduct(new int[]{-2, 0, -1}) == 0;
    }
}
