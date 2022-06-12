import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {
        String[] result = solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        System.out.println(Arrays.toString(result));
    }

    //2가지 이상 2명 이상
    static Map<String, Integer> courseMap = new HashMap<>();
    static List<String> answerList = new ArrayList<>();

    static String[] solution(String[] orders, int[] course) {
        // orders를 모두 오름차순으로 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // course수의 모든 조합 구하기
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                String order = orders[j];

                if (course[i] <= order.length()) {
                    boolean[] visited = new boolean[order.length()];
                    combination(order.toCharArray(), 0, course[i], visited);
                }
            }

            // 가장 많이 주문한 단품메뉴 조합 구하기, answer에 넣기
            if (!courseMap.isEmpty()) {
                findPopularCourse();
                courseMap.clear();
            }
        }

        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void combination(char[] order, int start, int r, boolean[] visited) {
        if (r == 0) {
            addCourse(order, visited);
            return;
        }

        for (int i = start; i < order.length; i++) {
            visited[i] = true;
            combination(order, i + 1, r - 1, visited);
            visited[i] = false;
        }
    }

    public static void addCourse(char[] order, boolean[] visited) {
        String course = "";
        for (int i = 0; i < order.length; i++) {
            if (visited[i]) {
                course += order[i];
            }
        }
        courseMap.put(course, courseMap.getOrDefault(course, 0) + 1);
    }

    public static void findPopularCourse() {
        List<Integer> countList = new ArrayList<>(courseMap.values());
        int max = Collections.max(countList);

        if (max >= 2) {
            for (String key : courseMap.keySet()) {
                if (courseMap.get(key) == max) {
                    answerList.add(key);
                }
            }
        }
    }
}
