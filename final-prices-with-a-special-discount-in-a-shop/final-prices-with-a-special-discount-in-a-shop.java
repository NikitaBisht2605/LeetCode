class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack <Integer> s = new Stack <>();
        int ans[] = new int [n];
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && prices[i] < prices[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i] = prices[i];
            }
            else{
                int min = prices[i]- prices[s.peek()];
                ans[i]= min;
            }
            s.push(i);
        }
        return ans;
    }
}