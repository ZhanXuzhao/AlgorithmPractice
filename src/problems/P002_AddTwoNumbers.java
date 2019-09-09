package problems;

public class P002_AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pr = result;
        ListNode p1 = l1;
        ListNode p2 = l2;

        int sum;
        int remainder=0;
        while (p1 != null || p2 != null) {
            pr.next = new ListNode(0);
            pr = pr.next;
            sum = remainder;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            pr.val = sum % 10;
            remainder = sum / 10;
        }
        if (remainder != 0) {
            pr.next = new ListNode(remainder);
        }
        return result.next;
    }
}
