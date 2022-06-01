import java.util.*;

public class report {
    public static void main(String[] args){
        int[] result = solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi","apeach muzi"},2);
        System.out.println("result : "+Arrays.toString(result));
    }
    public static int[] solution(String[] id_list, String[] report, int k){
        int [] answer = new int[id_list.length];
        report = new HashSet<>(Arrays.asList(report)).toArray(new String[0]);
        HashMap<String, Integer> usersId = new HashMap<>();
        HashMap<String,Integer> reportedUsers = new HashMap<>();
        HashMap<String,ArrayList<String>> reportUsers=new HashMap<>();

        for(int index=0;index< id_list.length;index++){
            usersId.put(id_list[index],index);
            reportedUsers.put(id_list[index],0);
            reportUsers.put(id_list[index],new ArrayList<String>());
        }

        for(String re : report){
            String [] user = re.split(" ");
            ArrayList<String> reportList = reportUsers.get(user[0]);
            reportList.add(user[1]);

            reportUsers.put(user[0],reportList);
            reportedUsers.put(user[1],reportedUsers.get(user[1])+1);
        }

        for(String user : id_list){
            for(String reported : reportUsers.get(user)){
                if(reportedUsers.get(reported)>=k){
                    answer[usersId.get(user)]++;
                }
            }
        }

        return Arrays.stream(answer).map(item->item).toArray();
    }
/*
    public static int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        HashMap<String,Integer> suspendedList = new HashMap<>(); //<이름>
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>(); // <이름, 해당 이름의 User 클래스 idx>
        int idx = 0;
        for(String name : id_list) {
            idIdx.put(name,idx++);
            users.add(new User(name));
        }
        for(String re : report){
            String[] str = re.split(" ");
            users.get( idIdx.get(str[0])).reportList.add(str[1]);
            users.get( idIdx.get(str[1])).reportedList.add(str[0]);
        }
        for(User user : users){
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }
        for(User user : users){
            for(String nameReport : user.reportList){
                if(suspendedList.get(nameReport) != null){
                    answer[idIdx.get(user.name)]++;
                }

            }
        }
        return answer;
    }
    static class User{
        String name;
        HashSet<String> reportList;
        HashSet<String> reportedList;
        public User(String name){
            this.name = name;
            reportList = new HashSet<>();
            reportedList = new HashSet<>();
        }
    }
*/
}



