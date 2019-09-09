package problems;

import utils.ListNode;
import utils.ListNodeUtil;
import org.junit.Test;

public class P019_RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode p2 = dummy;
        while (n >= 0) {
            p = p.next;
            n--;
        }
        while (p != null) {
            p = p.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }

    @Test
    public void test() {
//        utils.ListNode listNode = utils.ListNodeUtil.createListNode(0, 1, 2, 3, 4, 5);
        ListNode listNode = ListNodeUtil.createListNode(0, 1);
//        utils.ListNode listNode = utils.ListNodeUtil.createListNode(0);
        ListNodeUtil.printListNode(listNode);
        ListNodeUtil.printListNode(removeNthFromEnd(listNode, 1));
    }
}
