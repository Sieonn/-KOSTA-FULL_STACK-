import java.util.Scanner;

public class ArrayExam5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1, double 배열 6개생성
        double [] darr = new double[6];
        //2. 입력받아 배열에 할당
        for(int i=0; i<darr.length; i++) {
            darr[i] = sc.nextDouble();
        }
        //3. 배열 각 요소의 값을 총합 구하기
        double tot = 0;
        for(int i=0; i<darr.length; i++) {
            tot += darr[i];
        }
        //4. 평균 구하여 소수 첫째자리에서 반올림
        double avg = Math.round(tot/darr.length*10)/10d;
        //5. 출력
        System.out.println(avg);
    }
}

//6명의 몸무게를 입력받아 몸무게의 평균을 출력하는 프로그램을 작성하시오.
//출력은 반올림하여 소수 첫째자리까지로 한다.