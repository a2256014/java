import java.util.*;

public class ParenthesisChange {
    public static void main(String[] args) {
        String result = solution("()))((()");
        System.out.println(result);
    }

    static String solution(String p) {
        String answer = "";

        //  1.
        if (p.length() == 0) return "";
        //  2.
        String[] result = split(p);
        String u = result[0];
        String v = result[1];
        //  3.
        if (check(u)) return u += solution(v);
        //  4.
        StringBuilder tmp = new StringBuilder();
        tmp.append('(');
        tmp.append(solution(v));
        tmp.append(')');
        u = u.substring(1, u.length() - 1);
        u = reverse(u);
        tmp.append(u);

        answer = tmp.toString();

        return answer;
    }

    static String reverse(String u) {
        StringBuilder result = new StringBuilder();
        for (Character c : u.toCharArray()) {
            if (c == '(') result.append(')');
            else result.append('(');
        }
        return result.toString();
    }

    static boolean check(String u) {
        int count = 0;
        for (Character c : u.toCharArray()) {
            if(c==')'&&count==0) return false;
            if (c == '(') count++;
            else count--;
        }
        if (count == 0) return true;
        else return false;
    }

    static String[] split(String p) {
        String[] result = new String[2];
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int count = 0;
        boolean rest = false;
        for (Character c : p.toCharArray()) {
            if (!rest) {
                if (c == '(') count++;
                else count--;
                u.append(c);
            } else {
                v.append(c);
            }
            if (count == 0) rest = true;
        }
        result[0] = u.toString();
        result[1] = v.toString();
        return result;
    }
}