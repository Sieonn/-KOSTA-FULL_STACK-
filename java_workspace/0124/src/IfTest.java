public class IfTest {
	public static void main(String[] args) {
		int kor = 89;
		int eng = 90;
		int math = 95;
//		int kor = 89, eng = 90, math = 95; 위에서 변수를 선언해주는 방법과 동일합니다. 
		
		int tot = kor + eng + math; //=에 오른쪽에 변수가 있으면 선언된 변수를 가져오겠다는 뜻입니다. 왼쪽에 있다면 오른쪽에 정의된 값을 왼쪽의 변수에 넣겠다는 뜻입니다.
//		double avg1 = tot/3.0;
//		float avg2 = tot/3;
		double avg = (double)tot/3;
		char grade;
		
		avg = Math.round(avg*100)/100d;
		
		if(avg>=90) {
			grade = 'A';
		} else if(avg>=80) {
			grade = 'B';
		} else if(avg>=70) {
			grade = 'C';
		} else if(avg>=60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println(String.format("총점:%d, 평균:%.2f, 학점:%C", tot, avg, grade));
//		System.out.println(avg1);
//		System.out.println(avg2);
	}

}
