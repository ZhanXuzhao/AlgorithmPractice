import common.ListNode;
import common.ListNodeUtil;
import org.junit.Test;

public class Link {

    private ListNode reverse(ListNode list) {
        if (list == null || list.next == null) {
            return list;
        }
        ListNode p = list;
        ListNode next = null;
        ListNode prev = null;
        while (p.next != null) {
            next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        p.next = prev;
        return p;
    }

    @Test
    public void test() {
        ListNode listNode = ListNodeUtil.createListNode(1, 2, 3, 4, 5);
        ListNodeUtil.printListNode(reverse(listNode));
    }

    public static void main(String[] args) {
        System.out.println("123");
    }
}
