public class ArrayExam2_08 {
    public static void main(String[] args) {
        int[][] arr = new int[5][6];
        for (int i = 1; i < arr[0].length; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = arr[i - j][j] + arr[i][j - 1];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr);
            }

        }
        System.out.println();
    }
}

