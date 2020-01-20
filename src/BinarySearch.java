public class BinarySearch {
    public static void main(String [] args){
        int ar [] = new int [] {1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222};
        System.out.println(search(2, ar, 0, ar.length-1));
    }

    private static int search(int n, int [] arr, int s, int e) {
        int m = s + (e-s)/2;
        System.out.println(s+" -- "+e);

        if (e < s){
            return -1;
        }

        if (arr[m] == n){
            return m;
        }else if (arr[m] > n){
            return search(n, arr, s, m-1);
        }else {
            return search(n, arr, m+1, e);
        }
    }
}
