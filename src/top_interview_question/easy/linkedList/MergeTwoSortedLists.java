package top_interview_question.easy.linkedList;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class MergeTwoSortedLists {

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

        System.out.print(node.val + " ");

        if (node.next != null) {
            printNode(node.next);
        }

    }

    int listSize(ListNode node) {
        int size = 1;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public ListNode reverseList(ListNode head) {
        // 1 → 2 → 3 → Ø
        // Ø ← 1 ← 2 ← 3.

        // 第一輪的pre 跟 cur
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            // 指往前一個
            cur.next = pre;
            // 下一輪的pre 跟 cur
            pre = cur;
            cur = nextTemp;

        }

        return pre;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val > l2.val) {

            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }

    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //它從頭到尾都只保持在同樣的位置，並指向到第一個節點。
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        while (l1 != null && l2 != null) {
            if(l1.val < l2.val){
                //head/pre -> l1 (prev的next會指定給下一個比較過後較小的那個節點)
                pre.next = l1;
                //l1(x)->l1->... (l1或l2(看哪個比較小)就自己遞移到下一個節點)
                l1 = l1.next;

            } else {
                //head/pre -> l2
                pre.next = l2;
                //l2(x)->l2->...
                l2 = l2.next;
            }
            //prev也往下走到自己的next，準備接取下一個節點
            pre = pre.next;

        }

        //其中一邊節點用光，即可把剩下的直接全接到prev.next上。
        if ( l1 == null){
            pre.next = l2;
        } else {
            pre.next = l1;
        }
        

        return dummy.next;
        
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        MergeTwoSortedLists aa = new MergeTwoSortedLists();
        aa.printNode(node1);
        System.out.println("");
        aa.printNode(node4);
        System.out.println("");
        
        aa.printNode(aa.mergeTwoLists2(node1, node4));

        // aa.deleteNode(node3);
        // aa.printNode(node1);

    }
}

// /**
// * Definition for singly-linked list.
// * */
// class ListNode {
// int val;
// ListNode next;

// public ListNode(int x) {
// this.val = x;
// this.next = null;
// }
// }