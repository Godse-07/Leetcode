/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node temp;
        while(cur != null){
            temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }
        cur = head;
        
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node dummy = new Node(0);
        Node copyTail = dummy;
        Node copy;

        while (cur != null) {
            copy = cur.next;
            cur.next = copy.next;
            copyTail.next = copy;
            copyTail = copy;
            cur = cur.next;
        }

        return dummy.next;
    }
}