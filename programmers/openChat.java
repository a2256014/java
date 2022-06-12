import java.util.*;

public class openChat {
    public static void main(String[] args) {
        String[] result = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        System.out.println(Arrays.toString(result));
    }

    static String[] solution(String[] record) {
        String[] answer = {};

        HashMap<String, String> idName = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for (String rec : record) {
            String[] info = rec.split(" ");
            if (info[0].equals("Enter")) idName.put(info[1], info[2]);
            else if (info[0].equals("Change")) idName.replace(info[1], info[2]);
        }
        for (String rec : record) {
            String[] info = rec.split(" ");
            String name = idName.get(info[1]);
            if (info[0].equals("Enter")) result.add(name + "님이 들어왔습니다.");
            else if (info[0].equals("Leave")) result.add(name + "님이 나갔습니다.");
        }

        answer = result.toArray(new String[0]);

        return answer;
    }
}