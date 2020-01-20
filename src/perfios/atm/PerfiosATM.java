package perfios.atm;

import java.util.*;

public class PerfiosATM {
    private Map<Integer, Integer> denominations = new HashMap<>();



    public static void main(String [] args){
        PerfiosATM pATM = new PerfiosATM();
        pATM.denominations.put(2000, 5);
        pATM.denominations.put(500, 5);
        pATM.denominations.put(200, 5);
        pATM.denominations.put(100, 5);


        int [] denom = new int []{2000, 500, 200, 100};
        int [] q = new int[4];

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int curAmount = sc.nextInt();

            int quantity = 0;

            for (int i=0;i<4;i++){
                System.out.println(pATM.denominations.get(denom[i]));
                if (curAmount>= denom[i]){
                    int cur = curAmount/denom[i];

                    if (cur>pATM.denominations.get(denom[i])) {
                        q[i] = pATM.denominations.get(denom[i]);
                    }else {
                        q[i] = cur;
                    }

                    quantity += q[i];

                    if (q[i]>0){
                        curAmount = curAmount - denom[i]*q[i];
                    }

                    if (curAmount == 0){
                        break;
                    }

                }

            }

            if (quantity > 30){
                System.out.println("NA");
            }

            if (curAmount > 0){
                System.out.println("NA");
            }else {
                for (int j=0;j<q.length;j++){
                    pATM.denominations.put(denom[j], pATM.denominations.get(denom[j])- q[j]);
                    System.out.print(q[j] + ", ");
                    q[j] = 0;
                }
            }
        }
    }

}

class Dispenser {

}

class Denomination {
    private int amount;
    private int quantity;

    public Denomination(int amount, int quantity) {
        this.amount = amount;
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}