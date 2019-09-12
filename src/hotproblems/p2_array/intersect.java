package hotproblems.p2_array;

import org.junit.Test;

import java.util.*;

public class intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nShort, nLong, maxIntersect;
        if (nums1.length > nums2.length) {
            nShort = nums2;
            nLong = nums1;
        } else {
            nShort = nums2;
            nLong = nums1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int n : nShort) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : nLong) {
            if (map.containsKey(n) && map.get(n) > 0) {
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
//        maxIntersect = list.stream().mapToInt(i -> i).toArray();
//        System.out.println(list);
        maxIntersect = new int[list.size()];
        int len = list.size();
        for (int i = 0; i < len; i++) {
            maxIntersect[i] = list.pop();
        }
//        System.out.println(Arrays.toString(maxIntersect));
        return maxIntersect;
    }

    @Test
    public void test() {
        int[] n1 = new int[]{1, 2, 2, 1};
        int[] n2 = new int[]{2, 2};
        int[] res = new int[]{2, 2};
        assert Arrays.equals(intersect(n1, n2), res);
    }

    @Test
    public void test2() {
        int[] n1 = new int[]{4, 9, 5};
        int[] n2 = new int[]{9, 4, 9, 8, 4};
        int[] res = new int[]{4, 9};
        assert Arrays.equals(intersect(n1, n2), res);
    }
}
