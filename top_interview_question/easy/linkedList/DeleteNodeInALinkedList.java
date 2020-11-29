package top_interview_question.easy.linkedList;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class DeleteNodeInALinkedList {

    /**
     * //刪除3
     * 1->2->'3'->4->5->x
     * 
     * //先複製下一個點
     * 1->2->'4'->4->5->x
     *        |
     *        ------>5
     * 
     * //然後刪除下一個點
     * 1->2->'4'---->5->x
     */
    public void deleteNode(ListNode node) {
        //因為是single linklist, 所以...
        //當要刪除一個點, 因為無法讀取前一個node, 所以先複製下一個點, 然後刪除下一個點
        node.val = node.next.val;
        node.next = node.next.next;
        //刪除下一個點

    }

    public static void main(String[] args) {

        ListNode node2 = new ListNode(2);        
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node2.next = node3;
        node3.next = node4;

        DeleteNodeInALinkedList aa = new DeleteNodeInALinkedList();
        aa.deleteNode(node3);
    

        

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