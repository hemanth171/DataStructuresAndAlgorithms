package com.hemanth.leetcode;

public class StockBuyAndSell {

    public static int maxProfit(int[] prices) {
        int buy_stock = -1;
        int max_profit = 0;
        int counter = 0;
        for (int i=0;i<prices.length;i++) {
            if (i == prices.length-1 && buy_stock > -1) {
                max_profit = max_profit + (prices[i] - buy_stock);
            }
            else if (i < prices.length-1 && prices[i] > prices[i+1] && buy_stock > -1) {
                max_profit = max_profit + (prices[i] - buy_stock);
                buy_stock = -1;
                counter = 0;
            }
            else if (i < prices.length-1 && prices[i] < prices[i+1] && counter == 0) {
                buy_stock = prices[i];
                counter++;
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1};
        System.out.println(maxProfit(arr));
    }
}
