package SwapNodesinPairs;

/**
 * Created by hjy on 2018/3/30.
 * 这里采用递归作为第二种方法
 */
public class SwapNodesinPairs2 {
    public ListNode swapPairs(ListNode head) {
        //递归终止条件
       if(head == null || head.next == null){
           return head;
       }
       //结果链表的头结点
       ListNode temp = head.next;
       //其次递归改变链表后半部分
       head.next = swapPairs( head.next.next );
       //把改变后的链表后半部分拼接到头结点后
       temp.next = head;
        return temp;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode( 2 );
        listNode.next = new ListNode( 3 );
        listNode.next.next = new ListNode( 4 );
        listNode.next.next.next = new ListNode( 5 );
        SwapNodesinPairs2 swapNodesinPairs2 = new SwapNodesinPairs2();
        ListNode result = swapNodesinPairs2.swapPairs( listNode );
        while (result != null) {
            System.out.println( result.val );
            result = result.next;
        }
    }
}
