import java.util.Scanner;

public class ArrayExam2_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][3];

        for (int i = 0; i < arr.length; i++) {
            System.out.print((i + 1) + "class?");

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            System.out.print((i + 1) + "class: ");

            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            System.out.println(sum);
        }
    }
}

//호석이네 학교는 6학년이 네 반이 있는데 각 반의 대표를 세 명씩 선발하여 제기차기 시합을 하였다.
//반별로 세 명이 제기를 찬 개수를 입력받아 각 반별로 제기를 찬 개수의 합계를 출력하는 프로그램을 작성하시오.
//(반드시 배열을 이용하고 입력후에 출력하는 방식으로 하세요.)