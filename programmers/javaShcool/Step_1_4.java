import java.util.ArrayList;
import java.util.Arrays;

//숫자게임
/*
public class Step_1_4 {
    public static void main(String[] args){
        int result = solution(new int []{5,1,3,7},new int[] {2,2,6,8});
        System.out.println(result);
    }
    //같으면 승점 x
    //이길수 있는 최솟값을 구하기
    //무조건 진다면 제일 작은 수 넣기
    static int solution(int[] A, int[] B){
        int answer = 0;
        ArrayList<Integer> new_B = new ArrayList<>();
        for(int b : B) new_B.add(b);

        for(int a:A){
            int min;
            ArrayList<Integer> big = new ArrayList<>(new_B.stream().filter(x->x>a).toList());
            if(big.size()==0) min = Min(new_B);
            else{
                 min = Min(big);
                 answer++;
            }
            new_B.remove((Integer) min);
        }
        return answer;
    }
    static int Min(ArrayList<Integer> B){
        int min=1000000000;
        for(int b:B){
            if(min>b) min =b;
        }

        return min;
    }
}
*/
public class Step_1_4 {
    public static void main(String[] args) {
        int result = solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8});
        System.out.println(result);
    }

    static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int Aindex = 0;

        for (int b : B) {
            if (b <= A[Aindex]) continue;
            Aindex++;
        }
        return Aindex;
    }
}