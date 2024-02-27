public class ArrayExam2_07 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
        int[][] arr = new int[7][7];
        arr[0][1] = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

}


//아래와 같은 삼각형을 출력하는 프로그램을 작성하시오. 파스칼 삼각형은 첫번째 줄
// 첫번째 행을 1로 초기화한 후 다음줄부터는 바로 위의 값과 바로 위의 값과 바로
// 왼쪽의 값을 더한 값이 됩니다.