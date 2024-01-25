import java.util.Scanner;

public class ArrayExam8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] narr = new int[100];
        int i = 0, val;
        for (; i < narr.length; i++) {
            val = sc.nextInt();
            if (val == 0) break;
            narr[i] = val;
        }
        int num = 0;
        int cnt = 0;
        for (int j=0; j<i; j++){
            if(narr[j]%5==0)  {
                cnt++;
                num += narr[j];
            }

        }System.out.print(cnt+"\n"+num+"\n"+(float)num/cnt);
        //총합을 구하기
//        int tot = 0;
//        for(int j=0; j<narr.length; j++) {
//            tot += narr[j];

    }
}
//100개 이하의 정수를 입력받다가 0이 입력되면 그 때까지 입력된 정수 중 5의 배수의 개수와 합계 평균을 출력하는 프로그램을 작성하시오. 평균은 소수점 이하 1자리까지 출력합니다.
//입력
//35 10 23 100 64 51 5 0
//출력
//4
//150
//37.5