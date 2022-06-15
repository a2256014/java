import java.util.*;

public class Step_2_4 {
    public static void main(String[] args) {
        int result = solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println(result);
    }

    static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (String[] cloth : clothes) {
            ArrayList<String> arrayList = hashMap.getOrDefault(cloth[1], new ArrayList<>());
            arrayList.add(cloth[0]);
            hashMap.put(cloth[1], arrayList);
        }

        for (String key : hashMap.keySet()) {
            answer *= hashMap.get(key).size() + 1;
        }

        return answer - 1;    //다 벗은 경우
    }
}