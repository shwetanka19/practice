import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0){
            int s = sc.nextInt();
            int [] cents = new int[s];
            for (int i=0;i<s;i++){
                cents[i] = sc.nextInt();
            }

            int n = sc.nextInt();

            int cc[][] = new int[s][n+1];

            for (int i=0;i<s;i++){
                cc[i][0] = 1;
            }

            for (int i=0;i<s;i++){
                for (int j=1;j<=n;j++){
                    if (i>0){ //Ignoring i=0 as don't make sense. As empty cents
                        //Excluding the coin scenario;
                        cc[i][j] = cc[i-1][j];
                    }
                    if (j >= cents[i]) {
                        cc[i][j] += cc[i][j-cents[i]];
                    }
                }
            }
            System.out.println(cc[s-1][n]);
        }
    }
}
