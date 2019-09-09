package problems;

import org.junit.Test;

import java.util.Arrays;

public class P031 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, j, i);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    @Test
    public void test() {
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3};
        int[][] nns = {
//                {1, 2, 3},
//                {3, 2, 1},
//                {1, 1, 5},
//                {1, 5, 1},
                {1, 1},
                {5, 1, 1},
        };
        for (int[] ns : nns) {
            nextPermutation(ns);
            System.out.println(Arrays.toString(ns));
        }

    }
}
