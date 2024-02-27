package Scanner;

import java.util.Scanner;

public class ScannerWhile3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        while(true) {
            System.out.println("숫자를 입력하세요:");
            int num = input.nextInt();
            if(num==0){
                System.out.println("종료합니다.");
                break;

            }
            sum += num;
        }
        System.out.println("총 합은" +sum
        );
    }
}
