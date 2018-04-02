package ReverseNodesinKGroup;

/**
 * Created by hjy on 2018/4/2.
 *
 * @author hjy
 *         每k个一组翻转链表：
 *         给出一个链表，一次翻转 k 个指针节点，并返回修改后的链表。
 *         k 是一个正整数，并且小于等于链表的长度。如果指针节点的数量不是 k 的整数倍，那么最后剩余的节点应当保持原来的样子。
 *         <p>
 *         思路：用三个指针 curtail, curhead, posthead。
 *         curtail 指向反转后的尾结点，
 *         curhead 指向反转后的头结点，
 *         posthead 是反转过程中
 *         curhead 的后一个结点，用于辅助反转。
 */
public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //首先判断是否需要翻转
        if (head == null || k < 2) {
            return head;
        }
        ListNode prehead = new ListNode( 0 );
        prehead.next = head;
        int cnt = 0;
        //迭代结点
        ListNode node = head;
        //上次k个结点反转后的尾结点
        ListNode lasttail = prehead;
        //这次要反转的k个结点的尾结点
        ListNode curtail = head;
        //这次要反转的k个结点的头结点
        ListNode curhead = head;
        //这次要反转的k个结点的头结点后面的一个结点
        ListNode posthead;
        while (node != null) {
            cnt++;
            node = node.next;
            //是否到翻转终点
            if (cnt == k) {
                //临时辅助结点
                ListNode temp = curtail.next;
                while (temp != node) {
                    posthead = curhead;
                    curhead = temp;
                    temp = temp.next;
                    curhead.next = posthead;
                }
                //把这次反转的k个结点接到上次的k个结点后
                lasttail.next = curhead;
                lasttail = curtail;
                //指针归位
                curtail = node;
                curhead = node;
                //计数清零
                cnt = 0;
            }
        }

        //如果后面还有少于k个的结点，直接把其接到之前的链表上
        lasttail.next = curhead;

        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode( 1 );
        listNode.next = new ListNode( 2 );
        listNode.next.next = new ListNode( 3 );
        listNode.next.next.next = new ListNode( 4 );
        listNode.next.next.next.next = new ListNode( 5 );
        listNode.next.next.next.next.next = new ListNode( 6 );
        listNode.next.next.next.next.next.next = new ListNode( 7 );
        ReverseNodesinKGroup reverseNodesinKGroup = new ReverseNodesinKGroup();
        ListNode result = reverseNodesinKGroup.reverseKGroup( listNode, 3 );
        while (result != null) {
            System.out.println( result.val );
            result = result.next;
        }
    }
}
