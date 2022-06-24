package samsung;

import java.io.*;
import java.util.*;

public class Problem5 {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("programmers/samsung/sample5_input.txt"));
        int testCase = Integer.parseInt(bufferedReader.readLine());

        String format = "#%d %d";
        for (int i = 0; i < testCase; i++) {
            double before = System.currentTimeMillis();
            //초기화
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int depth = info[0];
            int length = info[1];
            int K = info[2];
            String[][] map = new String[depth][length];
            int[] curLocation = {0, 0};
            for (int j = 0; j < depth; j++) {
                String[] line = bufferedReader.readLine().split("");
                for (int o = 0; o < line.length; o++) {
                    if (line[o].equals("S")) curLocation = new int[]{j, o};
                    map[j][o] = line[o];
                }
            }
            answer = 0;
            // BFS
            Queue<Location> queue = new LinkedList<>();
            HashMap<String, Boolean> visit = new HashMap<>();

            String curLoad = (curLocation[0] + (curLocation[1] + ""));
            queue.add(new Location(new int[]{curLocation[0], curLocation[1]}, curLoad, 0));
            visit.put(curLoad, true);

            while (!queue.isEmpty()) {
                Location cur = queue.poll();
                if (cur.cost >= K) continue;

                for (int j = 0; j < 4; j++) {
                    int nextX = cur.location[0] + MOVE[j][0];
                    int nextY = cur.location[1] + MOVE[j][1];
                    String nextLoad = (cur.load + nextX) + nextY;

                    if (nextX < 0 || nextX >= depth || nextY < 0 || nextY >= length) {   //격자 밖으로 나갔을 때
                        answer = (answer + 1) % 1000000007;
                        continue;
                    }
                    if (!isOut(nextX, nextY, cur.cost + 1, depth, length)) continue;    //남은 횟수만에 나갈 수 있는지
                    if (map[nextX][nextY].equals("X")) continue; //갈수 있는 곳인지 확인
                    if (visit.getOrDefault(nextLoad, false)) continue;    //이동경로가 겹치는지 확인

                    queue.add(new Location(new int[]{nextX, nextY}, nextLoad, cur.cost + 1));
                    visit.put(nextLoad, true);
                }
            }


            System.out.format(format, i + 1, answer);
            System.out.println();
            double after = System.currentTimeMillis();
            double time = (after - before) / 1000;
            System.out.println("걸린 시간 : " + time);
        }
    }

    static boolean isOut(int x, int y, int k, int depth, int length) {
        int tmpX = x;
        int tmpY = y;
        for (int i = 0; i < k; k++) {
            if (tmpX >= depth || tmpY >= length) {
                return true;
            }
            tmpX++;
            tmpY++;
        }
        tmpX = x;
        tmpY = y;
        for (int i = 0; i < k; k++) {
            if (tmpX < 0 || tmpY < 0) {
                return true;
            }
            tmpX--;
            tmpY--;
        }

        return false;
    }

    static class Location {
        int[] location;
        String load;
        int cost;

        Location(int[] location, String load, int cost) {
            this.location = location;
            this.load = load;
            this.cost = cost;
        }
    }

    static final int[][] MOVE = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
}
