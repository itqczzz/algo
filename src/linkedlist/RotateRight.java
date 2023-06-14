package linkedlist;

import struct.ListNode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0,head);
        int len = 0;
        while (head != null){
            head = head.next;
            len++;
        }
        head = dummy.next;
        //反转前k个节点
        reverse(head,0,k);
        //反转剩下的len-k个节点
        reverse(head,k+1,len);
        //链表整体反转
        reverse(head,0,len);
        return dummy.next;
    }

    public void reverse(ListNode head, int left, int right) {

    }
}
