package top_interview_question.easy.linkedList;

/**
 * Definition for singly-linked list.
 * */
class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int x) { 
        this.val = x; 
        this.next = null;
    }

    public ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}
