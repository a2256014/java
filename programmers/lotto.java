import java.util.*;

public class lotto {
    public static void main(String[] args){
        int[] result = solution(new int[] {44, 1, 0, 0, 31, 25},new int[]{31, 10, 45, 1, 6, 19});
        System.out.println(Arrays.toString(result));
    }
    public static int[] solution(int[] lottos,int[] win_nums){
        int[] answer = new int[2];
        int[] rank = {6,6,5,4,3,2,1};
        int zerocount = 0;
        int count = 0;

        for(Integer lotto : lottos){
            if(lotto==0) zerocount++;
            else{
                for(int win : win_nums){
                    if(win==lotto){
                        count++;
                        break;
                    }
                }
            }
        }
        answer[0] = rank[zerocount+count];
        answer[1] = rank[count];
        return answer;
    }
}
