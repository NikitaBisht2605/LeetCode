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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead=null;
        ListNode node1=list1;
        ListNode node2=list2;
        if(node1==null && node2==null){
            return node1;
        }
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        if(node1.val>=node2.val){
            newHead=node2;
            node2=node2.next;
        }
        else{
            newHead=node1;
            node1=node1.next;
        }
        ListNode temp=newHead;
        while(node1!=null && node2!=null){
            if(node1.val>=node2.val){
                temp.next=node2;
                temp=node2;
                node2=node2.next;
            }
            else{
                temp.next=node1;
                temp=node1;
                node1=node1.next;
            }
        }
        if(node1==null){
            temp.next=node2;
        }
        else{
            temp.next=node1;
        }
        return newHead;
    }
}