package array.ex;

import java.util.Scanner;

public class ArrayEx9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //최대 상품 개수 10개
        int prdmax = 10;
        String[] productNames = new String[prdmax];
        int[] productPrices = new int[prdmax];
        int productCount = 0;

        while (true) {
            System.out.println("1. 상품 등록| 2. 상품 목록| 3. 종료");
            System.out.print("메뉴를 선택하세요");
            int menu = scanner.nextInt();
            if (menu == 1) {
                if (productCount >= prdmax) {
                    System.out.println("입력할 수 있는 개수를 초과했습니다.");
                    continue;
                }
                System.out.print("상품 이름을 입력하세요:");
                productNames[productCount] = scanner.nextLine();

                scanner.nextLine();
                System.out.print("상품 가격을 입력하세요:");
                productPrices[productCount] = scanner.nextInt();

                productCount++;


            } else if (menu == 2) {
                if (productCount == 0) {
                    System.out.println("등록된 상품이 없습니다.");
                    continue;
                }
                for (int i = 0; i < productCount; i++) {
                    System.out.println(productNames[i] + ": " + productPrices[i]);
                }

            } else if (menu==3){
                System.out.println("프로그램을 종료합니다.");
                break;
            }else{
                System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}
