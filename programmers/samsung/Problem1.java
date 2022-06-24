package samsung;

import java.io.*;
import java.util.*;

public class Problem1 {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(new File("programmers/samsung/sample1_input.txt"));
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(scanner.readLine());
        System.out.println(testCase);
        String format = "#%d %d";
        for (int i = 0; i < testCase; i++) {  //테스트 케이스만큼 돌리기
            double before = System.currentTimeMillis();
            //초기화
            long answer = 0;
            int[] input = Arrays.stream(scanner.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int depth = input[0];
            int length = input[1];
            int days = input[2];
            PriorityQueue<int[]> map = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) return o2[0] - o1[0];
                    else return o1[1] - o2[1];
                }
            });

            for (int j = 0; j < depth; j++) {
                int[] mapInfo = Arrays.stream(scanner.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//                StringTokenizer st = new StringTokenizer(scanner.nextLine());
                for (int o = 0; o < length; o++) {
                    map.add(new int[]{mapInfo[o], 0});
                }
            }
            //깍기
                int[] oil = Arrays.stream(scanner.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= days; j++) {
//                StringTokenizer st = new StringTokenizer(scanner.nextLine());
//                int todayOil = Integer.parseInt(st.nextToken());
                int todayOil = oil[j-1];
                int sum = 0;
                for (int o = 0; o < todayOil; o++) {    //오늘 깎을 수 있는 양 만큼
                    int[] target = map.poll();    //제일 긴 잡초
                    sum += target[0] - 1 + j - target[1];         //1만 남기고 짜르기 + 자라난 길이
                    map.add(new int[]{1, j});     //1 다시 넣기 {길이, 짜른 날}
                }
                answer += j * sum;
            }
            System.out.format(format, i + 1, answer);
            System.out.println();

            double after = System.currentTimeMillis();
            double time = (after - before) / 1000;
            System.out.println(time);
        }
    }
}
