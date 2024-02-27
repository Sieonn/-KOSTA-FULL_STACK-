package Scanner;

import java.util.Scanner;

public class ChangeVarEx {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = 20;
        int b = 10;
        int temp;

        temp = a;
        a = b;
        b = temp;



        System.out.println("a= "+a);
        System.out.println("b= "+b);
    }
}
