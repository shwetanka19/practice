import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;


public class UniqueAnagrams {

    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        while (io.hasMoreTokens()){
            String str = io.getWord();
            //System.out.println(factorial(26));
            char [] strArray = str.toCharArray();

            Map<Character, Integer> counts = new HashMap<>();

            for (int i=0;i<str.length();i++){
                if (counts.containsKey(strArray[i])){
                    counts.put(strArray[i], counts.get(strArray[i])+1);
                }else {
                    counts.put(strArray[i], 1);
                }
            }
            BigInteger total = BigInteger.ONE;
            for (char c : counts.keySet()){
                total = total.multiply(factorial(counts.get(c)));
            }
            io.println(String.valueOf(factorial(str.length()).divide(total)));
        }
        io.close();
    }

    static BigInteger factorial(Integer n){
        if(n==1)
             return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}