//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Node newHead=null;
        while(head!=null){
            Node node=head.next;
            head.next=newHead;
            newHead=head;
            head=node;
        }
        Node node2=newHead;
        int temp=(node2.data+1)/10;
        node2.data=(node2.data+1)%10;
        node2=node2.next;
        while(node2!=null){
            //int a=(node2.data+temp+1)/10;
            int a=(node2.data+temp)/10;
            node2.data=(node2.data+temp)%10;
            temp=a;
            node2=node2.next;
        }
        node2=newHead;
        if(temp!=0){
            Node temp2=new Node(temp);
            while(node2.next!=null){
                node2=node2.next;
            }
            node2.next=temp2;
        }
        Node temp3=null;
        while(newHead!=null){
            Node node=newHead.next;
            newHead.next=temp3;
            temp3=newHead;
            newHead=node;
        }
        return temp3;
    }
}
