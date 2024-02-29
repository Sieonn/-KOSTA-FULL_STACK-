package array;

import java.util.Scanner;

public class ArrayEx5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력받을 숫자의 개수를 입력하세요.:");
        int input = scanner.nextInt();
        int sum =0;
        int [] nums = new int[input];
        for(int i=0; i<input; i++){
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        double avg = (double) sum/nums.length;
        System.out.println("입력한 정수의 합계:"+ sum);
        System.out.println("입력한 정수의 평균: "+avg);


    }
}
