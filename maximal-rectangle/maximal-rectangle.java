class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] sum=new int[matrix[0].length];
        int maxRec=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i!=0 && Character.getNumericValue(matrix[i][j])==0 && Character.getNumericValue(matrix[i-1][j])==1){
                    sum[j]=0;
                }
                else{
                    sum[j]=sum[j]+Character.getNumericValue(matrix[i][j]);
                }
            }
            //System.out.println(Arrays.toString(sum));
            int RecArea=MAH(sum);
            //System.out.println(RecArea);
            if(maxRec<RecArea){
                maxRec=RecArea;
            }
        }
        return maxRec;
    }
    static int MAH(int arr[]){
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        int[] nsr = new int[n];
        int[] nsl = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsr[i]=n;
            }
            else{
                nsr[i]=stack.peek();
            }
            stack.push(i);
        }
        //System.out.println(Arrays.toString(nsr));
        while(!stack.isEmpty()){
            stack.pop();
        }

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=stack.peek();
            }
            stack.push(i);
        }
        //System.out.println(Arrays.toString(nsl));

        int maxArea=0;
        for(int i=0;i<n;i++){
            int Area=arr[i]*(nsr[i]-nsl[i]-1);
            //System.out.println(Area);
            if(Area>maxArea){
                maxArea=Area;
            }
        }
        return maxArea;
    }
}