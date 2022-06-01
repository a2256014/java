import java.util.*;

public class Step_1_2 {
    public static void main(String[] args){
        String result = solution(new int[] {30,34,3,3,3,31,1,9});
        System.out.println(result);
    }
    public static String solution(int[] numbers){
        String answer = "";
        String[] num = new String[numbers.length];
        int index=0;
        for(int number : numbers){
            num[index++]=number+"";
        }
        Arrays.sort(num, (o1, o2) -> {
            if(o1.length()==o2.length()) return o2.compareTo(o1);
            else return (o2+o1).compareTo(o1+o2);
        });
        System.out.println(Arrays.toString(num));

        for(String n : num){
            answer = answer.concat(n);
        }
        if(answer.charAt(0)=='0') return "0";
        return answer;
    }
}