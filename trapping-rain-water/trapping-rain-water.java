class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] mbr = new int[n];
        int[] mbl = new int[n];
        
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i <n; i++) {
            int a=0;
            while (!s.isEmpty() && height[i] >= height[s.peek()]) {
                a=s.pop();
            }
            if (s.isEmpty()) mbl[i] = height[i];
            else {
                int maxNum = s.peek();
                s.pop();
                while(!s.isEmpty()){
                    if(height[maxNum]<height[s.peek()]){
                        maxNum=s.peek();
                        s.pop();
                    }
                }
                s.push(maxNum);
                mbl[i]=height[maxNum];
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            s.pop();
        }

        for (int i = n - 1; i >= 0; i--) {
            int a=0;
            while (!s.isEmpty() && height[i] >= height[s.peek()]) {
                a=s.pop();
            }
            if (s.isEmpty()) mbr[i] = height[i];
            else {
                int maxNum = s.peek();
                s.pop();
                while(!s.isEmpty()){
                    if(height[maxNum]<height[s.peek()]){
                        maxNum=s.peek();
                        s.pop();
                    }
                }
                s.push(maxNum);
                mbr[i]=height[maxNum];
            }
            s.push(i);
        }

        //calculate min of both mbl and mbr
        int[] mini=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            mini[i]=Math.min(mbl[i],mbr[i])-height[i];
            sum=sum+mini[i];
        }
        return sum;
    }
}