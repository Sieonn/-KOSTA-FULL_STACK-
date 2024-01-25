import java.util.Scanner;

public class ArrayExam4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100];
        int i=0, val;
        while(true) {
            val = sc.nextInt();
            if(val==-1) break;
            arr[i++] = val;
        }
        for(int j=i-3; j>i; j++) {
            System.out.print(arr[j]+" ");
        }//System.out.print(arr[arr.length-1] + " " + arr[arr.length-2] +" "+ arr[arr.length-3]);
    }
}
//100개의 점수를 입력받을 수 있는배열을 선언한 후 점수를 차례로 입력 받다가 -1이 입력되면 입력을 중단하고
//-1을 제외한 마지막 세 개의 정수를 출력하는 프로그램을 작성하시오.
//(입력받은 정수가 -1을 제외하고 3개 미만일 경우에는 -1을 제외하고 입력받은 점수를 모두 출력한다.