import java.util.*;

public class Step_2_1 {
    public static void main(String[] args) {
        int result = solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
        System.out.println(result);
    }

//    static int[][] Direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int solution(int[][] maps) {
        int answer = 0;
        int row = maps.length;
        int col = maps[0].length;

        if ((row >= 2 && col >= 2) && (maps[row - 2][col - 1] == 0 && maps[row - 1][col - 2] == 0)) return -1;

        int[][] visited = new int[row][col];
        visited[0][0] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});  //현재 위치 초기화

        while (!queue.isEmpty()) {   //어차피 넓이 우선 탐색이여서 가장 빠른 길이 목적지에 기록 됨
            int[] curLocation = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] nextLocation = new int[2];
                switch (i) {
                    case 0:
                        nextLocation[0] = curLocation[0] + Direct.NORTH[0];
                        nextLocation[1] = curLocation[1] + Direct.NORTH[1];
                        break;
                    case 1:
                        nextLocation[0] = curLocation[0] + Direct.SOUTH[0];
                        nextLocation[1] = curLocation[1] + Direct.SOUTH[1];
                        break;
                    case 2:
                        nextLocation[0] = curLocation[0] + Direct.EAST[0];
                        nextLocation[1] = curLocation[1] + Direct.EAST[1];
                        break;
                    case 3:
                        nextLocation[0] = curLocation[0] + Direct.WEST[0];
                        nextLocation[1] = curLocation[1] + Direct.WEST[1];
                        break;
                }
                if ((0 <= nextLocation[0] && nextLocation[0] < row)
                        && (0 <= nextLocation[1] && nextLocation[1] < col)
                        && visited[nextLocation[0]][nextLocation[1]] == 0
                        && maps[nextLocation[0]][nextLocation[1]] != 0) {
                    visited[nextLocation[0]][nextLocation[1]] = visited[curLocation[0]][curLocation[1]] + 1;
                    queue.add(nextLocation);
                }
            }
        }
        answer = visited[row - 1][col - 1];
        return answer == 0 ? -1 : answer;
    }

    static class Direct {
        final static int[] NORTH = {-1, 0};
        final static int[] SOUTH = {1, 0};
        final static int[] WEST = {0, -1};
        final static int[] EAST = {0, 1};
    }
}