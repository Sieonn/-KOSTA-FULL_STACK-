package array;

public class ArrayDi4 {
    public static void main(String[] args) {
        //2x3 2 차원 배열을 만든다.
        int[][] arr = new int[3][3]; //행은 2 열은 3

        int i =1;
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[row].length; col++) {
                arr[row][col] = i++;
            }
            }
        System.out.println(arr);
    }
}
