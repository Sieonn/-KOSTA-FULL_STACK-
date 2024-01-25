public class LottiExam {
	public static void main(String[] args) {
		int[] ball = new int[45];
		for(int i=0; i <ball.length; i++) {
			ball[i] = i+1;
		}
		//두개의 데이터를 바꾸는것을 스왑한다고 하는데 스왑할때는 같은 자료형에 저장해야한다.
		for (int i = 0; i< 1000; i++) {
			int rand1 = (int) (Math.random() *45);
			int rand2 = (int) (Math.random() *45);
			int temp = ball[rand1];
			ball[rand1] = ball[rand2];
			ball[rand2] = temp;
		}
		for(int i=0; i<6; i++) {
			System.out.print(ball[i]+" ");
		}

			
	}

}
