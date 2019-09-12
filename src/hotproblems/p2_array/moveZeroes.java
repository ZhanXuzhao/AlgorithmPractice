package hotproblems.p2_array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class moveZeroes {

    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }
        while (left < nums.length) {
            nums[left] = 0;
            left++;
        }
        System.out.println(Arrays.toString(nums));
    }


    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] res = new int[]{1, 3, 12, 0, 0};
        moveZeroes(nums);
        assert (Arrays.equals(nums, res));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{0, 0, 1};
        int[] res = new int[]{1, 0, 0};
        moveZeroes(nums);
        assert (Arrays.equals(nums, res));

        new Random().nextInt(3);
    }
}
