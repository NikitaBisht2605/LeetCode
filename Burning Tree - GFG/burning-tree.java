//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    static void findparent(Node root,Map<Node,Node> parent_map){
        Queue<Node> queue=new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                    parent_map.put(queue.peek().left,queue.peek());
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                    parent_map.put(queue.peek().right,queue.peek());
                }
                queue.poll();
            }
        }
    }
    
    static boolean findTarget(Node root, int start,List<Node> list){
        if(root==null){
            return false;
        }
        if(root.data==start){
            list.add(root);
            return true;
        }
        if(findTarget(root.left,start,list)==true){
            return true;
        }
        if(findTarget(root.right,start,list)==true){
            return true;
        }
        return false;
    }
    
    public static int minTime(Node root, int target) 
    {
        if(root.left==null && root.right==null){
            return 0;
        }
        Map<Node,Node> parent_map=new HashMap<>();
        findparent(root,parent_map);
        Map<Node,Boolean> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<Node>();
        List<Node> list=new LinkedList<Node>();
        findTarget(root,target,list);
        Node temp=list.get(0);
        //System.out.println(temp.data);
        q.offer(temp);
        visited.put(q.peek(),true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            int inf=0;
            for(int i=0;i<size;i++){
                Node current=q.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    q.offer(current.left);
                    visited.put(current.left,true);
                    inf=1;
                }
                if(current.right!=null && visited.get(current.right)==null){
                    q.offer(current.right);
                    visited.put(current.right,true);
                    inf=1;
                }
                if(parent_map.get(current)!=null && visited.get(parent_map.get(current))==null){
                    q.offer(parent_map.get(current));
                    visited.put(parent_map.get(current),true);
                    inf=1;
                }
            } 
            if(inf==1){
                curr_level++;
            }
        }
        return curr_level;
    }
}