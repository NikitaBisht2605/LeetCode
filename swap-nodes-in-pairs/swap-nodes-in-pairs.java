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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp1=head;
        ListNode temp2=temp1.next;
        ListNode node=null;
        while(temp1!=null && temp1.next!=null){
            temp1.next=temp1.next.next;
            temp2.next=temp1;
            if(node!=null){
                node.next=temp2;
            }
            else{
                node=temp2;
                head=node;
            }
            node=temp1;
            temp1=temp1.next;
            if(temp1!=null){
                temp2=temp1.next;
            }
        }
        return head;
    }
}