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
        Node node1=head;
        Node node2=head;
        while(node1!=null){
            node2=node1.next;
            Node node=new Node(node1.val);
            node1.next=node;
            node.next=node2;
            node1=node2;
            if(node2!=null){
                node2=node2.next;
            }
        }
        Node iter=head;
        while(iter!=null){
            if(iter.random!=null){
                iter.next.random=iter.random.next;
            }
            iter=iter.next.next;
        }
        node1=new Node(0);
        node2=node1;
        iter=head;
        Node fast=null;
        while(iter!=null){
            fast=iter.next.next;
            node2.next=iter.next;
            node2=node2.next;
            iter.next=fast;
            iter=fast;
        }
        return node1.next;
    }
}