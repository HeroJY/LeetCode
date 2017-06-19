package MergeTwoSortedLists;

/**
 * Created by hjy on 2017/6/19.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return null;
        }
        //初始化一个头结点
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        //插入，并排序
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
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

    public static void main(String[] args) {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode result;
        for (int i = 1; i < 5; i++) {
            t1.next = new ListNode(i);
            t2.next = new ListNode(i + 1);
            t1 = t1.next;
            t2 = t2.next;
        }
//        for(int j = 0 ;j<5;j++){
//            System.out.println(l1.val);
//            l1 = l1.next;
//        }
        result = mtsl.mergeTwoLists(l1, l2);
        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
