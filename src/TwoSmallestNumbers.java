public class TwoSmallestNumbers {

    public static void main(String args[]){
        int inp [] = new int[]{10, 15, 5, 7, 8, 20};

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i = 0;i<inp.length;i++){
            if (inp[i]<a){
                b = a;
                a = inp[i];
            }else if (inp[i]<b && inp[i]>a){
                b = inp[i];
            }
        }

        System.out.println(a);
        System.out.println(b);
    }
}
