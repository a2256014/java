import java.util.*;
//new int[][]{{2, 2}, {2, 3}, {2, 5}, {3, 2}, {3, 4}, {3, 5}, {3, 6}, {4, 3}, {4, 6}, {5, 2}, {5, 5}, {6, 2}, {6, 3}, {6, 4}, {6, 6}, {7, 2}, {7, 6}, {8, 3}, {8, 4}, {8, 5}}
public class DevTest3 {
    public static void main(String[] args) {
        int[] result = solution(5, 6, new int[][]{{2, 2}, {2, 3}, {2, 4}, {3, 2}, {3, 5}, {4, 3}, {4, 4}});
        System.out.println(result);
    }

    static int[][] MOVE = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visit;

    static int[] solution(int rows, int columns, int[][] lands) {
        int[] answer = new int[2];
        int[][] landMap = new int[rows][columns];
        int startRow = rows;
        int startCol = columns;
        int endRow = 0;
        int endCol = 0;
        visit = new boolean[rows][columns];
        for (int[] position : lands) {
            landMap[position[0] - 1][position[1] - 1] = 1;
            startRow = Math.min(position[0] - 1, startRow);
            startCol = Math.min(position[1] - 1, startCol);
            endRow = Math.max(position[0] - 1, endRow);
            endCol = Math.max(position[1] - 1, endCol);
        }

        int minSize = rows * columns;
        int maxSize = 0;
        for (int x = startRow + 1; x < endRow; x++) {
            for (int y = startCol + 1; y < endCol; y++) {
                if (landMap[x][y] != 1 && !visit[x][y]) {
                    int size = find(new Position(x, y), landMap, startRow, startCol, endRow , endCol, 0);
                    if (size == 0) continue;
                    minSize = Math.min(minSize, size);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        answer[0] = minSize;
        answer[1] = maxSize;
        if(answer[0] == rows * columns || answer[1] == 0){
            answer[0] = -1;
            answer[1] = -1;
        }

        return answer;
    }

    //알 수 있는 바다 -> 가장 끝과 육지가 시작하는 부분에서의 육지가 아닌 곳
    static int find(Position position, int[][] map, int startRow, int startCol,int endRow, int endCol, int size) {
        Stack<Position> stack = new Stack<>();
        stack.add(position);
        visit[position.x][position.y] = true;
        while (!stack.isEmpty()) {
            Position p = stack.pop();
            size++;
            for (int i = 0; i < 4; i++) {
                int mx = p.x + MOVE[i][0];
                int my = p.y + MOVE[i][1];

                if (mx < 0 || mx >= map.length || my < 0 || my >= map[0].length) continue;
                if (visit[mx][my]) continue;    //이미 방문한 곳
                if (map[mx][my] == 1) continue; //육지
                if (mx <= startRow || my <= startCol) return 0; //바다와 만나면 바다임
                if (mx >= endRow || my >= endCol) return 0;

                visit[mx][my] = true;
                stack.add(new Position(mx, my));
            }
        }
        return size;
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}