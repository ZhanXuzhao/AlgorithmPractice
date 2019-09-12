package p3_stack;

import java.util.HashMap;
import java.util.Map;

public class MinStack {

    private ListNode mHead = null;
    private Map<Integer, Integer> mMinMap = new HashMap<>();
    private Integer mMin = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        mMinMap.put(x, mMinMap.getOrDefault(x, 0) + 1);
        if (mMin == null) {
            mMin = x;
        } else {
            mMin = Math.min(mMin, x);
        }

        ListNode newNode = new ListNode(x);
        if (mHead == null) {
            mHead = newNode;
        } else {
            ListNode oldHead = mHead;
            oldHead.prev = newNode;
            newNode.next = oldHead;
            mHead = newNode;
        }

    }

    public void pop() {
        if (mHead != null) {
            int x = mHead.val;
            mHead = mHead.next;
            if (mHead != null) {
                mHead.prev = null;
            }

            int count = mMinMap.getOrDefault(x, 0) - 1;
            mMinMap.put(x, count);
            if (count == 0) {
                mMin = null;
                for (Map.Entry<Integer, Integer> entry : mMinMap.entrySet()) {
                    if (entry.getValue() > 0) {
                        if (mMin == null) {
                            mMin = entry.getKey();
                        } else {
                            if (entry.getKey() < mMin) {
                                mMin = entry.getKey();
                            }
                        }
                    }
                }
            }
        }
    }

    public int top() {
        if (mHead != null) {
            return mHead.val;
        } else {
            throw new RuntimeException("no data");
        }
    }

    public int getMin() {
        if (mMin == null) {
            throw new RuntimeException("no data");
        } else {
            return mMin;
        }
    }

    public static class ListNode {
        public Integer val;
        public ListNode next = null;
        public ListNode prev = null;

        public ListNode(int x) {
            val = x;
        }

        public ListNode() {
        }
    }

}
