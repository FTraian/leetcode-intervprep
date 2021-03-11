package fb.best_time_buy_stocks;

public class Solution {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxSplit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > maxSplit) {
                maxSplit = prices[i] - min;
            }
        }
        return maxSplit;
    }

    public int maxProfit_n_squared(int[] prices) {
        int maxSplit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int split = prices[j] - prices[i];
                if (split > maxSplit) {
                    maxSplit = split;
                }
            }
        }
        return maxSplit;
    }
}
