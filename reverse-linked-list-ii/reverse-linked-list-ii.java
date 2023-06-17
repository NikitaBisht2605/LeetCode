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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null){
            return head;
        }
        if(left==right){
            return head;
        }
        int l=1;
        int r=1;
        ListNode dummy=head;
        ListNode beginLeft=null;
        ListNode rightEnd=null;
        ListNode leftNode=null;
        ListNode rightNode=null;
        while(dummy!=null){
            if(l==left-1){
                beginLeft=dummy;
            }
            if(r==right+1){
                rightEnd=dummy;
            }
            if(l==left){
                leftNode=dummy;
            }
            if(r==right){
                rightNode=dummy;
            }
            l++;
            r++;
            dummy=dummy.next;
        }
        if(beginLeft!=null){
            beginLeft.next=null;
        }
        rightNode.next=null;
        ListNode node=null;
        while(leftNode!=null){
            ListNode curr=leftNode.next;
            leftNode.next=node;
            node=leftNode;
            leftNode=curr;
        }
        if(beginLeft!=null){
            beginLeft.next=node;
        }
        else{
            head=node;
        }
        while(node.next!=null){
            node=node.next;
        }
        node.next=rightEnd;
        return head;
    }
}