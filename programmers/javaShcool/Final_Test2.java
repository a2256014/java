import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Final_Test2 {
    public static void main(String[] args) {
        String[] result = solution(new String[]{"A", "E", "B", "D", "B", "H", "F", "H", "C"}, new String[]{"G", "C", "G", "F", "J", "E", "B", "F", "B"}, "G");
        System.out.println(result);
    }

    static String[] solution(String[] s1, String[] s2, String k) {
        String[] answer = {};
        String result = "";
        //수강가능한 목록중에서 알파벳 순으로 수강
        HashMap<String, List<String>> beforeMap = new HashMap<>();
        HashMap<String, List<String>> afterMap = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            List<String> beforeValue = beforeMap.getOrDefault(s2[i], new ArrayList<>());
            List<String> afterValue = afterMap.getOrDefault(s1[i], new ArrayList<>());
            beforeValue.add(s1[i]);
            afterValue.add(s2[i]);
            beforeMap.put(s2[i], beforeValue);
            afterMap.put(s1[i], afterValue);
        }
        PriorityQueue<String> queue = new PriorityQueue<>();
        Queue<String> queue1 = new LinkedList<>();

        queue1.add(k);
        while (!queue1.isEmpty()) {
            String cur = queue1.poll();
            List<String> before = beforeMap.getOrDefault(cur, new ArrayList<>());
            if (before.size() == 0) {   //B를 듣기 위해 가장 먼저 들어야 할 것
                AtomicBoolean is = new AtomicBoolean(false);
                queue.forEach(x -> {
                    if (x == cur) is.set(true);
                });
                if (!is.get()) queue.add(cur);
            } else {
                before.forEach(x -> queue1.add(x));
            }
        }

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            result += cur;

            boolean is = true;
            for(String a : beforeMap.get(k)){
                if(result.indexOf(a)==-1) is = false;
            }
            if(is) break;

            List<String> nextList = afterMap.get(cur);

            // 들을 수 있는 지 판단
            for (String next : nextList) {
                boolean yes = true;
                List<String> beforeList = beforeMap.get(next);
                for (String x : beforeList) {
                    if (result.indexOf(x)==-1) yes = false;
                }
                if(yes) queue.add(next);
            }
        }

        result += k;
        answer = result.split("");
        return answer;
    }
}