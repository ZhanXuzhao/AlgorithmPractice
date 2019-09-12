package hotproblems.p2_array;

import org.junit.Test;

import java.util.Arrays;

public class rotate {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % nums.length;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }


    private void reverse(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] res = {5, 6, 7, 1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        rotate(nums, 3);
        System.out.println("---");
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(nums));
        assert Arrays.toString(nums).equals(Arrays.toString(res));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] res = {5, 6, 1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        rotate(nums, 2);
        System.out.println("---");
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(nums));
        assert Arrays.toString(nums).equals(Arrays.toString(res));
    }

    @Test
    public void testx() {
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < 0);
    }

    @Test
    public void testx2() {
        int i = 0;
        while (i < 3 && i != 0) {
            System.out.println(i);
            i++;
        }
    }
}
