package leetcode;

import common.ListNode;
import common.ListNodeUtil;
import org.junit.Test;

public class P021 {
//    public common.ListNode mergeTwoLists(common.ListNode l1, common.ListNode l2) {
//        common.ListNode dummyHead = new common.ListNode(0);
//        common.ListNode pd = dummyHead;
//        common.ListNode p1 = l1;
//        common.ListNode p2 = l2;
//        while (p1 != null || p2 != null) {
//            if (p1 == null) {
//                p2 = copyValue(pd, p2);
//            } else if (p2 == null) {
//                p1 = copyValue(pd, p1);
//            } else {
//                if (p1.val < p2.val) {
//                    p1 = copyValue(pd, p1);
//                } else{
//                    p2 = copyValue(pd, p2);
//                }
//            }
//            pd = pd.next;
//        }
//        return dummyHead.next;
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pd = dummyHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                pd.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                pd.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            pd = pd.next;
        }
        if (p1 != null) {
            pd.next = p1;
        } else {
            pd.next = p2;
        }
        return dummyHead.next;
    }

    private ListNode copyValue(ListNode pd, ListNode p) {
        pd.next = new ListNode(p.val);
        return p.next;
    }

//    public common.ListNode mergeTwoLists(common.ListNode l1, common.ListNode l2) {
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//        if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l2.next, l1);
//            return l2;
//        }
//    }


    @Test
    public void test() {
        ListNodeUtil.createListNode(1, 2, 4);
        ListNodeUtil.printListNode(mergeTwoLists(ListNodeUtil.createListNode(1, 2, 4), ListNodeUtil.createListNode(1, 3, 4)));
    }
}
