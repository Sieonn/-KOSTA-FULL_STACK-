package array;

import javax.xml.transform.Source;
import java.util.Scanner;

public class ArrayEx9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxprod = 10;
        String[] productNames = new String[maxprod];
        int[] prodcutPric = new int[maxprod];
        int productCount = 0;


        while (true) {
        System.out.print("1. 상품 등록 | 2. 상품 목록 | 3. 종료\n메뉴를 선택하세요:");
            int menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                if (productCount > maxprod) {
                    System.out.println("입력할 수 있는 상품의 개수를 초과했습니다.");
                    continue;
                }
                System.out.print("상품의 이름을 입력하세요:");
                productNames[productCount] = scanner.nextLine();

                System.out.print("상품의 가격을 입력하세요");
                prodcutPric[productCount] = scanner.nextInt();
                productCount++;
            } else if (menu == 2) {
                if (productCount == 0) {
                    System.out.println("등록된 상품이 없습니다.");
                    continue;
                }
                for (int i = 0; i < productCount; i++) {
                    System.out.println(productNames[i] + ":" + prodcutPric[i] + "원");
                }

            } else if (menu == 3) {
                System.out.println("종료됩니다.");
                break;
            } else {
                System.out.println("잘못된 메뉴선택입니다.");

            }

        }
    }
}
