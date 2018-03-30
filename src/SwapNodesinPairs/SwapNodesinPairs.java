package SwapNodesinPairs;

/**
 * Created by hjy on 2018/3/29.
 * 交换链表中相邻节点位置
 * 例如1->2->3->4交换后2->1->4->3
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        //传入链表长度为一个结点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode( 0 );
        result.next = head;
        ListNode current = result;
        //判断是否有后两个元素进行交换
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode secend = current.next.next;
            first.next = secend.next;
            current.next = secend;
            current.next.next = first;
            current = current.next.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode( 1 );
        listNode.next = new ListNode( 2 );
        listNode.next.next = new ListNode( 3 );
//        listNode.next.next.next = new ListNode( 4 );
        SwapNodesinPairs swapNodesinPairs = new SwapNodesinPairs();
        ListNode result = swapNodesinPairs.swapPairs( listNode );
        while (result != null) {
            System.out.println( result.val );
            result = result.next;
        }
    }
}
