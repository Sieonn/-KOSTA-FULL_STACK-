
public class OperatorTest {
	public static void main(String[] args) {
		int n1 = 10, n2 =10;
//		int r1, r2 ;
//		r1 = ++n1; //++:자기자신증가 + 결과값을 가지고 있음, 앞에 붙어있으면 증가된
//		//값을 출력합니다.
//		r2 = n2++; // 뒤에 ++은 증가되기 전 값을 출력합니다.
//		System.out.println(r1);
//		System.out.println(r2);
//		System.out.println(n1);
//		System.out.println(n2);
//		
//		int t = n1+n2;
		
		System.out.println(++n1);
		System.out.println(n2++);
		
		int x = 50, y = 30;
		int max = x>y? x: y;
		System.out.println(max);
		
		int i =10;
		i *= 3+5;  //i=i*(3+5);
	}

}
