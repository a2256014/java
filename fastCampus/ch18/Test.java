package ch18;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) throw new PasswordException("비밀번호를 입력해 주세요");
        else if (password.length() < 5) throw new PasswordException("비밀번호 5자 이상");
        else if (password.matches("[a-zA-Z]+")) throw new PasswordException("숫자나 특수문자 포함 필요");
        this.password = password;
    }

    public static void main(String[] args) {
        ArrayList<TravelCustomer> travelCustomerArrayList = new ArrayList<>();
        travelCustomerArrayList.add(new TravelCustomer("kim", 15));
        travelCustomerArrayList.add(new TravelCustomer("lee", 20));
        travelCustomerArrayList.add(new TravelCustomer("park", 14));
        travelCustomerArrayList.forEach(x -> {
            if (x.age < 15) x.cost = 50;
            else x.cost = 100;
        });
        travelCustomerArrayList.stream().map(x -> x.cost = 500);
        System.out.println(travelCustomerArrayList);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.stream().mapToInt(x -> x + 2);
        System.out.println(arr);

        Test password = new Test();
        try {
            password.setPassword(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }try {
            password.setPassword("abcd");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }try {
            password.setPassword("abcdad");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }try {
            password.setPassword("abcdad1");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(password.getPassword());
    }

}
