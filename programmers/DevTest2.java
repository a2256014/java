import java.util.*;

public class DevTest2 {
    public static void main(String[] args) {
        int[][] result = solution(4, true);
        System.out.println(result);
    }

    static int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];
        answer[0][0] = 1;
        Position position = new Position(0, 0);
        boolean h = horizontal;
        int count = 1;
        for (int size = 2; size <= n; size++) {
            if(h){ //수평
                while (!(position.x == size-1 && position.y ==0)){
                    if(position.y < size-1 && position.x != size -1) position.y++;
                    else if(position.y <= size-1 && position.x == size -1) position.y--;
                    else if(position.y == size -1) position.x++;
                    answer[position.x][position.y] = ++count;
                }
                h = false;
            }else{  //수직
                while (!(position.x == 0 && position.y ==size-1)){
                    if(position.y != size-1 && position.x < size -1) position.x++;
                    else if(position.y == size-1 && position.x <= size -1) position.x--;
                    else if(position.x == size -1) position.y++;
                    answer[position.x][position.y] = ++count;
                }
                h = true;
            }
        }

        return answer;
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