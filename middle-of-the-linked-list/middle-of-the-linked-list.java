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
    public ListNode middleNode(ListNode head) {
        ListNode node1=head;
        ListNode node2=head;
        int len=0;
        if(node1.next==null){
            return head;
        }
        while(node1!=null){
            len++;
            node1=node1.next;
        }
        int cnt=(len/2)-1;
        while(cnt!=0){
            cnt--;
            node2=node2.next;
        }
        head=node2.next;
        return head;
    }
}