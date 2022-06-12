import java.util.*;

public class ArrayCircle {
    public static void main(String[] args) {
        int[] result = solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] board = new int[rows][columns];

        for (int i = 0; i < rows; i++) { //초기화
            for (int j = 0; j < columns; j++) {
                board[i][j] = columns * i + j + 1;
            }
        }

        int count = 0 ;
        for (int[] query : queries) { //[x1,y1,x2,y2]
            query = Arrays.stream(query).map(x -> x - 1).toArray();   //이해하기 편하게
            int x1 = query[1];
            int y1 = query[0];
            int x2 = query[3];
            int y2 = query[2];
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            //  1. y1 => x2 - x1 만큼
            for (int index = x1; index <= x2; index++) {
                queue.add(board[y1][index]);
            }
            //  2. x2 => y2 - y1 -2 만큼
            for (int index = y1+1; index < y2; index++) {
                queue.add(board[index][x2]);
            }
            //  3. y2 => x2 - x1 만큼
            for (int index = x2; index >= x1; index--) {
                queue.add(board[y2][index]);
            }
            //  2. x1 => y2 - y1 -2 만큼
            for (int index = y2-1; index > y1; index--) {
                queue.add(board[index][x1]);
            }
            int min = 5000000;
            for(int q : queue) if(q<min) min=q;
            answer[count++] = min;
            queue.addFirst(queue.pollLast());

            for (int index = x1; index <= x2; index++) {
                board[y1][index] = queue.pollFirst();
            }
            //  2. x2 => y2 - y1 -2 만큼
            for (int index = y1+1; index < y2; index++) {
                board[index][x2] = queue.pollFirst();
            }
            //  3. y2 => x2 - x1 만큼
            for (int index = x2; index >= x1; index--) {
                board[y2][index]=queue.pollFirst();
            }
            //  2. x1 => y2 - y1 -2 만큼
            for (int index = y2-1; index > y1; index--) {
                board[index][x1] =queue.pollFirst();
            }
        }

        return answer;
    }
}