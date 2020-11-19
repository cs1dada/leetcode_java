package top_interview_question.linkedList;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class DeleteNodeInALinkedList {



    public void deleteNode(ListNode node) {
        System.out.println(node.val);
    }

    public static void main(String[] args) {

        ListNode toDelete = new ListNode(5);

        DeleteNodeInALinkedList aa = new DeleteNodeInALinkedList();
        aa.deleteNode(toDelete);

        

    }
}

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
}