import java.util.*;

public class idRecommend {
    public static void main(String[] args){
        String result = solution(new String("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(result);
    }
    public static String solution(String new_id){
        String answer = "";

        new_id=new_id.toLowerCase();
        new_id = new_id.replaceAll("[^-_.a-z0-9]","");
        new_id = new_id.replaceAll("[.]{2,}",".");
        new_id = new_id.replaceAll("^[.]|[.]$","");
        if(new_id.length()==0) new_id+="a";
        if(new_id.length()>=16){
            new_id=new_id.substring(0,15);
            new_id = new_id.replaceAll("[.]$","");
        }
        if(new_id.length()<=2){
            char lastC = new_id.charAt(new_id.length()-1);
            while(new_id.length()<3) new_id+=lastC;
        }
        answer = new_id;

        return answer;
    }
}