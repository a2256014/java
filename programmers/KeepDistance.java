import java.util.*;
import java.util.stream.Collectors;

public class KeepDistance {
    public static void main(String[] args) {
        int[] result = solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        System.out.println(Arrays.toString(result));
    }

    //맨헤튼 거리 > 2    (각 좌표의 거리 절대값 합)
    // 거리 1인 경우 무조건 안지킴
    // 거리 2인 경우 파티션 존재유무 확인
    static int[][] DIR = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {2, 0}, {0, 2}, {-2, 0}, {0, -2}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    static boolean[][] visit;
    static List<String[]> map;

    static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);

        for (int i = 0; i < places.length; i++) {
            visit = new boolean[places[0].length][places[0][0].split("").length];
            map = Arrays.stream(places[i]).map(x -> x.split("")).collect(Collectors.toList());
            p:
            for (int x = 0; x < places[0].length; x++) {
                String[] place = places[i][x].split("");
                for (int y = 0; y < place.length; y++) {
                    if (place[y].equals("P")) {   //상하좌우 2칸 대각선 1칸 확인
                        boolean isKeep = find(new int[]{x, y}, places[0].length, place.length);
                        if (!isKeep) {
                            answer[i] = 0;
                            break p;
                        }
                    }
                }
            }
        }

        return answer;
    }

    static boolean find(int[] position, int depth, int length) {
        //1 P발견시 바로 끝
        for (int i = 0; i < 4; i++) {
            int nextX = position[0] + DIR[i][0];
            int nextY = position[1] + DIR[i][1];

            if (nextX < 0 || nextX >= depth || nextY < 0 || nextY >= length) continue;
            if (!map.get(nextX)[nextY].equals("P")) continue;
            return false;
        }
        //1에서 P일경우 리턴을 해서 처리를 했으니 2로 내려올 땐 적어도 1 거리에는 P가 없음
        //2
        for (int i = 4; i < 8; i++) {
            int nextX = position[0] + DIR[i][0];
            int nextY = position[1] + DIR[i][1];

            if (nextX < 0 || nextX >= depth || nextY < 0 || nextY >= length) continue;
            if (!map.get(nextX)[nextY].equals("P")) continue;
            //2거리의 P

            int x = (position[0] + nextX) / 2;
            int y = (position[1] + nextY) / 2;

            if (map.get(x)[y].equals("O")) return false;
        }
        //3 대각선
        for (int i = 8; i < 12; i++) {
            int nextX = position[0] + DIR[i][0];
            int nextY = position[1] + DIR[i][1];

            if (nextX < 0 || nextX >= depth || nextY < 0 || nextY >= length) continue;
            if (!map.get(nextX)[nextY].equals("P")) continue;
            //2거리의 P

            int x = (position[0] + nextX) / 2;
            int y = (position[1] + nextY) / 2;

            if (map.get(x + 1)[y].equals("O")) return false;
            if (map.get(x)[y + 1].equals("O")) return false;
        }
        return true;
    }
}