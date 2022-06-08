import java.util.Arrays;

public class Mid_Test1 {
    public static void main(String[] args) {
        int result = solution(new int[]{2, 3}, new int[]{1, 2, 3});
        System.out.println(result);
    }

    static int solution(int[] people, int[] tshirts) {
        //한사람당 1개
        //크기가 같거나 큰것만 받음
        int answer = 0;

        Arrays.sort(people);
        Arrays.sort(tshirts);
        int index = 0 ;
        for(int t : tshirts){
            if(index>=people.length) break;
            if(t<people[index]) continue;
            else{
                index++;
                answer++;
            }
        }

        return answer;
    }
}
