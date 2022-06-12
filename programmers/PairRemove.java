import java.util.*;

public class PairRemove {
    public static void main(String[] args){
        int result = solution("baabaa");
        System.out.println(result);
    }
    static int solution(String s){
        List<String > str = Arrays.asList(s.split(""));

        Stack<String > stack = new Stack<>();
        for(String s1 : str){
            if(stack.isEmpty()) stack.add(s1);
            else{
                if(stack.peek().equals(s1)) stack.pop();
                else stack.add(s1);
            }
        }
        if(!stack.isEmpty()) return 0;
        return 1;
    }
}