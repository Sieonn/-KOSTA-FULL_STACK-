import java.util.Scanner;

public class WhileTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, cnt = 0;
//		while(true) {
//			num = sc.nextInt();
//			if(num==0) break;
//			if(num%3!=0 && num%5!=0) cnt++;
//		}
		do {
			num = sc.nextInt();
			if(num%3!=0 && num%5!=0) cnt++;
		} while(num!=0);
		System.out.println(cnt);
	}
}
