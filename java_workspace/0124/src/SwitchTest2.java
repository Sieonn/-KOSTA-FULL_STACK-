public class SwitchTest2 {
	public static void main(String[] args) {
		int kor = 100;
		int eng = 100;
		int math = 100;
		char grade;
		
		int tot = kor+eng+math;
		double avg = (double)tot/3;
		avg = Math.round(avg*100)/100d;
		
		switch((int)(avg/10)) {
		case 10:
		case 9: grade = 'A'; break;
		case 8: grade = 'B'; break;
		case 7: grade = 'C'; break;
		case 6: grade = 'D'; break;
		default :  grade = 'F'; break;
		}

		System.out.printf("총점:%d, 평균:%.2f, 학점:%C%n", tot, avg, grade);
	}
}
