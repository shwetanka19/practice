public class MinCostPath {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        //System.out.println("rows: "+ rows +" Cols: "+cols);

        int [][] dp = new int [rows][cols];

        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (i-1 < 0 && j-1 < 0){
                    dp[i][j] = grid[i][j];
                }else if (i-1 < 0 && j-1 >= 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if(i-1 >= 0 && j-1 < 0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[rows-1][cols-1];
    }

    public static void main(String [] args){
        MinCostPath minCostPath = new MinCostPath();

        int [][] arr = new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 3;
        arr[0][2] = 1;
        arr[1][0] = 1;
        arr[1][1] = 5;
        arr[1][2] = 1;
        arr[2][0] = 4;
        arr[2][1] = 2;
        arr[2][2] = 1;

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println(minCostPath.minPathSum(arr));
    }
}
