public class ForTest4 {
	public static void main(String[] args) {
		int l =1;
		for(int i=0; i<4; i++) {
			for(int j =0; j<i+1; j++) {
				int k = 97 + i+j;
				System.out.print((char)(k));
			}
			for (int j = 0; j<4-i; j++) {
				System.out.print(l++);
			}
			System.out.println();
		}
	}
}