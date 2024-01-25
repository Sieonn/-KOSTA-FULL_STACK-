public class ForTest {
	public static void main(String[] args) {
		int sum = 0;
		int i;
		
		for(i=1; ; i++) {
			sum += i;
			if(sum>=100) break;
		}
		
		System.out.println(sum);
		System.out.println(i);
	}

}
