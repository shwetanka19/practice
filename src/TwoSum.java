import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function should return two indices such that lesser index number should be smaller than
 * greater number index
 */
public class TwoSum {
    public static void main(String [] args) {
        int t = 15;
        int inp[] = new int[]{6, 3, 2, 5, 4, 7, 8};
        int res [] = findTwoSumIndices(inp, t);
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    private static int [] findTwoSumIndices(int [] inp, int t) {
        Map<Integer, Integer> diff = new HashMap<>();

        for (int i=0;i<inp.length;i++){
            if (diff.containsKey(inp[i]) && diff.get(inp[i]) < i) {
                return new int[]{diff.get(inp[i]), i};
            }else {
                if (t-inp[i] > inp[i])
                    diff.put(t-inp[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
