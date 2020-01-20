import java.util.ArrayList;
import java.util.List;

public class RottingOranges {

    public int rotOranges(int [][] grid, int curMin, List<Integer[]> rotten){
        int count = 0;
        for(Integer [] rots : rotten ){
            int i = rots[0];
            int j = rots[1];

            if (i-1 >=0){
                if (grid[i-1][j] == 1){
                    grid[i-1][j] = 2;
                    count++;
                }
            }
            if (j-1>=0){
                if (grid[i][j-1] == 1){
                    grid[i][j-1] = 2;
                    count++;
                }
            }
            if (j+1 < grid[0].length){
                if (grid[i][j+1] == 1){
                    grid[i][j+1] = 2;
                    count++;
                }
            }
            if (i+1 < grid.length){
                if (grid[i+1][j] == 1){
                    grid[i+1][j] = 2;
                    count++;
                }
            }
        }
        if (count>0){
            return curMin+1;
        }else {
            return curMin;
        }
    }

    public int orangesRotting(int[][] grid) {
        int curMin = -1;
        int nextMin = 0;
        while (nextMin>curMin){
            List<Integer[]> rotten = new ArrayList<>();
            for (int i=0;i<grid.length;i++){
                for (int j=0;j<grid[0].length;j++){
                    if (grid[i][j] == 2){
                        rotten.add(new Integer[]{i, j});
                    }
                }
            }
            curMin = nextMin;
            nextMin = rotOranges(grid, nextMin, rotten);
        }
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return nextMin;
    }

    public static void main(String [] args){
        RottingOranges rottingOranges = new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}
