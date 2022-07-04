import java.util.*;

public class DevTest1 {
    public static void main(String[] args){
        int result = solution(new int[] {3,2,3,6,4,5});
        System.out.println(result);
    }
    static int solution(int [] grade){
        int answer = 0;
        Min min = new Min(101,-1);

        for(int i=0;i< grade.length;i++){
            if(min.position<i){ // 새로운 최소값 찾기
                min = new Min(101,-1);
                for(int j=i; j< grade.length;j++){
                    if(min.grade>grade[j]){
                        min = new Min(grade[j], j);
                    }
                }
            }
            answer += grade[i]- min.grade;
        }

        return answer;
    }
    static class Min{
        int grade;
        int position;
        Min(int grade,int position){
            this.grade = grade;
            this.position = position;
        }
    }
}