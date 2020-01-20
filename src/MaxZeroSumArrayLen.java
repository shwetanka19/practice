import java.util.HashMap;
import java.util.Map;

public class MaxZeroSumArrayLen {

    public int maxLen(int arr[], int n){
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 0);
        int sum = 0;
        int len = 0;
        for (int i=0;i<arr.length;i++){
            sum += arr[i];

            if (!sums.containsKey(sum)){
                sums.put(sum, i+1);
            }else {
                int curLen = i - sums.get(sum)+1;
                if (curLen>len){
                    len = curLen;
                }
            }
        }
        return len;
    }

    public static void main(String args[]){
        MaxZeroSumArrayLen m = new MaxZeroSumArrayLen();
        System.out.println(m.maxLen(new int[]{1, 2, -5, 1, 2, -1}, 8));
    }
}
