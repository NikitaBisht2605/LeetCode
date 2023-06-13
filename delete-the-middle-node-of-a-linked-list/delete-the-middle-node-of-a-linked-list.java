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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow=head;
        if(slow.next==null){
            head=head.next;
            return head;
        }
        if(slow.next.next==null){
            slow.next=null;
            return head;
        }
        ListNode fast=slow.next.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(slow.next!=null){
            slow.next=slow.next.next;
        }
        return head;
    }
}