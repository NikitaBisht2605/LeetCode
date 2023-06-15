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
    public ListNode swapNodes(ListNode head, int k) {
        int s=0;
        ListNode node1=head;
        ListNode node2=head;
        int size=0;
        while(node2!=null){
            size++;
            if(k==size){
                node1=node2;
            }
            node2=node2.next;
        }
        node2=head;
        s=size-k;
        while(s!=0){
            s--;
            node2=node2.next;
        }
        int a=node1.val;
        node1.val=node2.val;
        node2.val=a;
        return head;
    }
}