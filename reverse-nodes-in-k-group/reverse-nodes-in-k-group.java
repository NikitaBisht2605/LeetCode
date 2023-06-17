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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node=head;
        int size=0;
        ListNode beforeLeft=null;
        //ListNode afterRight=null;
        while(node!=null){
            size++;
            node=node.next;
        }
        int Q=size/k;
        ListNode temp1=head;
        ListNode temp2=head;
        for(int i=0;i<Q;i++){
            for(int j=0;j<k-1;j++){
                temp2=temp2.next;
            }
            if(beforeLeft!=null){
                beforeLeft.next=null;
            }
            node=temp2.next;
            temp2.next=null;
            temp1=reverse(temp1);
            if(beforeLeft!=null){
                beforeLeft.next=temp1;
            }
            else{
                head=temp1;
            }
            while(temp1.next!=null){
                temp1=temp1.next;
            }
            temp1.next=node;
            beforeLeft=temp1;
            temp1=temp1.next;
            temp2=temp1;
        }
        return head;

    }
    static ListNode reverse(ListNode head){
        ListNode newHead=null;
        while(head!=null){
            ListNode node=head.next;
            head.next=newHead;
            newHead=head;
            head=node;
        }
        return newHead;
    }
}