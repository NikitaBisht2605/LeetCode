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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1=l1;
        ListNode t2=l2;
        int temp=0;
        //ListNode node=head;
        int size1=0;
        int size2=0;

        while(t1!=null){
            size1++;
            t1=t1.next;
        }

        while(t2!=null){
            size2++;
            t2=t2.next;
        }
        t1=l1;
        t2=l2;
        while(t1!=null || t2!=null){
            if(t1==null){
                int a=(temp+t2.val)/10;
                t2.val=(temp+t2.val)%10;
                temp=a;
                t2=t2.next;
            }
            else if(t2==null){
                int a=(temp+t1.val)/10;
                t1.val=(temp+t1.val)%10;
                temp=a;
                t1=t1.next;
            }
            else if(size1>=size2){
                int a=(t1.val+t2.val+temp)/10;
                t1.val=(t1.val+t2.val+temp)%10;
                temp=a;
                t1=t1.next;
                t2=t2.next;
            }
            else if(size1<size2){
                int a=(t1.val+t2.val+temp)/10;
                t2.val=(t1.val+t2.val+temp)%10;
                temp=a;
                t1=t1.next;
                t2=t2.next;
            }
        }
        if(temp!=0){
            ListNode dummy=new ListNode(temp);   
            if(size1>=size2){
                ListNode node=l1;
                while(node.next!=null){
                    node=node.next;                    
                }
                node.next=dummy;
            }
            else{
                ListNode node=l2;
                while(node.next!=null){
                    node=node.next;                    
                }
                node.next=dummy;
            }
        }
        if(size1>=size2){
            return l1;
        }
        return l2;
    }
}