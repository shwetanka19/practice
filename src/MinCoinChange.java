public class MinCoinChange {

    public int coinChange(int[] coins, int amount) {
        int [] total = new int[amount+1];

        for (int i=0;i < total.length;i++){
            total[i] = i;
        }

        int [] minCoins = new int[amount+1];
        minCoins[0] = 0;
        for (int i=1;i<minCoins.length;i++){
            minCoins[i] = Integer.MAX_VALUE-1;
        }

        for (int i=0;i<coins.length;i++){
            for (int j=1;j<total.length;j++){
                if (coins[i] <= total[j])

                    minCoins[j] = Math.min(minCoins[j], 1 + minCoins[j-coins[i]]);
            }
        }
        for (int i=0;i<minCoins.length;i++){
            System.out.print(minCoins[i] + " ");
        }
        System.out.println();
        return minCoins[minCoins.length-1]<Integer.MAX_VALUE-1 ? minCoins[minCoins.length-1] : -1;
    }

    public static void main(String ...args){
        MinCoinChange minCoinChange = new MinCoinChange();

        System.out.println(minCoinChange.coinChange(new int[]{2}, 3));
    }
}
