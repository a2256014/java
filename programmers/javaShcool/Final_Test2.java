import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class Final_Test2 {
    public static void main(String[] args) {
        String[] result = solution(new String[]{"A", "E", "B", "D", "B", "H", "F", "H", "C"}, new String[]{"G", "C", "G", "F", "J", "E", "B", "F", "B"}, "G");
        System.out.println(result);
    }

    static String[] solution(String[] s1, String[] s2, String k) {
        Map<String, Set<String>> preCourseMap = preparePreCourse(s1, s2, k);
        Queue<String> que = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (isPreCourse(preCourseMap, o1, o2)) {
                    return 1;
                }

                return o2.compareTo(o1);
            }
        });

        List<String> answer = new ArrayList<>();
        que.add(k);
        while (!que.isEmpty()) {
            String temp = que.poll();
            answer.add(temp);
            if (preCourseMap.containsKey(temp)) {
                for (String course : preCourseMap.get(temp)) {
                    que.add(course);
                }
            }
            System.out.println(que);
        }
        System.out.println(answer);
        return null;
    }

    static Map<String, Set<String>> preparePreCourse(String[] s1, String[] s2, String k) {
        Map<String, Set<String>> preCourseMap = new HashMap<>();
        for (int i = 0; i < s2.length; i++) {
            Set<String> temp = preCourseMap.getOrDefault(s2[i], new HashSet<>());
            temp.add(s1[i]);
            preCourseMap.put(s2[i], temp);
        }

        return preCourseMap;
    }

    static boolean isPreCourse(Map<String, Set<String>> preCourseMap, String a, String b) {
        if (!preCourseMap.containsKey(b)) {
            return false;
        }

        if (preCourseMap.get(b).contains(a)) {
            return true;
        }

        for (String s : preCourseMap.get(b)) {
            if (isPreCourse(preCourseMap, a, s)) {
                return true;
            }
        }

        return false;
    }

    static String[] course(String k, Map<String, Set<String>> preCourse, Set<String> course) {
        course.add(k);
        if (preCourse.containsKey(k)) {
            for (String pre : preCourse.get(k)) {
                course(pre, preCourse, course);
            }
        }
        return course.toArray(new String[course.size()]);
    }

    /*static String[] solution(String[] s1, String[] s2, String k) {
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
    }*/
}