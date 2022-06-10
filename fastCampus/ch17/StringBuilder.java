package ch17;

public class StringBuilder {
    public static void main(String[] args){
        String java = "java";
        String android = "android";

        java.lang.StringBuilder buffer = new java.lang.StringBuilder(java);
        buffer.append(android);

        String test = buffer.toString();
        System.out.println(test);
    }
}
