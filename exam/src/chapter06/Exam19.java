package chapter06;

public class Exam19 {
    public static void change(String str) {
        str += "456";
    }

    public static void main(String[] args) {
        String str = "ABC123";
        String str1 = str;
        str+="456";
        String str2 = str;
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));

        System.out.println(str);
        change(str);
        System.out.println("After change:" + str);
    }
}
