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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] list=new ListNode[k];
        int size=0;
        ListNode node=head;
        while(node!=null){
            size++;
            node=node.next;
        }
        int q=size/k;
        int r=size%k;
        node=head;
        int ind=0;
        if(size<k || size==k){
            while(k!=0 && node!=null){
                ListNode temp=node;
                node=node.next;
                temp.next=null;
                list[ind]=temp;
                k--;
                ind++;
            }
            //k remains
            if(k!=0){
                while(k!=0){
                    ListNode temp=null;
                    list[ind]=temp;
                    k--;
                    ind++;
                }
            }
            return list;
        }
        while(k!=0 && node!=null){
            ListNode temp=node;
            int n=0;
            int m;
            if(r>0){
                m=1;
            }
            else{
                m=0;
            }
            while(n!=q+m-1 && node!=null){
                node=node.next;
                n++;
            }
            if(node!=null){
                ListNode temp2=node.next;
                node.next=null;
                node=temp2;
            }
            list[ind]=temp;
            ind++;
            k--;
            r--;
        }
        return list;
    }
}