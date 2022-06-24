package samsung;

import java.io.*;
import java.util.*;

import static samsung.Problem2.answer;

public class Problem3 {
    static final String[] MBTI = {"ENFJ", "ENFP", "ENTJ", "ENTP", "ESFJ", "ESFP", "ESTJ", "ESTP", "INFJ", "INFP", "INTJ", "INTP", "ISFJ", "ISFP", "ISTJ", "ISTP"};
    static final Character[] cMBTI = {'E', 'I', 'N', 'S', 'F', 'T', 'P', 'J'};
    static List<Long> costList;
//    static HashMap<String, Long> mbtiMap = new HashMap<>();
    static List<Long> sumCostList;
    //1개 선택했을 때 -> 2개 선택했을 때
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("programmers/samsung/sample3_input.txt")));
        int testCase = Integer.parseInt(br.readLine());

        String format = "#%d %d";
        for (int i = 0; i < testCase; i++) {
            double before = System.currentTimeMillis();
            //초기화
            sumCostList = new ArrayList<>();
            costList = new ArrayList<>();
            int minInclude = Integer.parseInt(br.readLine());
            Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).forEach(x -> costList.add(x));

            boolean[] visit = new boolean[16];
            for (int j = 0; j < MBTI.length - 1; j++) {
                visit[j] = true;
                Check(j, visit, minInclude, costList.get(j), MBTI[j]);
            }
            long answer = Collections.min(sumCostList);

            System.out.format(format, i + 1, answer);
            System.out.println();

            double after = System.currentTimeMillis();
            double time = (after - before) / 1000;
            System.out.println("걸린 시간 : " + time);
        }
    }

    static void Check(int index, boolean[] visit, int min, long cost, String sumMbti) {
        int count = getIncludeCount(sumMbti);
        if (count > min) return;
        if (count == min || index == MBTI.length) {
//            mbtiMap.put(sumMbti, cost);
            sumCostList.add(cost);
            return;
        }
        for (int i = index + 1; i < MBTI.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                Check(i, visit, min, cost + costList.get(i), sumMbti + MBTI[i]);
                visit[i] = false;
            }
        }
        return;
    }

    static int getIncludeCount(String mbti) {
        HashMap<Character, Integer> map = new HashMap<>();
        int min = 9;
        for (char c : cMBTI) {
            map.put(c, 0);
        }
        for (char m : mbti.toCharArray()) {
            map.put(m, map.get(m) + 1);
        }
        for (int n : map.values()) {
            min = Math.min(min, n);
        }
        return min;
    }
}
