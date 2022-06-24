package samsung;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2 {
    static long answer = 10001;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("programmers/samsung/sample2_input.txt"));
        int testCase = Integer.parseInt(scanner.nextLine());
        String format = "#%d %d";
        for (int i = 0; i < testCase; i++) {  //테스트 케이스만큼 돌리기
            double before = System.currentTimeMillis();
            //초기화
            answer = 10001;
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int depth = input[0];
            int length = input[1];
            int curX = input[2] - 1;
            int curY = input[3] - 1;

            char[][] map = new char[depth][length];
            HashMap<Character, int[]> xSword = new HashMap<>();
            xSword.put('M', new int[]{curX, curY});
            for (int j = 0; j < depth; j++) {
                String line = scanner.nextLine();
                for (int o = 0; o < line.length(); o++) {
                    char locate = line.charAt(o);
                    map[j][o] = locate;
                    if (locate == 'A' || locate == 'B' || locate == 'C' || locate == 'S')
                        xSword.put(locate, new int[]{j, o});
                }
            }

            // 각 ABC에서 다른 유물을 얻는 곳 까지의 최소 거리 구하기
            //AB AC AS BA BC BS CA CB CS MA MB MC
            String[] Case = new String[]{"AB", "AC", "AS", "BA", "BC", "BS", "CA", "CB", "CS", "MA", "MB", "MC"};
            HashMap<Character, HashMap<Character, Integer>> distance = new HashMap<>();

            for (String c : Case) {
                char[] src = c.toCharArray();
                int[] cur = xSword.get(src[0]);
                int[] target = xSword.get(src[1]);
                boolean is = src[1] == 'S' ? true : false;

                HashMap<Character, Integer> tmp = distance.getOrDefault(src[0], new HashMap<>());
                tmp.put(src[1], BFS(cur, target, depth, length, map, is));
                distance.put(src[0], tmp);
            }

            getMin(distance, new StringBuilder("M"), 0);
            System.out.format(format, i+1, answer);
            System.out.println();

            double after = System.currentTimeMillis();
            double time = (after - before) / 1000;
            System.out.println("걸린 시간 : "+time);
        }
    }

    static void getMin(HashMap<Character, HashMap<Character, Integer>> distance, StringBuilder cur, int count) {
        if (cur.toString().length() == 5) {
            answer = Math.min(answer, count);
            return;
        }

        String load = "ABCS";
        for (char l : load.toCharArray()) {
            if (cur.indexOf(String.valueOf(l)) != -1) continue;
            if (cur.length() < 4 && l == 'S') continue;
            int dis = distance.get(cur.charAt(cur.length()-1)).get(l);

            StringBuilder next = new StringBuilder(cur.toString()+l);
            getMin(distance,next,count+dis);
        }
    }

    static int BFS(int[] curL, int[] target, int depth, int length, char[][] map, boolean xSword) {
        int[][] visit = new int[depth][length];
        int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(curL);
        visit[curL[0]][curL[1]] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == target[0] && cur[1] == target[1]) break;

            for (int i = 0; i < 4; i++) {
                int moveX = cur[0] + direct[i][0];
                int moveY = cur[1] + direct[i][1];
                if (!(0 <= moveX && moveX < depth &&
                        0 <= moveY && moveY < length)) continue;
                if (visit[moveX][moveY] != 0) continue;
                if (!xSword && map[moveX][moveY] == 'X') continue;

                visit[moveX][moveY] = visit[cur[0]][cur[1]] + 1;
                queue.add(new int[]{moveX, moveY});
            }
        }
        return visit[target[0]][target[1]] - 1;
    }
}
