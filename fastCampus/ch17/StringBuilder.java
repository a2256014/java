package ch17;

public class StringBuilder {
    public static void main(String[] args){
        String java = new String("java");
        String android = new String("android");

        java.lang.StringBuilder buffer = new java.lang.StringBuilder(java);
        buffer.append(android);

        String test = buffer.toString();
        System.out.println(test);
    }
}
