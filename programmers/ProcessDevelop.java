import java.util.*;

public class ProcessDevelop {
    public static void main(String[] args) {
        int[] result = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Stack<Integer> waiting = new Stack<>();
        int[] day = new int[progresses.length];
        for (int index = 0; index < progresses.length; index++) {
            int rest = 100 - progresses[index];
            int restDay;

            if (rest % speeds[index] == 0) restDay = rest / speeds[index];
            else restDay = rest / speeds[index] + 1;

            day[index] = restDay;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int pro : day){
            if(waiting.isEmpty()) waiting.add(pro);
            else{
                if(waiting.get(0)>=pro) waiting.add(pro);
                else{
                    list.add(waiting.size());
                    waiting.clear();
                    waiting.add(pro);
                }
            }
        }
        if(!waiting.isEmpty()) list.add(waiting.size());
        answer = list.stream().mapToInt(x->x).toArray();

        return answer;
    }
}