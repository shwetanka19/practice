public class Josephus {
    public static void main(String args[]){
        int n = 14;
        int k = 2;

        System.out.println(josephus(n, k));
    }

    static int josephus(int n, int k){
        if (n==1){
            return n;
        }else {
            int pos = josephus(n-1, k)+k-1;
            return pos%n + 1;
        }
    }
}
