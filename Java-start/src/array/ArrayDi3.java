package array;

public class ArrayDi3 {
    public static void main(String[] args) {
        //2x3 2 차원 배열을 만든다.
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}; //행은 2 열은 3

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {

                System.out.print(arr[row][col] +
                        " ");
            }

            System.out.println();
        }
        System.out.print(arr[0][0] + " ");
        System.out.print(arr[0][1] + " ");
        System.out.print(arr[0][2] + " ");
        System.out.println();
        System.out.print(arr[1][0] + " ");
        System.out.print(arr[1][1] + " ");
        System.out.print(arr[1][2] + " ");
    }
}
