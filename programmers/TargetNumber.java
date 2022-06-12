import java.util.*;

public class TargetNumber {
    public static void main(String[] args){
        int result = solution(new int[] {1, 1, 1, 1, 1},3);
        System.out.println(result);
    }
    static int answer=0;
    static int solution(int[] numbers, int target){
        bfs(numbers,target,0,0);

        return answer;
    }
    static void bfs (int[] numbers,int target,int index,int cur){
        if(index==numbers.length){
            if(cur==target) answer++;
            return;
        }
        bfs(numbers,target,index+1,cur+numbers[index]);
        bfs(numbers,target,index+1,cur-numbers[index]);
    }
}