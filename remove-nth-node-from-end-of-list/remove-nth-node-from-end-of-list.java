/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1){
            head=head.next;
            return head;
        }
        ListNode node=head;
        int size=0;
        while(node!=null){
            size++;
            node=node.next;
        }
        if(size==n){
            head=head.next;
            return head;
        }
        int ind=size-n-1;
        ListNode newNode=head;
        while(ind!=0){
            ind--;
            newNode=newNode.next;
        }
        newNode.next=newNode.next.next;
        return head;
    }
}