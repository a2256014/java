import java.util.*;

public class Final_Test1 {
    public static void main(String[] args) {
        int[][] result = solution(3, 4, 2, new int[][]{{3, 2}, {3, 2}, {2, 2}, {3, 2}, {1, 4}, {3, 2}, {2, 3}, {3, 1}});
        System.out.println(result);
    }

    static final int[][] MOVE = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] answer;

    static int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        answer = new int[rows][columns];

        for (int[] query : queries) {
            int row = query[0] - 1;
            int col = query[1] - 1;

            if (answer[row][col] == max_virus) {  //증식
                boolean[][] isMulty = new boolean[rows][columns];

                multy(row, col, isMulty,max_virus);
            } else answer[row][col]++;
        }

        return answer;
    }

    static void multy(int row, int col, boolean[][] isMulty, int max_virus) {
        int depth = answer.length;
        int length = answer[0].length;
        isMulty[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = row + MOVE[i][0];
            int nextY = col + MOVE[i][1];

            if (nextX < 0 || nextX >= depth || nextY < 0 || nextY >= length) continue;
            if(isMulty[nextX][nextY]) continue;
            if(answer[nextX][nextY]==max_virus) {
                multy(nextX,nextY,isMulty,max_virus);
                continue;
            }
            isMulty[nextX][nextY] = true;
            answer[nextX][nextY]++;
        }

    }
}