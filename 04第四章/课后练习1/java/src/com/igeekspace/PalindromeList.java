package com.igeekspace;

public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        ListNode fastHead = A;
        ListNode slowHead = A;
        ListNode middleNode = null;

        while (fastHead != null && slowHead != null) {
            middleNode = slowHead;
            slowHead = slowHead.next;
            fastHead = fastHead.next;

            if (fastHead != null) {
                fastHead = fastHead.next;
            }
        }

        //从中点位置开始反转链表
        ListNode tailList = reverseList(middleNode);

        while (A != null && tailList != null) {
            if (A.val != tailList.val) {
                return false;
            }

            A = A.next;
            tailList = tailList.next;
        }
        return true;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode next = head.next;
        if (next == null) {
            return head;
        }

        head.next = null;

        ListNode nextForward = null;
        do {
            nextForward = next.next;
            next.next = head;
            head = next;
            next = nextForward;
        } while (nextForward != null);

        return head;
    }
}