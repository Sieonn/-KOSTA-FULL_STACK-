import java.util.Scanner;

public class ArrayExam2_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] fibo = new int [40];
        fibo[0] = fibo[1] = 1;
        int val;
        for(int i=2; i<fibo.length; i++) {
            fibo[i] = fibo[i-2]+fibo[i-1];
            if(i%10==9) {
                System.out.println(String.format("피보나치수열 %d항 : %d", i+1, fibo[i]));
            }
        }
        System.out.println();

    }
}
