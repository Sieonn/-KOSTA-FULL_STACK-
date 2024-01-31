import java.util.Scanner;

public class Bank {
    Scanner sc = new Scanner(System.in);
    Account[] accs = new Account[100];
    int cnt;

    int menu() {
        System.out.println("[코스타 은행]");
        System.out.println("0. 종료");
        System.out.println("1. 계좌개설");
        System.out.println("2. 입금");
        System.out.println("3. 출금");
        System.out.println("4. 조회");
        System.out.println("5. 전체계좌조회");
        System.out.print("선택>>");
        return sc.nextInt();
    }
    void makeAccount() {
        System.out.println("[계좌계설]");
        System.out.print("계좌번호:");
        String id = sc.nextLine();
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("입금액:");
        int money = Integer.parseInt();
        //1, Account 객체 만들기
        //2. 생성된 객체를 accs에 담기

    }
    void deposit() {

    }
    void withdraw() {

    }
    void accountInfo() {
        System.out.println("[계좌조회]");
        System.out.println("계좌번호:");
        String id = sc.nextLine();
        //1. accs에서 id에 해당하는 Account를 찾는다.
        //2. 찾은 Account의 정보를 출력한다.
    }
    void allAccountInfo() {

    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        while (true) {
            int sel = bank.menu();
            if(sel==0) break;
            switch (sel) {
                case 1: bank.makeAccount(); break;
                case 2: bank.deposit(); break;
                case 3: bank.withdraw(); break;
                case 4: bank.accountInfo(); break;
                case 5: bank.allAccountInfo(); break;

            }
        }
    }
}
