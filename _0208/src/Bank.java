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
		System.out.println("[�ڽ�Ÿ ����]");
		System.out.println("0.����");
		System.out.println("1.���°���");
		System.out.println("2.�Ա�");
		System.out.println("3.���");
		System.out.println("4.������ȸ");
		System.out.println("5.��ü������ȸ");
		System.out.println("6.������ü");
		System.out.print("����>>");
		int sel = Integer.parseInt(sc.nextLine());
		if(sel<0 || sel>6) {
			throw new BankException(BankError.MENU);
		}
		return sel;
	}
	
	void selMenu() throws BankException {
		System.out.println("[���°���]");
		System.out.println("1.�Ϲݰ���");
		System.out.println("2.Ư������");
		System.out.print("����>>");
		int sel = Integer.parseInt(sc.nextLine());
		switch(sel) {
		case 1: makeAccount(); break;
		case 2: makeSpecialAccount(); break;
		default: throw new BankException(BankError.MENU);
		}
	}
	
	void makeSpecialAccount() throws BankException {
		System.out.println("[Ư�����°���]");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.print("�Աݾ�:");
		int money =  Integer.parseInt(sc.nextLine());
		System.out.print("���(VIP,Gold,Silver,Normal):");
		String grade = sc.nextLine();
		
		if(accs.containsKey(id)) {
			throw new BankException(BankError.DOUBLE_ID);
		}
		accs.put(id, new SpecialAccount(id, name, money, grade));
	}
	
	void makeAccount() throws BankException {
		System.out.println("[�Ϲݰ��°���]");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.print("�Աݾ�:");
		int money =  Integer.parseInt(sc.nextLine());
		
		if(accs.containsKey(id)) {
			throw new BankException(BankError.DOUBLE_ID);
		}
		accs.put(id, new Account(id,name,money));
	}
	
	void deposit() throws BankException {
		System.out.println("[�Ա�]");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("�Աݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		if(accs.containsKey(id)==false) {
			throw new BankException(BankError.NO_ID);
		}
		accs.get(id).deposit(money);
	}
	
	void withdraw() throws BankException {
		System.out.println("[���]");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		System.out.print("��ݾ�:");
		int money = Integer.parseInt(sc.nextLine());
		if(accs.containsKey(id)==false) {
			throw new BankException(BankError.NO_ID);
		}	
		accs.get(id).withdraw(money);
	}
	
	void accountInfo() throws BankException {
		System.out.println("[������ȸ]");
		System.out.print("���¹�ȣ:");
		String id = sc.nextLine();
		if(accs.containsKey(id)==false) {
			throw new BankException(BankError.NO_ID);
		}	
		System.out.println(accs.get(id).info());
	}
	
	void allAccountInfo() {
		System.out.println("[��ü������ȸ]");
		for(Account acc : accs.values()) {
			System.out.println(acc.info());
		}
	}
	
	void transfer() throws BankException {
		System.out.println("[������ü]");
		System.out.print("������ ���¹�ȣ:");
		String sendId = sc.nextLine();
		System.out.print("�޴� ���¹�ȣ:");
		String recvId = sc.nextLine();
		System.out.print("��ü�ݾ�:");
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
				System.out.println("�Է� ������ �ٸ��� �ʽ��ϴ�");
			} catch(BankException e) {
				System.out.println(e);
			}
		}
	}
}
