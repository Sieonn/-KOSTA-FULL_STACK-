package array.ex;

import java.util.Scanner;

public class ArrayEx6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력받을 숫자의 개수를 입력하세요");
        int num = scanner.nextInt();

        int []arr = new int[num];
        System.out.println(num+"개의 정수를 입력하세요.");
        for(int i=0; i<arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        int max = arr[0];
        int min = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if (arr[i]< min) {
                min = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(min);

    }
}
