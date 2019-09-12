package hotproblems.p2_array;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}
