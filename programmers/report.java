import java.util.*;

public class report {
    public static void main(String[] args){
        int[] result = solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},2);
        System.out.println("result : "+Arrays.toString(result));
    }
    public static int[] solution(String[] id_list, String[] report, int k){
        int[] answer = {};
        System.out.println(Arrays.toString(id_list));
        System.out.println(Arrays.toString(report));
        System.out.println(k);
        String a="aaa";
        String substring = a.substring(1, 3);
        System.out.println(substring);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        System.out.println(arrayList);
        Queue<HashMap<String,Integer>> queue= new PriorityQueue<>();

        return answer;
    }
}

