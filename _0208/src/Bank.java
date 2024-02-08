import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import emp.Account;
import emp.SpecialAccount;
import exp.BankError;
import exp.BankException;

public class Bank {
	Scanner sc = new Scanner(System.in);
	Map<String, Account> accs = new HashMap<>();
	
	int menu() throws BankException {
		System.out.println("[코스타 은행]");
		System.out.println("0.종료");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.계좌조회");
		System.out.println("5.전체계좌조회");
		System.out.println("6.계좌이체");
		System.out.print("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel<0 || sel>6) {
			throw new BankException(BankError.MENU);
		}
		return sel;
	}
	
	void selMenu() throws BankException {
		System.out.println("[계좌개설]");
		System.out.println("1.일반계좌");
		System.out.println("2.특수계좌");
		System.out.print("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		switch(sel) {
		case 1: makeAccount(); break;
		case 2: makeSpecialAccount(); break;
		default: throw new BankException(BankError.MENU);
		}
	}
	
	void makeSpecialAccount() throws BankException {
		System.out.println("[특수계좌개설]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("입금액:");
		int money =  Integer.parseInt(sc.nextLine());
		System.out.print("등급(VIP,Gold,Silver,Normal):");
		String grade = sc.nextLine();
		
		if(accs.containsKey(id)) {
			throw new BankException(BankError.DOUBLE_ID);
		}
		accs.put(id, new SpecialAccount(id, name, money, grade));
	}
	
	void makeAccount() throws BankException {
		System.out.println("[일반계좌개설]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("입금액:");
		int money =  Integer.parseInt(sc.nextLine());
		
		if(accs.containsKey(id)) {
			throw new BankException(BankError.DOUBLE_ID);
		}
		accs.put(id, new Account(id,name,money));
	}
	
	void deposit() throws BankException {
		System.out.println("[입금]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("입금액:");
		int money = Integer.parseInt(sc.nextLine());
		if(accs.containsKey(id)==false) {
			throw new BankException(BankError.NO_ID);
		}
		accs.get(id).deposit(money);
	}
	
	void withdraw() throws BankException {
		System.out.println("[출금]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		System.out.print("출금액:");
		int money = Integer.parseInt(sc.nextLine());
		if(accs.containsKey(id)==false) {
			throw new BankException(BankError.NO_ID);
		}	
		accs.get(id).withdraw(money);
	}
	
	void accountInfo() throws BankException {
		System.out.println("[계좌조회]");
		System.out.print("계좌번호:");
		String id = sc.nextLine();
		if(accs.containsKey(id)==false) {
			throw new BankException(BankError.NO_ID);
		}	
		System.out.println(accs.get(id).info());
	}
	
	void allAccountInfo() {
		System.out.println("[전체계좌조회]");
		for(Account acc : accs.values()) {
			System.out.println(acc.info());
		}
	}
	
	void transfer() throws BankException {
		System.out.println("[계좌이체]");
		System.out.print("보내는 계좌번호:");
		String sendId = sc.nextLine();
		System.out.print("받는 계좌번호:");
		String recvId = sc.nextLine();
		System.out.print("이체금액:");
		int money = Integer.parseInt(sc.nextLine());
		
		if(accs.containsKey(sendId)==false) {
			throw new BankException(BankError.NO_SENDID);
		} 
		if(accs.containsKey(recvId)==false) {
			throw new BankException(BankError.NO_RECVID);
		} 
		accs.get(sendId).withdraw(money);
		accs.get(recvId).deposit(money);
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		while(true) {
			try {
				int sel = bank.menu();
				if(sel==0) break;
				switch(sel) {
				case 1: bank.selMenu(); break;
				case 2: bank.deposit(); break;
				case 3: bank.withdraw(); break;
				case 4: bank.accountInfo(); break;
				case 5: bank.allAccountInfo(); break;
				case 6: bank.transfer(); break;
				}
			} catch(NumberFormatException e) {
				System.out.println("입력 형식이 바르지 않습니다");
			} catch(BankException e) {
				System.out.println(e);
			}
		}
	}
}
