package utils;

import org.junit.Test;

public class ListNodeUtil {
    public static void printListNode(ListNode listNode) {
        ListNode p = listNode;
        while (p != null) {
            System.out.print(p.val + (p.next != null ? " -> " : ""));
            p = p.next;
        }
        System.out.println("");
    }

    public static ListNode createListNode(int... values) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int value : values) {
            p.next = new ListNode(value);
            p = p.next;
        }
        return head.next;
    }

    @Test
    public void test() {
        printListNode(createListNode(1, 2, 3, 4));
    }
}
