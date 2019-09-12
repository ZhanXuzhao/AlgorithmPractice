package hotproblems.p2_array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * random array
 */
public class Solution {
    private int[] origin;
    private int[] array;
    private Random random = new Random();

    public Solution(int[] nums) {
        array = nums;
        origin = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = origin.clone();
        return array;
    }

    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i, random.nextInt(array.length - i) + i);
        }
        return array;
    }


}
