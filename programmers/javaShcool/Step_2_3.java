import java.util.*;

public class Step_2_3 {
    public static void main(String[] args) {
        int result = solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        System.out.println(result);
    }

    static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i=1; i< triangle.length; i++) {

            dp[i][0] = triangle[i][0] + dp[i - 1][0];

            for (int j=1; j<i+1; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i -1][j - 1], dp[i -1][j]);
            }
        }

        int answer = Arrays.stream(dp[triangle.length-1]).max().orElse(0);
        return answer;
    }

    /*
    static void Move(int[][] triangle, int prevIndex, int depth, int sum) {
        if (depth == triangle.length) {
            answer = Math.max(answer, sum);
            return;
        }
        // 이전 index와 같으면 왼쪽 아래 +1 이면 오른쪽 아래
        Move(triangle, prevIndex, depth + 1, sum + triangle[depth][prevIndex]);
        Move(triangle, prevIndex + 1, depth + 1, sum + triangle[depth][prevIndex]);
    }
    */
    /*
    static int solution(int[][] triangle) {
        Stack<int[]> stack = new Stack<>();
        // depth, index, sum
        stack.add(new int[]{0, 0, 0});

        //깊이 우선 탐색
        while (!stack.isEmpty()) {
            int[] curLocation = stack.pop();
            if (curLocation[0] == triangle.length) {
                answer = Math.max(answer, curLocation[2]);
            } else {
                int depth = curLocation[0];
                int index = curLocation[1];
                int curValue = triangle[depth][index];
                stack.add(new int[]{depth + 1, index, curLocation[2] + curValue});
                stack.add(new int[]{depth + 1, index + 1, curLocation[2] + curValue});
            }
        }
        return answer;
    }
    */
}