import exp.BankError;
import exp.BankException;
import emp.Account;
import emp.SpecialAccount;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Bank {
    Scanner sc = new Scanner(System.in);
    HashMap<String, Account> accs = new HashMap<>();

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.loadAccs_txt();
        while (true) {
            try {
                int sel = bank.menu();
                if (sel == 0)
                    bank.storeAccs_txt();
                break;
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

    public void storeAccs() { //계좌목록 파일로 저장
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream("accs.bin");
            dos = new DataOutputStream(fos);
            dos.writeInt(accs.size());
            for (Account acc : accs.values()) {
                if (acc instanceof SpecialAccount) {
                    dos.writeChar('S');
                    dos.writeUTF(((SpecialAccount) acc).getGrade());
                } else {
                    dos.writeChar('N');
                }
                dos.writeUTF(acc.getId());
                dos.writeUTF(acc.getName());
                dos.writeInt(acc.getBalance());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadAccs() { // 계좌 목록 파일로부터 읽어오기
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream("accs.bin");
            dis = new DataInputStream(fis);

            //1. 계좌 갯수 읽어오기
            int size = dis.readInt();
            char accSect;
            String id, name, grade = null;
            int balance;
            //2. 계좌구분 읽어오기(S or N)
            for (int i = 0; i < size; i++) {
                accSect = dis.readChar();
                if (accSect == 'S') {
                    grade = dis.readUTF();
                }
                id = dis.readUTF();
                name = dis.readUTF();
                balance = dis.readInt();

                if (accSect == 'N') {
                    accs.put(id, new Account(id, name, balance));
                } else accs.put(id, new SpecialAccount(id, name, balance, grade));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void storeAccs_txt() {
        //    FileWriter, BufferedWriter, accs.txt
        //    1001, 홍길동, 100000
        //    1002, 김길동, 200000. VIP
        //    1. FileWriter, BufferedWriter 선언과 초기화
        //    2. 파일명으로 FileWriter생성
        //    3. 생성된 FileWriter로 BufferedWriter 생성
        //    4. 계좌의 목록에서 각 계좌를 가져와 각 항목을 , 구분자로 이어 하나의 문자열로 만들기
        //    5. br를 이요하여 4에서 생성한 문자열 저장
        //    6. 라인바꾸기: br.newLine()
        //        7.예외처리 및 br close

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("accs.txt"));
            for (Account acc : accs.values()) {
                String accStr = acc.getId();
                accStr += "," + acc.getBalance();
                if (acc instanceof SpecialAccount) {
                    accStr += "," + ((SpecialAccount) acc).getGrade();
                }
                bw.write(accStr);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadAccs_txt() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("accs.txt"));
            String accStr = null;
            while ((accStr = br.readLine()) != null) {
                String[] cols = accStr.split(",");
                String id = cols[0];
                String name = cols[1];
                int balance = Integer.parseInt(cols[2]);
                if (cols.length == 4) {//특수계좌의 등급
                    String grade = cols[3];
                    accs.put(id, new SpecialAccount(id, name, balance, grade));
                } else {
                    accs.put(id, new Account(id, name, balance));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

