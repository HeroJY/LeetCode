package MergeKSortedLists;

/**
 * Created by hjy on 2017/6/28.
 * 思路：先把k个list分成两半，然后继续划分，直到剩下两个list就合并起来
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        //先判断为空
        if (lists == null || lists.length == 0) {
            return null;
        }
        return div(lists, 0, lists.length - 1);
    }

    //这里使用递归
    public ListNode div(ListNode[] listNodes, int low, int high) {
        //这里是结束递归的条件
        if (low == high) {
            return listNodes[low];
        }
        if (low < high) {
            int mid = (low + high) / 2;
            ListNode l1 = div(listNodes, low, mid);
            ListNode l2 = div(listNodes, mid + 1, high);
            return mergeTwoSortedLists(l1, l2);
        } else {
            return null;
        }
    }

    //合并两个有序链表（归并）
    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return result.next;
    }
}
