import java.util.Scanner;

public class ArrayExam2_13_2 {
    public static void main(String[] args) {
        int[][] arr = new int[4][2];
        Scanner sc = new Scanner(System.in);
        int result = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=0; j<arr[i].length; j++) {
                sum += arr[i][j];
            }
            result += sum;
            System.out.print((sum/2)+" ");
        }
        System.out.println();
        for(int i=0; i<2; i++){
            int sum =0;
            for(int j=0; j<arr[i].length; j++){
                sum += arr[j][i];
            }
            System.out.print((sum/4)+" ");
        }
        System.out.println();
        System.out.println(result/8);
    }
}
