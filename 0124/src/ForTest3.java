public class ForTest3 {
	public static void main(String[] args) {
		int cnt = 13;	
		for(int i = 0; i < cnt; i++) {
			for(int j = 0; j < cnt-i-1; j++) {	
				System.out.print(' ');
			}
			
			for(int j=0; j<2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
// for (int i = 0; i < 5; i++) {
//		for (int j = 0; j < i+1; j++) {
//			System.out.print("*");
//		}
//		System.out.println();
//			}
//			System.out.println();
//		}
//	}
//}
//* i=0 j<1
//** i=1 j<2
//*** i=2 j<3
//****
//*****

//for (int i = 0; i < 5; i++) {
//for (int j = 0; j < i+1; j++) {
//	System.out.print("*");
//}
//System.out.println(); //라인 바꾸기
