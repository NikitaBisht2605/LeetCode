/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;
        ListNode temp2=headB;
        int size1=0;
        int size2=0;
        while(temp1!=null){
            size1++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            size2++;
            temp2=temp2.next;
        }
        temp1=headA;
        temp2=headB;
        int a=0;
        if(size2>size1){
            a=size2-size1;
            while(a!=0){
                temp2=temp2.next;
                a--;
            }
            while(temp1!=temp2 && temp1!=null && temp2!=null){
                temp1=temp1.next;
                temp2=temp2.next;
            }
            if(temp1==null || temp2==null){
                return null;
            }
            return temp1;
        }
        else{
            a=size1-size2;
            while(a!=0){
                temp1=temp1.next;
                a--;
            }
            while(temp1!=temp2 && temp1!=null && temp2!=null){
                temp1=temp1.next;
                temp2=temp2.next;
            }
            if(temp1==null || temp2==null){
                return null;
            }
            return temp1;
        }
    }
}