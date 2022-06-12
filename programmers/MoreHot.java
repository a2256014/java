import java.util.*;

public class MoreHot {
    public static void main(String[] args){
        int result = solution(new int[]{1, 2, 3, 9, 10, 12},7);
        System.out.println(result);
    }
    //가장 맵지 않은 음식의 스코빌 지수 + 두번째*2
    //모든 음식이 k이상
    static int solution(int[] scoville, int K){
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int sco : scoville) heap.add(sco);

        while (heap.peek()<K){
            if(heap.size()==1) return -1;
            int x1 = heap.poll();
            int x2 = heap.poll();
            heap.add(x1+x2*2);
            answer++;
        }

        return answer;
    }
}