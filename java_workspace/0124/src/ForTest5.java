public class ForTest5 {
	public static void main(String[] args) {
		int cnt = 3;
		char ch = 'A';
		int num = 1;
		for(int i = 0; i<3; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print(num++);
			}
			for(int j=0; j<cnt-i; j++) {
				System.out.print(ch++);
			}
			System.out.println();
		}
	}
}