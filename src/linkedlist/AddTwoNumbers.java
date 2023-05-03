package linkedlist;

import struct.ListNode;

import java.util.Stack;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int prePlus = 0;
        while (l1 != null || l2 != null){
            int value = 0;
            value += l1 == null ? 0 : l1.val;
            value += l2 == null ? 0 : l2.val;
            value += prePlus;
            prePlus = value / 10;
            cur.next = new ListNode(value%10);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(prePlus > 0){
            cur.next = new ListNode(prePlus);
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 创建一个哑节点，它的next指针将指向最终结果链表的头部
        ListNode current = dummyHead; // 当前节点，初始化为哑节点
        int carry = 0; // 用于存储进位

        // 当l1和l2都不为空时，遍历两个链表
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0; // 获取l1当前节点的值，如果l1为空，则值为0
            int y = (l2 != null) ? l2.val : 0; // 获取l2当前节点的值，如果l2为空，则值为0
            int sum = x + y + carry; // 计算当前位的和，包括进位（如果有）

            carry = sum / 10; // 计算进位
            current.next = new ListNode(sum % 10); // 创建一个新节点，值为(sum % 10)，并将其添加到当前节点的后面
            current = current.next; // 移动当前节点到下一个节点

            if (l1 != null) {
                l1 = l1.next; // 移动l1指针到下一个节点
            }
            if (l2 != null) {
                l2 = l2.next; // 移动l2指针到下一个节点
            }
        }

        // 当遍历完两个链表后，如果还有进位，则需要添加一个新的节点
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next; // 返回哑节点的下一个节点，即结果链表的头节点
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{9,9,9,9,9,9,9};
        int[] nums2 = new int[]{9,9,9,9};
        ListNode listNode1 = ListNodeUtils.arrayToList(nums1);
        ListNode listNode2 = ListNodeUtils.arrayToList(nums2);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        while (listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }
}
