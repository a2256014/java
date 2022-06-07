import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//가장 큰수
/*
public class Step_1_2 {
    public static void main(String[] args) {
        String result = solution(new int[]{30, 34, 3, 3, 3, 31, 1, 9});
        System.out.println(result);
    }

    public static String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];
        int index = 0;
        for (int number : numbers) {
            num[index++] = number + "";
        }
        Arrays.sort(num, (o1, o2) -> {
            if (o1.length() == o2.length()) return o2.compareTo(o1);
            else return (o2 + o1).compareTo(o1 + o2);
        });
        System.out.println(Arrays.toString(num));

        for (String n : num) {
            answer = answer.concat(n);
        }
        if (answer.charAt(0) == '0') return "0";
        return answer;
    }
}
*/
//강사풀이
public class Step_1_2 {
    public static void main(String[] args) {
        String result = solution(new int[]{30, 34, 3, 3, 3, 31, 1, 9});
        System.out.println(result);
    }

    public static String solution(int[] numbers) {
        // 숫자 -> 문자 -> 내림차순정렬 -> 조합
        String answer = "";
        answer = IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining());

        if (answer.startsWith("0")) return "0";
        return answer;
    }
}