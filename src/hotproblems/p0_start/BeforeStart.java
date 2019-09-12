package hotproblems.p0_start;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class BeforeStart {

    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = nums[0];
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > map.get(max)) {
                max = n;
            }
        }
        return max;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int shortDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shortDim; i++) {
            if (binSearch(matrix, target, i, false) || binSearch(matrix, target, i, true)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int r = matrix.length - 1;
        int c = 0;
        while (r >= 0 && c < matrix[0].length) {
            if (matrix[r][c] > target) {
                r--;
            } else if (matrix[r][c] < target) {
                c++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean binSearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = (vertical ? matrix.length : matrix[0].length) - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (vertical) {
                if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else {
                    return true;
                }
            } else {
                if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
//        assert majorityElement(new int[]{3, 2, 3}) == 3;
//        assert majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}) == 2;
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        assert searchMatrix(matrix, 5);
        assert !searchMatrix(matrix, 20);
    }

    @Test
    public void test2() {
        int a = 3, b = 8;
        System.out.println((a + b) / 2);
        System.out.println(a + (b - a) / 2);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    @Test
    public void testMerge() {
        int m = 3, n = 3;
        int[] n1 = {1, 2, 3, 0, 0, 0};
        int[] n2 = {2, 5, 6};
        merge(n1, m, n2, n);
        System.out.println("---");
        System.out.println(Arrays.toString(n1));
    }

    @Test
    public void testMerge2() {
        int m = 0, n = 1;
        int[] n1 = {0};
        int[] n2 = {1};
        merge(n1, m, n2, n);
        System.out.println(Arrays.toString(n1));
    }

    public int superEggDrop(int K, int N) {
        int i = 0, n = N, k = K;
        while (n > 0 && k > 1) {
            k--;
            i++;
            n = n / 2;
        }
        return i + n;
    }

    public int superEggDrop2(int K, int N) {
        int lo = 1, hi = N;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (f(mi, K, N) < N)
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;
    }

    public int f(int x, int K, int N) {
        int ans = 0, r = 1;
        for (int i = 1; i <= K; ++i) {
            r *= x - i + 1;
            r /= i;
            ans += r;
            if (ans >= N) break;
        }
        return ans;
    }

    @Test
    public void testSuperEggDrop() {
        assert superEggDrop(1, 2) == 2;
        assert superEggDrop(2, 2) == 2;
        assert superEggDrop(1, 3) == 3;
        assert superEggDrop(2, 6) == 3;
        assert superEggDrop(3, 14) == 4;
    }
}

