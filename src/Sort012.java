import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sort012 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for(int i=0;i<tc;i++){
            int s = sc.nextInt();
            String sr = sc.nextLine();

            char [] chars = sr.replace(" ", "").toCharArray();
            Map<String, Integer> counts = new HashMap<>();
            counts.put("0", 0);
            counts.put("1", 0);
            counts.put("2", 0);

            for (int j=0;j<chars.length;j++){
                if (chars[i] == '0'){
                    counts.put("0", counts.get("0")+1);
                }
                if (chars[i] == '1'){
                    counts.put("1", counts.get("1")+1);
                }
                if (chars[i] == '2'){
                    counts.put("2", counts.get("2")+1);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<counts.get("0");j++){
                sb.append("0 ");
                //System.out.print("0 ");
            }
            for (int j=0;j<counts.get("1");j++){
                sb.append("1 ");
                //System.out.print("1 ");
            }
            for (int j=0;j<counts.get("2");j++){
                sb.append("2 ");
                //System.out.print("2 ");
            }
            System.out.println(sb.substring(0, sb.length()-1));
        }
    }
}
