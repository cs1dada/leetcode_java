package top_interview_question.easy.linkedList;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class RemoveNthNodeFromEndofList {

    /**
     * //刪除3 1->2->'3'->4->5->x
     * 
     * //先複製下一個點 1->2->'4'->4->5->x | ------>5
     * 
     * //然後刪除下一個點 1->2->'4'---->5->x
     */
    public void deleteNode(ListNode node) {
        // 因為是single linklist, 所以...
        // 當要刪除一個點, 因為無法讀取前一個node, 所以先複製下一個點, 然後刪除下一個點
        node.val = node.next.val;
        node.next = node.next.next;
        // 刪除下一個點

    }

    void printNode(ListNode node) {

        System.out.print(node.val + " " );
        
        if (node.next!=null){
            printNode(node.next);
        }

    }

    int listSize(ListNode node) {
        int size=1;
        while(node.next!=null){
            size++;
            node = node.next;
        }
        return size;
    }

    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     System.out.println("removeNthFromEnd: " + n + " th");
    //     ListNode dummy = new ListNode(0);
    //     //1. 先找出 list 長度
    //     int sz = listSize(head);
        
    //     // first 指標指到head
    //     ListNode first = head;
    //     // dummy.next 指到head
    //     dummy.next = head;

    //     //2. 找到要刪除的點的前一個位置(倒數第n個位置的前一個), 並且把first指標移過去
    //     int index = sz - n - 1;
    //     while (index > 0) {
    //         first = first.next;
    //         index --;
    //     }

    //     //3. 刪除點
    //     System.out.println("ptr before delNode: "+first.val);
    //     System.out.println("ptr delNode: "+first.next.val);
    //     first.next = first.next.next;

    //     return dummy.next;
    // }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        System.out.println("removeNthFromEnd: " + n + " th");
        
        int sz=1;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //first指到起點
        ListNode first = head;
        //first 用來算長度
        while(first!=null){
            sz++;
            first = first.next;
        }

        //first指到起點
        first = dummy;
        //first 用來找要刪除的點的前一個位置(倒數第n個位置的前一個)
        int index = sz - n - 1;       
        while (index > 0) {
            first = first.next;
            index --;
        }

        //3. 刪除點
        System.out.println("ptr before delNode: "+first.val);
        System.out.println("ptr delNode: "+first.next.val);
        first.next = first.next.next;

        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 1 2 3 4 5 6
        int offset = n + 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        while(offset != 0){
            first = first.next;
            offset--;
        }

        // for (int i = 1; i <= n + 1; i++) {
        //     first = first.next;
        // }

        while(first != null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        RemoveNthNodeFromEndofList aa = new RemoveNthNodeFromEndofList();
        aa.printNode(node1);
        System.out.println("");
        System.out.println("size: "+ aa.listSize(node1));
        //aa.printNode(aa.removeNthFromEnd(node1,2));
        aa.printNode(aa.removeNthFromEnd2(node1,2));
        
        // aa.deleteNode(node3);
        // aa.printNode(node1);


    

        

    }
}

// /**
//  * Definition for singly-linked list.
//  * */
// class ListNode {
//     int val;
//     ListNode next;
    
//     public ListNode(int x) { 
//         this.val = x; 
//         this.next = null;
//     }
// }