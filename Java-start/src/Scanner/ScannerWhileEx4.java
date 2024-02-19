package Scanner;

import java.util.Scanner;

public class ScannerWhileEx4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sel = 0;
        int price = 0;
        int count = 0;
        int sum=0;
        String name;
        while (true) {
            System.out.println("1: 상품입력, 2: 결제, 3: 프로그램 종료");
            sel = scanner.nextInt();
            if (sel == 1) {
                System.out.print("상품명을 입력하세요.:");
                name = scanner.nextLine();
                scanner.nextLine();

                System.out.print("상품의 가격을 입력하세요:");
                price = scanner.nextInt();
                scanner.nextLine();

                System.out.print("구매 수량을 입력하세요:");
                count = scanner.nextInt();
                sum += price*count;

                System.out.println("상품명" + name + "가격:" + price + "수량:" + count + "합계:" + price*count);
            } else if (sel==2) {
                System.out.print("총 비용:"+sum);

            } else {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            System.out.println();
        }
    }
}
