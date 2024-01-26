import java.util.Scanner;

public class ArrayExam9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] narr = new int[100];
        int i = 0, val;
        for (; i < narr.length; i++) {
            val = sc.nextInt();
            if (val == 0) break;
            narr[i] = val;
        }
        int cnt = 0;
        for (int j = 0; j < i; j++) {
            if (narr[j]%2==1){
                narr[j] = narr[j] * 2;
            }else {
                narr[j] = narr[j] / 2;
            }
            cnt++;

        }
        System.out.println(cnt);
        for (int k = 0; k < i; k++) {
            System.out.print(narr[k]+" ");

        }
    }
}
//정수를 입력 받다가 0이 입력되면 0을 제외하고 그 때까지 입력 받은 개수를 출력한 후 입력받은 정수를 차례로 출력하되 그 수가 홀수 이면 2배한 값을, 짝수인 경우에는 2로난눈 몫을 출력하는 프로그램을 작성하시오.
//입력되는 정수의 개수는 100개 이하이다.
//
//입력
//8 10 5 15 100 0
//출력
//5
//4 5 10 30 50