package com.igeekspace;

public class Main {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        listNode1.val = 88;

        ListNode listNode2 = new ListNode();
        listNode2.val = 99;
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode();
        listNode3.val = 3;
        listNode2.next = listNode3;

        Solution solution = new Solution();
        solution.printList(solution.insertionSortList(listNode1));
    }
}
