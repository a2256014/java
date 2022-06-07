import java.util.*;
import java.util.stream.IntStream;
//예산
/*
public class Step_1_3 {
    public static void main(String[] args){
        int result = solution(new int[] {120, 110, 140, 150},485);
        System.out.println(result);
    }
    static int solution(int[] budgets, int M){
        int answer = 0;

        long sum = 0;
        sum = budgetSum(budgets,M);
        if(sum <= M){
            int max = 0;
            for(int budget : budgets){
                if(budget>max) max=budget;
            }
            return max;
        }

        /*
            상한액 = x
            상한액보다 작은 예산 + (상한액*남은 지방) <=M
        * /
        int front = 0;
        int rear = M;
        while(front<=rear){
            long budgetSum=0;
            int upper_max = (front+rear)/2;
            int [] budgetsS = Arrays.stream(budgets).filter(x->x<=upper_max).toArray();
            int [] budgetsU = Arrays.stream(budgets).filter(x->x>upper_max).toArray();
            budgetSum = (int) (budgetSum(budgetsS,upper_max) + budgetsU.length*upper_max);
            if(budgetSum<M) front = upper_max+1;
            else if(budgetSum>M) rear = upper_max-1;
            else return upper_max;
        }
        answer = rear;
        return answer;
    }
    static long budgetSum(int[]budgets, int max){
        long sum = 0;
        for(int budget:budgets){
            if(budget>=max) sum+=max;
            else sum+=budget;
        }
        return sum;
    }
}
*/

/*
import java.util.*;
class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;

        long sum = 0;
        sum = budgetSum(budgets,M);
        if(sum<=M){
            int max =0;
            for(int budget:budgets){
                if(budget>max) max = budget;
            }
            return max;
        }
        /*
            상한액 = x
            상한액보다 작은 예산 + (상한액*남은 지방) <=M
        * /
        int front = 0;
        int rear = M;
        while(front<=rear){
            long budgetSum=0;
            int upper_max = (front+rear)/2;
            budgetSum = budgetSum(budgets,upper_max);

            if(budgetSum<M) front = upper_max+1;
            else if(budgetSum>M) rear = upper_max-1;
            else return upper_max;
        }
        answer = rear;
        return answer;
    }
    static long budgetSum(int[]budgets, int max){
        long sum = 0;
        for(int budget:budgets){
            if(budget>=max) sum+=max;
            else sum+=budget;
        }
        return sum;
    }
}
*/
/*
    궁금한 점
    front와 rear가 지방의 최소 예산과 최대 예산으로 설정 했을 시 테스트케이스 9번 실패(?)

    타입의 중요성
    sum 타입을 int가 아닌 Long으로 해야 효율성 테스트 2번 통과
    Arrays.stream 속도가 느림
    budgetSum을 활용해서 구하니 테스트테이스2번 속도 23ms -> 19ms 빨라짐
*/
//예산
public class Step_1_3 {
    public static void main(String[] args) {
        int result = solution(new int[]{120, 110, 140, 150}, 485);
        System.out.println(result);
    }

    static int solution(int[] budgets, int M) {
        int min = 0;
        int max = IntStream.of(budgets)
                .max()
                .orElse(0);

        int answer = 0;
        while (min <= max) {
            final int mid = (min + max) / 2;

            int sum = IntStream.of(budgets)
                    .map(x -> Math.min(x, mid))
                    .sum();

            if (sum <= M) {
                min = mid + 1;
                answer = mid;
            } else max = mid - 1;
        }
        return answer;
    }
}