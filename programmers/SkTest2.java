import java.util.*;

public class SkTest2 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{20, 23, 24}, new int[][]{{100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}, {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}, {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}}, new int[]{100000, 100000, 100000});
        System.out.println(Arrays.toString(result));
    }

    //가입 기간을 1,2,3으로 설정
    //납부 금액을 1,2,3,4,5로 설정
    static int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = new int[2];
        //60만원 미만은 vip가 될수 없으니 올라가는건 제외
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < periods.length; i++) {
            int curPay = 0;
            int nextPay = estimates[i];
            for (int pay : payments[i]) {
                curPay += pay;
            }
            Customer customer = new Customer(curPay, curPay + nextPay - payments[i][0], periods[i]);
            customers.add(customer);
        }
        for (Customer customer : customers) {
            int curPay = customer.curPayment;
            int allPay = customer.allPayment;
            int curPer = getPeriods(customer.periods);
            int nextPer = getPeriods(customer.periods + 1);

            String curRank = Member[Rank(curPay)][curPer];
            String nextRank = Member[Rank(allPay)][nextPer];

            if (curRank.equals("VIP") && (nextRank.equals("GOLD") || nextRank.equals("SILVER"))) answer[0]++;
            else if ((curRank.equals("SILVER") || curRank.equals("GOLD")) && nextRank.equals("VIP")) answer[1]++;
        }

        return answer;
    }

    static int Rank(int pay) {
        int rank;
        if (pay >= 900000) rank = 0;
        else if (pay >= 600000) rank = 1;
        else if (pay >= 480000) rank = 2;
        else if (pay >= 360000) rank = 3;
        else rank = 4;
        return rank;
    }

    static int getPeriods(int periods) {
        int per;
        if (periods >= 60) per = 2;
        else if (periods >= 24) per = 1;
        else per = 0;
        return per;
    }

    static class Customer {
        int curPayment;
        int allPayment;
        int periods;

        Customer(int curPayment, int allPayment, int periods) {
            this.curPayment = curPayment;
            this.allPayment = allPayment;
            this.periods = periods;
        }
    }

    static String[][] Member = {{"GOLD", "VIP", "VIP"}, {"GOLD", "GOLD", "VIP"}, {"SILVER", "GOLD", "GOLD"}, {"SILVER", "SILVER", "GOLD"}, {"SILVER", "SILVER", "SILVER"}};
}
