import java.util.Scanner;

public class ArrayExam7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] narr = new int[100];

        //1. 999가 입력될 때 까지 입ㄹ력받은 값을 배열에 담는다.
        int i = 0, val;
        for (; i < narr.length; i++) {
            val = sc.nextInt();
            if (val == 999) break;
            narr[i] = val;
        }
        //2. 배열에 입력된 값중에 가장 최소값과 최대값을 구한다.
        int max = narr[0];
        int min = narr[0];

        for (int j = 1; j < i; j++) {
            if (narr[j] > max) max = narr[j];
            if (narr[j] < min) min = narr[j];
        }
        System.out.println("max:" + max);
        System.out.println("min:" + min);
    }
}

//세 자리 이하릐 정수를 차례로 입력 받다가 999가 입력되면 프로그램을 종료하고 그 때까지 입력된 최대값과 최소값을 출력하는 프로그램을 작성하시오.
//입력받는 정수는 100개 이하이다.
//
//입력
//45 19 123 58 10 -55 16 -1 999
//출력
//123
//-55