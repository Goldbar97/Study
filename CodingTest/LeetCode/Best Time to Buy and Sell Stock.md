# [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock)
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

---

Example 1:

> Input: prices = [7,1,5,3,6,4]
> 
> Output: 5
> 
> Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
> 
> Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

> Input: prices = [7,6,4,3,1]
> 
> Output: 0
> 
> Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

- 1 <= prices.length <= 105
- 0 <= prices[i] <= 104

## My POV
The most profit comes from selling at the highest price with the lowest price stock.

But when the price is decreasing, it means the lowest price follows after the highest price. Set the current number as the lowest price as far as it's known and subtract from the current price.

Each profit needs to be compared with known max profit to find out which the max profit is.

Through the iteration, the lowest price is set and as the highest price comes, the maximum profit is made and recorded.

## Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            lowestPrice = Math.min(lowestPrice, prices[i]);
            int profit = prices[i] - lowestPrice;
            
            maxProfit = Math.max(maxProfit, profit);
        }
        
        return maxProfit;
    }
}
```
