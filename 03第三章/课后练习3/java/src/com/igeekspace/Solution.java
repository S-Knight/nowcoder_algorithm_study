package com.igeekspace;

import java.util.*;

public class Solution {
    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode end = head;
        ListNode insertNode = end.next;

        while (true) {
            if (insertNode == null) {
                return head;
            }

            ListNode next = insertNode.next;
            head = insertionSortList(head, end, insertNode);
            if (end.next == insertNode) {
                end = insertNode;
            }
            insertNode = next;
        }
    }

    private ListNode insertionSortList(ListNode head, ListNode end, ListNode insertNode) {
        ListNode current = head;
        ListNode preNode = null;

        while (current != null) {
            if (insertNode.val < current.val) {
                end.next = insertNode.next;
                insertNode.next = current;

                if (preNode == null) {
                    head = insertNode;
                } else {
                    preNode.next = insertNode;
                }

                return head;
            }

            if (current == end) {
                break;
            }

            preNode = current;
            current = current.next;
        }

        if (end != null) {
            end.next = insertNode;
        }

        return head;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}