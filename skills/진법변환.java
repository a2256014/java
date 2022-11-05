public class 진법변환 {
    public static void main(String[] args) {
        // 10진수 -> n진수
        int number = 17;
        String num = "111";
        System.out.println(Integer.toBinaryString(number));
        System.out.println(Integer.toOctalString(number));
        System.out.println(Integer.toHexString(number));
        System.out.println(Integer.toString(number, 2));

        System.out.println(Integer.parseInt(num, 2));
    }
}
