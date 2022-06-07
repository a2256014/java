import java.util.*;

//기지국
/*
public class Step_1_1 {
    public static void main(String[] args) {
        int result = solution(11, new int[]{4, 11}, 1);
        System.out.println(result);
    }

    // n = (wave*2+1)*stations
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int originStation = stations.length;

        if (stations[0] - w - 1 > 1) {
            int count = (stations[0] - w - 1) / (w * 2 + 1);
            int rest = (stations[0] - w - 1) % (w * 2 + 1);
            if (rest > 0) answer += count + 1;
            else answer += count;
        }
        if (stations[stations.length - 1] + w < n - 1) {
            int count = (n - (stations[stations.length - 1] + w) - 1) / (w * 2 + 1);
            int rest = (n - (stations[stations.length - 1] + w) - 1) % (w * 2 + 1);
            if (rest > 0) answer += count + 1;
            else answer += count;
        }
        if (stations.length == 2) {
            int count = ((stations[1] - w) - (stations[0] + w) - 1) / (w * 2 + 1);
            int rest = ((stations[1] - w) - (stations[0] + w) - 1) % (w * 2 + 1);
            if (rest > 0) answer += count + 1;
            else answer += count;
        }
        for (int i = 1; i < stations.length - 1; i++) {
            if (stations[i - 1] + w < stations[i] - w - 1) {
                int count = ((stations[i] - w) - (stations[i - 1] + w) - 1) / (w * 2 + 1);
                int rest = ((stations[i] - w) - (stations[i - 1] + w) - 1) % (w * 2 + 1);
                if (rest > 0) answer += count + 1;
                else answer += count;
            }
            if (stations[i] + w < stations[i + 1] - w - 1) {
                int count = ((stations[i + 1] - w) - (stations[i] + w) - 1) / (w * 2 + 1);
                int rest = ((stations[i + 1] - w) - (stations[i] + w) - 1) % (w * 2 + 1);
                if (rest > 0) answer += count + 1;
                else answer += count;
            }
        }

        return answer;
    }
}
*/
//강사 풀이
//효율성 떨어지면 loop 의심 -> 적절한 데이터 구조 사용 -> object 의심
public class Step_1_1 {
    public static void main(String[] args) {
        int result = solution(11, new int[]{4, 11}, 1);
        System.out.println(result);
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
/*
        Queue<Integer> sq = new LinkedList<>();
        for(int s : stations) sq.offer(s);
*/
        int stationIndex = 0;
        int position = 1;   //아파트 동

        while (position <= n) {
/*
            if(!sq.isEmpty() && sq.peek() - w <= position){
                position = sq.poll() + w + 1;
            }else {
                answer += 1;
                position += 2 * w + 1;
            }
*/
            if (stationIndex < stations.length && stations[stationIndex] - w <= position) {
                position = stations[stationIndex] + w + 1;
                stationIndex++;
            } else {
                answer += 1;
                position += w * 2 + 1;
            }
        }

        return answer;
    }
}