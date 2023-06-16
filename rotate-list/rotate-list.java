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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null ||head.next==null){
            return head;
        }
        int size=0;
        ListNode node=head;
        while(node!=null){
            size++;
            node=node.next;
        }
        k=k%size;
        while(k!=0){
            ListNode tail=head;
            ListNode temp=null;
            while(tail.next.next!=null){
                tail=tail.next;
            }
            temp=tail.next;
            tail.next=null;
            temp.next=head;
            head=temp;
            k--;
        }
        return head;
    }
}