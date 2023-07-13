class Solution {
    public int maximumScore(int[] nums, int k) {
        int[] nsl=new int[nums.length];
        int[] nsr=new int[nums.length];
        Stack<Integer> s=new Stack<Integer>();
        for(int n=nums.length-1;n>=0;n--){
            while(s.isEmpty()==false && nums[n]<=nums[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[n]=nums.length;
            }
            else{
                nsr[n]=s.peek();
            }
            s.push(n);
        }
        while(s.isEmpty()==false){
            s.pop();
        }

        for(int n=0;n<nums.length;n++){
            while(s.isEmpty()==false && nums[n]<=nums[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[n]=-1;
            }
            else{
                nsl[n]=s.peek();
            }
            s.push(n);
        }

        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nsl[i]+1<=k && nsr[i]-1>=k){
                ans=Math.max(ans,nums[i]*(nsr[i]-nsl[i]-1));
            }
        }
        return ans;
    }
}