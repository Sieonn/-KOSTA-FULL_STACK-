package Scanner;

import java.util.Scanner;

public class ScannerEx5 {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        System.out.print("첫 번째숫자를 입력하세요:");
        int num1 = input.nextInt();
        System.out.print("두 번째 숫자를 입력하세요:");
        int num2 = input.nextInt();
        int temp;
        if(num1>num2){
            temp=num2;
            num2 =num1;
            num1= temp;
        }
        for(int i=num1; i<=num2; i++){
            System.out.print(i);
            if(i!=num2) {
                System.out.print(",");
            }
        }
    }
}
