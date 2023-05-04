package linkedlist;

import struct.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //思路，双指针
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                int val = cur.val;
                while (cur != null && cur.val == val){
                    cur = cur.next;
                }
                pre.next = cur;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5};
        ListNode listNode = ListNodeUtils.arrayToList(nums);
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode listNode1 = deleteDuplicates.deleteDuplicates(listNode);
    }
}
