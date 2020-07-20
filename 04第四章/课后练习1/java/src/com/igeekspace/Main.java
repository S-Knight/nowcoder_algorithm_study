package com.igeekspace;

public class Main {
    private static void printNodeList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
    /*
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;*/

        printNodeList(node1);

        PalindromeList palindromeList = new PalindromeList();
        System.out.println(palindromeList.chkPalindrome(node1));
    }
}
