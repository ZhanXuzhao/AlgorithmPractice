package problems;

import org.junit.Test;

import java.util.Arrays;

public class P016_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int sum;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else {
                    if (Math.abs(result - target) > Math.abs(sum - target)) {
                        result = sum;
                    }
                    if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
