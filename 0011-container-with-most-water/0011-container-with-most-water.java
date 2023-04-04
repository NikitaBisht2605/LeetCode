class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max_area=0;
        while(i!=j){
            int A=area(i,j,height);
            max_area=Math.max(A,max_area);
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max_area;
    }
    static int area(int i, int j, int height[]){
        if(height[i]<height[j]){
            return height[i]*(j-i);
        }
        else{
            return height[j]*(j-i);
        }
    }
}