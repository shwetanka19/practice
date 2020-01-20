import java.util.Arrays;

public class GCD {
    public static void main(String args[]){
        Kattio io = new Kattio(System.in, System.out);

       // while (io.hasMoreTokens()){
            int t = io.getInt();

            for (int i=0;i<t;i++){
                int s = io.getInt();
                String eles = io.getWord();

                String [] els = eles.split(" ");
                int a,b; a=b = Integer.MAX_VALUE;
                for (int j=1;j<els.length;j++){
                    if (Integer.parseInt(els[j])<a){
                        b = a;
                        a = Integer.parseInt(els[j]);
                    } else if(Integer.parseInt(els[j]) < b){
                        b = Integer.parseInt(els[j]);
                    }

                }
                Arrays.copyOfRange(els, 0, 2);
                System.out.println("b = "+ String.valueOf(b) +" a = "+String.valueOf(a) );
                int gcd = getGcd(b, a);

                for (int j=0;j<els.length;j++){
                    if (Integer.parseInt(els[j]) % gcd != 0){
                        gcd = 1;
                        break;
                    }
                }
                System.out.println(gcd);
                io.println(gcd);


            }
        //}
    }

    static int getGcd(int a, int b)
    {
        if (b == 0)
            return a;
        return getGcd(b, a % b);
    }
}
