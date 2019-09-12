package hotproblems.p2_array;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class productExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            k *= nums[i - 1];
            res[i] = k;
        }
        k = 1;
        for (int i = res.length - 2; i >= 0; i--) {
            k *= nums[i + 1];
            res[i] *= k;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] expect = new int[]{24, 12, 8, 6};
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));

        assert Arrays.equals(expect, res);
    }
}
