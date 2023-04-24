package array;

public class MaxProfit {
    /**
     * 动规[7,1,5,3,6,4]
     * 状态转移方程 f(x) = f(x-1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;//最大利润
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
