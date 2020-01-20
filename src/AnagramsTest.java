import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class AnagramsTest {

    public static void permutations(String input){
        //covert string to char array
        char[] chars = input.toCharArray();

        //create a HashMap
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i <chars.length ; i++) {
            char x = chars[i];
            if(map.containsKey(x)){
                int count = map.get(x);
                count++;
                map.put(x, count);
            }else
                map.put(x, 1);
        }

        int result = factorial(chars.length);
        System.out.println(result);
        //handle duplicates, divide the result by all the counts factorial in the hash map

        Set set = map.keySet();
        Iterator<Character> iterator = set.iterator();
        int fc = 1;
        while (iterator.hasNext()){
            char key = iterator.next();
            int count = map.get(key);
            //divide the result by count
            int factorialCount = factorial(count);
            System.out.println(factorialCount);
            //result = result/factorialCount;
            fc *=factorialCount;
        }
        System.out.println(fc);

        System.out.println("Number of distinct permutations of String: '" + input + "' are: " + result/fc);
    }

    public static int factorial(int num){
        if(num==0)
            return 1;
        int result = 1;
        for (int i = 2; i <=num ; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstuvwxyz";
        permutations(input);
    }

}
