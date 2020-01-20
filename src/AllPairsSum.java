import java.util.*;

public class AllPairsSum {

    public static void main(String [] args){
        List<Integer[]> res = findPairs(new int[]{5,5,1,7,9,2,4,6,8,10,3,12,14,11,13,7, 6, 6}, 12);

        for (Integer[] ar : res){
            System.out.print("("+ar[0]+", "+ar[1]+")  ");
        }
    }


    static List<Integer[]> findPairs(int [] arr, int val){
        List<Integer[]> res = new ArrayList<>();
        if(arr.length < 2) {
            return res;
        }

        Collections.sort(res, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return 0;
            }
        });

        Map<Integer, Set<Integer>> diff = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int d = val-arr[i];
            if(diff.containsKey(d)){
                diff.get(d).add(i);
            }else {
                Set<Integer> tem = new HashSet<>();
                tem.add(i);
                diff.put(d, tem);
            }
        }

        for(int i=0;i<arr.length;i++){
            if(diff.containsKey(arr[i])){
                for(Integer in : diff.get(arr[i])){
                    if (i != in){
                        res.add(new Integer[]{arr[i], arr[in]});
                        break;
                    }
                }
            }
        }
        return res;
    }

}
