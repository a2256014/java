import java.util.*;

public class SkTest3 {
    public static void main(String[] args) {
        int[] result = solution(5, new String[]{"100 1 3", "500 4", "2000 5"}, new String[]{"300 3 5", "1500 1", "100 1 3", "50 1 2"});
        System.out.println(Arrays.toString(result));
    }

    //데이터가 충족 -> 부가서비스 충족
    static int[] solution(int n, String[] plans, String[] clients) {
        int[] answer = new int[clients.length];
        ArrayList<PayRole> payRoles = new ArrayList<>();

        for (String plan : plans) {
            String[] info = plan.split(" ");
            PayRole payRole = new PayRole();
            for (int i = 0; i < info.length; i++) {
                if (i == 0) payRole.setData(Integer.parseInt(info[i]));
                else payRole.setService(info[i]);
            }
            if(payRoles.size()!=0)
                for(String service : payRoles.get(payRoles.size()-1).service) payRole.setService(service);

            payRoles.add(payRole);
        }

        for (int i = 0; i < clients.length; i++) {
            String [] info = clients[i].split(" ");
            int data = Integer.parseInt(info[0]);
            String [] service = new String[info.length-1];
            for(int o = 1;o< info.length;o++){
                service[o-1] = info[o];
            }
            answer[i]=getPay(data,service,payRoles);
        }

        return answer;
    }
    static int getPay(int clientData,String[] clientService, ArrayList<PayRole> payRoles){
        int index=0;
        for(int i =0;i<payRoles.size();i++){
            if(clientData<=payRoles.get(i).data && payRoles.get(i).isContain(clientService)){   //데이터 충족
                index=i+1;
                break;
            }
        }
        return index;
    }
    static class PayRole {
        int  data;
        ArrayList<String > service = new ArrayList<>();

        PayRole() {
        }

        public void setData(int  data) {
            this.data = data;
        }

        public void setService(String  service) {
            this.service.add(service);
        }

        public boolean isContain(String[] clientService){
            boolean result = true;
            for(String cs : clientService){
                if(!this.service.contains(cs)) return false;
            }
            return result;
        }
    }
}