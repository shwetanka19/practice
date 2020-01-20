import java.util.ArrayList;
import java.util.List;

public class CommonPrefix {

    public static void main(String [] args){
        List<String> inp = new ArrayList<>();
        inp.add("abcabaa");
        System.out.println(commonPrefix(inp).get(0));
    }
    public static List<Integer> commonPrefix(List<String> inputs) {
        List<Integer> res = new ArrayList<>();
        for(String s : inputs){
            int sum = s.length();

            for(int i=1;i<s.length();i++){
                String suf = s.substring(i);

                int cs = findMatchIndex(suf, s, 0, suf.length()-1);
                sum += cs;
            }
            res.add(sum);
        }
        return res;
    }

    public static int findMatchIndex(String s1, String s2, int low, int high){
        int len = s1.length();
        if (s2.length()<s1.length()){
            len = s2.length();
        }
        int mid = low+(high-low)/2;
        int i=low;
        while (i< len && (s1.charAt(i) == s2.charAt(i))){
            i++;
            if (i>mid){
                break;
            }
        }
        if (i==mid){
            return i;
        }
        if (i>mid){
            return findMatchIndex(s1, s2, mid+1, high);
        }else {
            return findMatchIndex(s1, s2, low, mid-1);
        }
    }
}
