class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] sum=new int[matrix[0].length];
        int finArea=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0){
                    sum[j]=Character.getNumericValue(matrix[i][j]);
                }
                else{
                    if(matrix[i][j]=='1'){
                        sum[j]=sum[j]+Character.getNumericValue(matrix[i][j]);
                    }
                    else{
                        sum[j]=0;
                    }
                }
            }
            //System.out.println(Arrays.toString(sum));
            int maxArea=findArea(sum);
            //System.out.println(maxArea);
            finArea=Math.max(maxArea,finArea);
        }
        return finArea;
    }
    static int findArea(int[] sum){
        Stack<Integer> s=new Stack<Integer>();
        int[] nsl=new int[sum.length];
        int[] nsr=new int[sum.length];
        for(int i=sum.length-1;i>=0;i--){
            while(!s.isEmpty() && sum[i]<=sum[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=sum.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            s.pop();
        }

        for(int i=0;i<sum.length;i++){
            while(!s.isEmpty() && sum[i]<=sum[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        int ans=0;
        for(int i=0;i<sum.length;i++){
            ans=Math.max(ans,(nsr[i]-nsl[i]-1)*sum[i]);
        }
        return ans;
    }
}