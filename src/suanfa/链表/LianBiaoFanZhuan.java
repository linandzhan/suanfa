package suanfa.链表;

public class LianBiaoFanZhuan {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode l1 = new ListNode(20);
        head.next = l1;
        ListNode l2 = new ListNode(15);
        l1.next = l2;
        ListNode l3 = new ListNode(17);
        l2.next = l3;

        ListNode listNode = reverseList(head);
        System.out.println(listNode);
    }


    public static ListNode reverseList(ListNode head) {
        //分为当前节点和上一个节点
        ListNode pre = null;
        ListNode cur = head;
        //只要当前指针不为空，都需要将指针位置进行反转调整
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;  //当前指针，指向上一个节点
            pre = cur;   //上一个节点往后移
            cur = temp;  //当前节点往后移
        }
        return pre;
    }
}
