package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int another;
        for (int i = 0; i < nums.length; i++) {
            another = target - nums[i];
            if (map.containsKey(another) && map.get(another) != i) {
                return new int[]{map.get(another), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    @Test
    public void test() {
        int[] arr = {1, 3, 2, 4};
        int sum = 5;
        System.out.println(Arrays.toString(twoSum(arr, sum)));
    }
}
