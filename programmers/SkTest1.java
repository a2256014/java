import java.util.*;

public class SkTest1 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{2, 5, 3, 1, 4});
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int[] p) {
        int[] answer = new int[p.length];
        int i = 0;
        while (i < p.length) {
            int iValue = p[i];
            int min = p.length + 1;
            int j=0;
            for (int o = i; o < p.length; o++) {
                int nmin = Math.min(min, p[o]);
                if(nmin!=min){
                    min =nmin;
                    j=o;
                }
            }
            if (iValue != min) {
                p[i] = p[j];
                p[j] = iValue;
                answer[i]++;
                answer[j]++;
            }
            i++;
        }
        return answer;
    }
}