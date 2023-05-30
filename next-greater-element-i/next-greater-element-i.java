class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            if(stack.isEmpty()){
                findNum(nums2[i],-1,nums1,ans);
                stack.push(nums2[i]);
            }
            else{
                while(!stack.isEmpty()){
                    if(stack.peek()<=nums2[i]){
                        stack.pop();
                    }
                    else{
                        findNum(nums2[i],stack.peek(),nums1,ans);
                        stack.push(nums2[i]);
                        break;
                    }
                }
                if(stack.isEmpty()){
                    findNum(nums2[i],-1,nums1,ans);
                    stack.push(nums2[i]);
                }
                
            }
        }
        return ans;
    }
    static void findNum(int a, int b,int[] nums1,int[] ans){
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]==a){
                ans[i]=b;
                return;
            }
        }
    }
}