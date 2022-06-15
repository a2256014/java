import java.util.*;

public class Step_2_2 {
    public static void main(String[] args) {
        int result = solution(4);
        System.out.println(result);
    }

    static List<String > list = new ArrayList<>();

    static int solution(int n) {
        int answer = 0;

        Make(n, 0, 0, "");
        System.out.println(list);
        return answer;
    }

    static void Make(int n, int left, int right, String string) {
        if (left == n && right == n) {
            list.add(string);
            return;
        }

        // StringBuffer의 append 메소드를 보면 this를 리턴해줌
        if (left == right) Make(n, left + 1, right, string+"(");
        else if (left == n) Make(n, left, right + 1, string+")");
        else {
            Make(n, left + 1, right, string+"(");
            Make(n, left, right + 1, string+")");
        }
    }
}