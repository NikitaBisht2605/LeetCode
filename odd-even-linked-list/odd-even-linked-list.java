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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyEven=new ListNode(-1);
        ListNode etail=dummyEven;
        ListNode dummyOdd=new ListNode(-1);
        ListNode otail=dummyOdd;
        ListNode current=head;
        int ind=0;
        while(current!=null){
            if(ind==0 || ind%2==0){
                otail.next=current;
                otail=otail.next;
            }
            else{
                etail.next=current;
                etail=etail.next;
            }
            ind++;
            current=current.next;
        }
        otail.next=dummyEven.next;
        etail.next=null;
        return dummyOdd.next;
    }
}