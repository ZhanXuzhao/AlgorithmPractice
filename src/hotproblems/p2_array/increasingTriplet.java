package hotproblems.p2_array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class increasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= one) {
                one = n;
            } else if (n <= two) {
                two = n;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        assert increasingTriplet(nums);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        assert !increasingTriplet(nums);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{5, 1, 5, 5, 2, 5, 4};
        assert increasingTriplet(nums);
    }

    @Test
    public void test4() {
        int[] nums = new int[]{2, 4, -2, -3};
        assert !increasingTriplet(nums);
    }
}
