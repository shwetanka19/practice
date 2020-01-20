import java.math.BigInteger;
import java.util.*;

public class TripletProduct {

    public static void main(String[] args){
        List<Integer> tc = new ArrayList<>();
        tc.add(1);
        tc.add(-3);
        tc.add(9);
        tc.add(3);
        tc.add(-9);
        tc.add(1);
        System.out.println(solution(tc, -27));
    }
    public static long solution(List<Integer> capacity, long desired){

        Map<String, BigInteger> pairs = new HashMap<>();

        for(int i=0;i<capacity.size()-1;i++){

            pairs.put(i+"_"+(i+1), BigInteger.valueOf(capacity.get(i)*capacity.get(i+1)));
        }
        long c = 0;
        for(int i=0;i<capacity.size();i++){
            for (Map.Entry<String, BigInteger> e : pairs.entrySet()){

                if (e.getValue().equals(BigInteger.valueOf(desired/capacity.get(i))) &&
                        (!e.getKey().contains(i+"_") || !e.getKey().contains("_"+i))){
                    System.out.println(i+"    " + e.getKey()+"   "+ e.getValue()+ "   "+desired/capacity.get(i));
                    c++;
                }
            }
        }

        return c;
    }
}
