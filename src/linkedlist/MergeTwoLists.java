package linkedlist;

import struct.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null || list2 != null){
            int val1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            int val2 = list2 == null ? Integer.MAX_VALUE : list2.val;
            cur.next = new ListNode(Math.min(val1,val2));
            cur = cur.next;
            if(val1 < val2 && list1 != null){
                list1 = list1.next;
            }else {
                list2 = list2.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,4};
        int[] nums2 = {1,3,4};
        ListNode listNode1 = ListNodeUtils.arrayToList(nums1);
        ListNode listNode2 = ListNodeUtils.arrayToList(nums2);
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTwoLists(listNode1, listNode2);
        while (listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
