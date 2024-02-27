package Scanner;

import java.util.Scanner;

public class ScannerEx2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("하나의 정수를 입력하세요:");
        int num = input.nextInt();
        System.out.println("입력한 숫자"+num+"은"+ (num%2==0? "짝수":"홀수")+"입니다.");
    }
}
