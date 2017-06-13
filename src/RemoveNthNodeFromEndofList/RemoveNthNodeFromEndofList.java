package RemoveNthNodeFromEndofList;

/**
 * Created by hjy on 2017/6/13.
 * 思路：设置两个指针first跟second。
 * first指针先移动n步，若此时first指针为空，则表示要删除的是头节点，此时直接返回head->next即可。
 * 如果first指针不为空，则将两个指针一起移动，直到first指针指向最后一个节点，
 * 令second->next=second->next->next即可删除第你n个节点。
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //首先判空
        if (head == null || head.next == null) {
            return null;
        }
        //设置两个指针
        ListNode firstNode = head;
        ListNode secondNode = head;
        //首先first先移动n，判断是否是要删除头结点
        for (int i = 0; i < n; i++) {
            firstNode = firstNode.next;
        }
        if (firstNode == null) {
            return head.next;
        }
        //然后开始移动两个结点
        while (firstNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        //删除选中的点
        secondNode.next = secondNode.next.next;
        return head;
    }
}
