import java.util.*;
import java.util.stream.Collectors;

public class PhoneNumberList {
    public static void main(String[] args) {
        boolean result = solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(result);
    }

    static boolean solution(String[] phone_book) {
        boolean answer = true;

        phone_book = (String[]) Arrays.stream(phone_book).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()).toArray();

        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[j].startsWith(phone_book[i])){
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}