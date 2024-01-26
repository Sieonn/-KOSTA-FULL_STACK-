import java.util.Scanner;

public class ArrayExam2_13 {
    public static void main(String[] args) {
        int[][] arr = new int[4][2];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            String data = sc.nextLine();
            String[] vals = data.split(" ");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(vals[j]);
            }
        }
        int alltot = 0;
        for (int i = 0; i < arr.length; i++) { //행별 평균
            int tot = 0;
            for (int j = 0; j < arr[i].length; j++) {
                tot += arr[i][j];
                alltot += arr[i][j];//전체 평균을 위한 합
            }System.out.print(tot/arr[i].length+" ");
        }
        System.out.println();
        for (int i = 0; i < arr[0].length; i++) { //월별 평균, i:열
            int tot = 0;
            for (int j = 0; j < arr.length; j++) { //j:행
                tot += arr[j][i];//전체 평균을 위한 합
            }System.out.print(tot/arr.length+" ");
        }
        System.out.println();
        System.out.println(alltot/(arr.length*arr[0].length)); //전체 평균

    }
}

//4행 2열의 배열을 입력받아 가로평균과 세로평균 그리고 전체평균을 출력하는 프로그램을 작성하시오. (소수점 이하는 버림 한다.)