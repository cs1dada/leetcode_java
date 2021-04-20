package top_interview_question.easy.array;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class BestTimetoBuyandSellStockII {
    /*
     * The profit is the sum of sub-profits. Each sub-profit is the difference
     * between selling at day j, and buying at day i (with j > i). The range [i, j]
     * should be chosen so that the sub-profit is maximum:
     * 
     * sub-profit = prices[j] - prices[i] We should choose j that prices[j] is as
     * big as possible, and choose i that prices[i] is as small as possible (of
     * course in their local range).
     */
    public int maxProfit(int[] prices) {
        int i = 0;
        int buy;
        int sell;
        int profit = 0;
        int N = prices.length - 1;
        while (i < N) {
            // i+1 比 i 小 => 移往下一位 => 找到買點
            while (i < N && prices[i + 1] <= prices[i]) {
                i++;
            }
            buy = prices[i];

            // i+1 比 i 大 => 移往下一位 => 找到賣點
            while (i < N && prices[i + 1] > prices[i]) {
                i++;
            }
            sell = prices[i];

            profit += sell - buy;
        }

        return profit;
    }

    public static void main(String[] args) {
        // int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int[] numbers = { 1, 2, 3, 3, 4, 5, 6, 6, 6, 7, 8 };
        int[] numbers2 = { 7, 1, 5, 3, 6, 4 };
        int[] numbers3 = { 3, 2, 5, 8, 1 };
        int[] numbers4 = { 7, 6, 4, 3, 1 };
        BestTimetoBuyandSellStockII aa = new BestTimetoBuyandSellStockII();
        System.out.println(aa.maxProfit(numbers4));
        System.out.println("hello world");
    }
}