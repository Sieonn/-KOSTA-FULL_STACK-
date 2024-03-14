package method.ex;

import java.util.Scanner;

public class MethodEx4 {
    public static void main(String[] args) {
        int balance = 0;
        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("------------------------------------------");
//            System.out.println("1. 입금 |2. 출금 |3. 잔액 확인 |4. 종료 ");
//            System.out.println("------------------------------------------");
//            System.out.print("선택: ");
//
//            int balance = 100000;
//            int menu = scanner.nextInt();
//            if (menu == 1) {
//                System.out.print("입금액: ");
//                int a = scanner.nextInt();
//                balance = deposit(a, balance);
//            } else if (menu == 2) {
//                System.out.print("출금액: ");
//                int b = scanner.nextInt();
//                balance = withdraw(b, balance);
//            } else if (menu == 3) {
//                System.out.println("현재 잔액: " + balance);
//            } else if (menu == 4) {
//                System.out.println("시스템을 종료합니다.");
//                break;
//            } else {
//                System.out.println("메뉴를 잘못 선택하셨습니다.");
//                continue;
//            }
//        }
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("1. 입금 |2. 출금 |3. 잔액 확인 |4. 종료 ");
            System.out.println("------------------------------------------");
            System.out.print("선택: ");

            int menu = scanner.nextInt();
            int amount;

            switch (menu) {
                case 1:
                    System.out.print("입금액을 입력하세요.");
                    amount = scanner.nextInt();
                    balance = deposit(balance, amount);
                    break;

                case 2:
                    System.out.print("출금액을 입력하세요.");
                    amount = scanner.nextInt();
                    balance = withdraw(balance,amount);
                    break;
                case 3:
                    System.out.println("현재 잔액: "+ balance+"원");
                    break;
                case 4:
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 선택이 아닙니다. 다시 선택해주세요.");
            }
        }
    }

    public static int deposit(int balance, int amount) {
        balance += amount;
        System.out.println(amount + "원을 입금하셨습니다. 현재 잔액: " + balance + "원");
        return balance;
    }

    public static int withdraw(int balance, int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원을 출금하셨습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println(amount + "원을 출금하려했으나 잔액이 부족합니다.");
        }
        return balance;
    }
}
