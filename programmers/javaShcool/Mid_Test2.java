import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class Mid_Test2 {
    public static void main(String[] args) {
        String[] result = solution(new String[][]{{"09:10", "lee"}}, new String[][]{{"09:00", "kim"}, {"09:05", "bae"}});
        System.out.println(Arrays.toString(result));
    }

    static String[] solution(String[][] booked, String[][] unbooked) {
        String[] answer = new String[booked.length + unbooked.length];
        ArrayList<Customer> customers = new ArrayList<>();
        Stack<Customer> waiting = new Stack<>();

        //초기화 작업
        for (String[] bookedCustomer : booked) {
            customers.add(new Customer(bookedCustomer[0], bookedCustomer[1], true));
        }
        for (String[] unbookedCustomer : unbooked) {
            customers.add(new Customer(unbookedCustomer[0], unbookedCustomer[1], false));
        }

        //시간순 정렬
        customers.sort((x1, x2) -> {
            int[] x1Time = x1.getTime();
            int[] x2Time = x2.getTime();
            if (x1Time[0] == x2Time[0]) {
                return x1Time[1] - x2Time[1];
            } else {
                return x1Time[0] - x2Time[0];
            }
        });

        String curTime = customers.get(0).time;
        int answerIndex = 0;

        while (customers.size() > 0 || !waiting.isEmpty()) {
            int waitingIndex = 0;

            Iterator<Customer> iter = customers.iterator();
            while (iter.hasNext()) {
                Customer customer = iter.next();
                if (compareTime(curTime, customer.time)) {
                    waiting.add(customer);
                    iter.remove();
                }
            }
            if (!waiting.isEmpty()) {
                for (int i = 0; i < waiting.size(); i++) {
                    if (waiting.get(i).booked) {
                        waitingIndex = i;
                        break;
                    }
                }
                answer[answerIndex++] = waiting.get(waitingIndex).name;
                curTime = plusTime(waiting.get(waitingIndex).time, 10);
                waiting.remove(waitingIndex);
            } else {
                curTime = plusTime(curTime, 1);
            }
        }

        return answer;
    }

    static class Customer {
        String time;
        String name;
        boolean booked;

        Customer(String time, String name, boolean booked) {
            this.time = time;
            this.name = name;
            this.booked = booked;
        }

        int[] getTime() {
            String[] time = this.time.split(":");
            int[] returnTime = Arrays.stream(time).mapToInt(Integer::parseInt).toArray();
            return returnTime;
        }
    }

    static boolean compareTime(String curTime, String customerTime) {
        int[] cur = Arrays.stream(curTime.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] customer = Arrays.stream(customerTime.split(":")).mapToInt(Integer::parseInt).toArray();

        if (cur[0] == customer[0]) return cur[1] - customer[1] >= 0;
        else return cur[0] - customer[0] > 0;
    }

    static String plusTime(String customerTime, int time) {
        int[] customer = Arrays.stream(customerTime.split(":")).mapToInt(Integer::parseInt).toArray();
        customer[1] += time;
        if (customer[1] >= 60) {
            customer[1] -= 60;
            customer[0] += 1;
        }
        return customer[0] + ":" + customer[1];
    }
}
