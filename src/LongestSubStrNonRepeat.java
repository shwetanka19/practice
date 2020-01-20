import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStrNonRepeat {

    public static void main(String [] args){
        String str = "abcabcdebb";

        int s=0, cs = 0;
        int e=0, ce = 0;
        int max = 0;
        int curMax = 0;
        Set<Character> visited = new HashSet<>();

        for (int i=0;i<str.length();i++){
            if (visited.contains(str.charAt(i))){
                if (curMax>max){
                    max = curMax;
                    s = cs;
                    e = ce-1;
                }
                cs = i;
                ce = i;
                curMax = 0;
                visited.clear();

            }
            visited.add(str.charAt(i));
            ce++;
            curMax++;
        }
        System.out.println("MaxLength, s, e: "+max+", "+s+", "+e+ " String: "+ str.substring(s, e+1));
    }
}
