import exp.BankError;
import exp.BankException;
import emp.Account;
import emp.SpecialAccount;
import java.util.HashMap;
import java.util.Scanner;

public class Bank {
    Scanner sc = new Scanner(System.in);
    HashMap<String, Account> accs = new HashMap<>();

    int menu() {
        System.out.println("[코스타 은행]");
        System.out.println("0. 종료");
        System.out.println("1. 계좌개설");
        System.out.println("2. 입금");
        System.out.println("3. 출금");
        System.out.println("4. 조회");
        System.out.println("5. 전체계좌조회");
        System.out.print("선택>>");
        int sel = Integer.parseInt(sc.nextInt());
        if (sel < 0 || sel > 6) {
            throw new BankException(BankError.MENU);
        }
        return sel;
    }

    void selMenu() throws BankException {
        System.out.println("[계좌계설]");
        System.out.println("1.일반계좌");
        System.out.println("2.특수계좌");
        System.out.print("선택>>");
        int sel = Integer.parseInt(sc.nextLine());
        switch (sel) {
            case 1:
                makeAccount();
                break;
            case 2:
                makeSpecialAccount();
                break;
            default:
                throw new BankException(BankError.MENU);
        }
    }

    void makeSpecialAccount() throws BankException {
        System.out.println("[특수계좌계설]");
        System.out.print("계좌번호:");
        String id = sc.nextLine();
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("입금액:");
        int money = Integer.parseInt(sc.nextLine());
        System.out.println("등급(VIP, Gold, Sliver, Normal):");
        String grade = sc.nextLine();

        if (accs.containsKey(id)) {
            throw new BankException(BankError.DOUBLE_ID);
        }
        //1, Account 객체 만들기
        //2. 생성된 객체를 accs에 담기
        accs.put(id, new SpecialAccount(id, name, money, grade));
        //accs[cnt++] = new emp.SpecialAccount(id, name, money, grade);
    }

    void makeAccount() throws BankException {
        System.out.println("[계좌계설]");
        System.out.print("계좌번호:");
        String id = sc.nextLine();
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("입금액:");
        int money = Integer.parseInt(sc.nextLine());

        if (accs.containsKey(id)) {
            throw new BankException(BankError.DOUBLE_ID);
        }
        accs.put(id, new Account(id, name, money));
        //1, Account 객체 만들기
        //2. 생성된 객체를 accs에 담기

    }

    void deposit() throws BankException {
        System.out.println("[출금]");
        System.out.println("계좌번호:");
        String id = sc.nextLine();
        System.out.println("입금액: ");
        int money = Integer.parseInt(sc.nextLine());


        if (accs.containsKey(id) == false) {
            throw new BankException(BankError.NO_ID);
        }
        accs.get(id).deposit(money);
        ;
    }


    void withdraw() throws BankException {
        System.out.println("[출금]");
        System.out.println("계좌번호:");
        String id = sc.nextLine();
        System.out.println("출금액: ");
        int money = Integer.parseInt(sc.nextLine());

        if (accs.containsKey(id) == false) {
            throw new BankException(BankError.NO_ID);
        }
        accs.get(id).withdraw(money);
    }

    Account searchAccById(String id) {
        for (int i = 0; i < cnt; i++) {
            if (accs[i].getId().equals(id))
                return accs[i];
        }
        return null;
    }

    void accountInfo() throws BankException {
        System.out.println("[계좌조회]");
        System.out.println("계좌번호:");
        String id = sc.nextLine();
        //1. accs에서 id에 해당하는 Account를 찾는다.

        //2. 찾은 Account의 정보를 출력한다.
        if (accs.containsKey(id) == false) {
            throw new BankException(BankError.NO_ID);
        }
        System.out.println(accs.get(id).info());

    }

    void allAccountInfo() {
        System.out.println("[전체계좌조회]");
        for (Account acc : accs.values())
//            for(int i = 0; i<cnt; i++) {
            System.out.println(acc.info());
    }

}

void transfer() throws BankException {
    System.out.println("[계좌이체]");
    System.out.print("보내는 계좌번호:");
    String sendId = sc.nextLine();
    System.out.println("받는 계좌번호:");
    String recvId = sc.nextLine();
    System.out.println("이체금액");
    int money = Integer.parseInt(sc.nextLine());

    Account sendAcc = searchAccById(sendId);
    if (accs.containsKey(sendAcc) == false) {
        throw new BankException(BankError.NO_SENDID);
    }
    Account recvAcc = searchAccById(recvId);
    if (accs.containsKey(recvAcc) == false) {
        System.out.println("받는 계좌번호 오류입니다.");
        return;
    }
    accs.get(sendAcc).withdraw(money);
    accs.get(recvAcc).deposit(money);
}

public static void main(String[] args) {
    Bank bank = new Bank();
    while (true) {
        try {
            int sel = bank.menu();
            if (sel == 0) break;
            switch (sel) {
                case 1:
                    bank.makeAccount();
                    break;
                case 2:
                    bank.deposit();
                    break;
                case 3:
                    bank.withdraw();
                    break;
                case 4:
                    bank.accountInfo();
                    break;
                case 5:
                    bank.allAccountInfo();
                    break;
                case 5:
                    bank.transfer();
                    break;

            }
            catch(NumberFormatException e){
                System.out.println("입력 형식이 잘못됐습니다.");
            }catch(BankException e){
                System.out.println(e);
            }
        }
    }
}

