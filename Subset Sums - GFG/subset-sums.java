//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> sum = new ArrayList<Integer>();
        seq(arr,0,list,sum);
        return sum;
    }
    static void seq(ArrayList<Integer> arr,int ind,ArrayList<Integer> list,ArrayList<Integer> sum){
        if(ind>=arr.size()){
            sum.add(addNum(list));
            return;
        }
        list.add(arr.get(ind));
        seq(arr,ind+1,list,sum);
        list.remove(arr.get(ind));
        seq(arr,ind+1,list,sum);
    }
    static int addNum(ArrayList<Integer> list){
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum=sum+list.get(i);
        }
        return sum;
    }
}
