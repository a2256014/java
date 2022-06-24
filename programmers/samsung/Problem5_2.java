package samsung;

import java.io.*;

import java.math.BigInteger;
import java.util.*;

public class Problem5_2 {
    static BigInteger answer;
    static final int[][] MOVE = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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

            HashMap<String, BigInteger[]> countMap = new HashMap<>();
            for (int j = 0; j < depth; j++) {
                String[] line = bufferedReader.readLine().split("");
                for (int o = 0; o < line.length; o++) {
                    if (line[o].equals("S")) curLocation = new int[]{j, o};
                    map[j][o] = line[o];
                    BigInteger[] tmp = new BigInteger[K];
                    for (int k = 0; k < K; k++) tmp[k] = new BigInteger("0");
                    countMap.put(j + (o + ""), tmp);
                }
            }
            answer = new BigInteger("0");
            //좌표와 각 좌표에 대해서 움직임 개수에 따라 도달할 수 있는 수
            String curLoad = (curLocation[0] + "") + curLocation[1];
            countMap.get(curLoad)[0] = new BigInteger("1");
            //1번 움직였을 때 dp[1]

            for (int move = 1; move < K; move++) {
                for (String load : countMap.keySet()) {   //그 위치에서 갈 수 있는 곳
                    if (countMap.get(load)[move - 1].intValue() == 0) continue;

                    int[] cur = new int[2];
                    cur[0] = Integer.parseInt(load.substring(0, load.length() / 2));
                    cur[1] = Integer.parseInt(load.substring(load.length() / 2));
                    curLoad = (cur[0] + "") + cur[1];
                    for (int j = 0; j < 4; j++) {
                        int nextX = cur[0] + MOVE[j][0];
                        int nextY = cur[1] + MOVE[j][1];
                        String nextLoad = (nextX + "") + nextY;
                        if (nextX < 0 || nextX >= depth || nextY < 0 || nextY >= length) continue;
                        if (map[nextX][nextY].equals("X")) continue;
                        if (!canOut(K - move, new int[]{nextX, nextY}, depth, length)) continue;

                        countMap.get(nextLoad)[move] = countMap.get(curLoad)[move - 1].add(countMap.get(nextLoad)[move]);
                    }
                }
            }
            //겉 부분 조사해서 다 더하기
            for (int x = 0; x < depth; x++) {
                String leftNode = (x + "") + 0;
                String rightNode = (x + "") + (length - 1);
                BigInteger left = Arrays.stream(countMap.get(leftNode)).reduce(new BigInteger("0"), (acc, cur) -> acc.add(cur));
                BigInteger right = Arrays.stream(countMap.get(rightNode)).reduce(new BigInteger("0"), (acc, cur) -> acc.add(cur));

                answer = answer.add(left.add(right));
            }
            for (int y = 0; y < length; y++) {
                String upNode = 0 + (y + "");
                String downNode = (depth - 1) + (y + "");

                BigInteger up = Arrays.stream(countMap.get(upNode)).reduce(new BigInteger("0"), (acc, cur) -> acc.add(cur));
                BigInteger down = Arrays.stream(countMap.get(downNode)).reduce(new BigInteger("0"), (acc, cur) -> acc.add(cur));

                answer = answer.add(up.add(down));
            }

            answer = answer.remainder(new BigInteger("1000000007"));
            System.out.format(format, i + 1, answer);
            System.out.println();
            double after = System.currentTimeMillis();
            double time = (after - before) / 1000;
            System.out.println("걸린 시간 : " + time);
        }
    }

    static boolean canOut(int k, int[] curLocation, int depth, int length) {
        boolean can = false;
        int nextX = curLocation[0];
        int nextY = curLocation[1];
        for (int x = 0; x < k; x++) {
            curLocation[0]++;
            curLocation[1]++;
            if (curLocation[0] >= depth || curLocation[1] >= length) {
                can = true;
                break;
            }
        }
        if (!can) {
            for (int x = 0; x < k; x++) {
                nextX--;
                nextY--;
                if (nextX < 0 || nextY < 0) {
                    can = true;
                    break;
                }
            }
        }

        return can;
    }
}
