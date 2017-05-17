package AddTwoNumber;

/**
 * Created by hjy on 2017/5/17.
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);//定义头结点

        ListNode t =result;

        int sum = 0;

        while(l1!=null || l2!=null){

            sum/=10;//判断是否有进位

            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;//这样的做法会改变了l1所指向的结点
            }

            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            t.next=new ListNode(sum%10);
            t=t.next;
        }

        if(sum/10==1){//如果最后还有进位，则增加一个结点
            t.next=new ListNode(1);
        }

        return result.next;
    }
}
