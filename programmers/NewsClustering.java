import java.util.*;

public class NewsClustering {
    public static void main(String[] args) {
        int result = solution("ABC", "DEF");
        System.out.println(result);
    }

    static HashMap<String ,Integer> str1List = new HashMap<>();
    static HashMap<String ,Integer> str2List = new HashMap<>();
    static ArrayList<String> Union = new ArrayList<>();
    static ArrayList<String> Intersection = new ArrayList<>();

    static int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Jacquard(str1, str2);

        IntersectionSet();
        UnionSet();

        int inter =0;
        int union = 0;

        for(String intersect : Intersection){
            int str1Count = str1List.getOrDefault(intersect,0);
            int str2Count = str2List.getOrDefault(intersect,0);
            inter += Math.min(str1Count,str2Count)-1;
        }
        for(String u : Union){
            int str1Count = str1List.getOrDefault(u,0);
            int str2Count = str2List.getOrDefault(u,0);
            union += Math.max(str1Count,str2Count)-1;
        }
        System.out.println(str1List.entrySet());
        System.out.println(str2List.entrySet());
        System.out.println(Union);
        System.out.println(Intersection);

        inter = Intersection.size()+inter;
        union = Union.size()+union;

        if(union==0) return 65536;
        answer = 65536*inter/union;
        return answer;
    }

    static void Jacquard(String s1, String s2) {
        for (int i = 0; i < s1.length() - 1; i++) {
            String test = s1.substring(i, i + 2);
            if (test.matches("[a-z]{2}")) {
                str1List.put(test,str1List.getOrDefault(test,0)+1);
            }
        }
        for (int i = 0; i < s2.length() - 1; i++) {
            String test = s2.substring(i, i + 2);
            if (test.matches("[a-z]{2}"))
                str2List.put(test,str2List.getOrDefault(test,0)+1);
        }
    }

    static void IntersectionSet() {
        for (String s : str1List.keySet()) {
            if (str2List.containsKey(s) && !Intersection.contains(s))
                Intersection.add(s);
        }
    }

    static void UnionSet() {
        Union.addAll(str1List.keySet());
        for (String s : str2List.keySet()) {
            if (!Union.contains(s)) Union.add(s);
        }
    }
}
