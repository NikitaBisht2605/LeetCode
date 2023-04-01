class Solution {
    public int maxProfit(int[] prices) {
        int mn=prices[0];
        int max_profit=0;
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-mn;
            max_profit=Math.max(max_profit,cost);
            mn=Math.min(mn,prices[i]);
        }
        return max_profit;
    }
}