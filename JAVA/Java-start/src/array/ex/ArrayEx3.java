package array.ex;

import java.util.Scanner;

public class ArrayEx3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = new int[5];
        System.out.println("정수 다섯개를 입력하세용:");
        for(int i = 0; i<arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("출력");
        for(int i=arr.length-1; i>=0; i--){
            System.out.print(arr[i]);
            if(i!=0){
                System.out.print(",");
            }
        }
    }
}
