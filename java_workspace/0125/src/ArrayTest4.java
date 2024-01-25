public class ArrayTest4 {
    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 50};
        int[] arr2 = new int[arr.length];

        System.arraycopy(arr,0,arr2,0,arr.length);
        int[] arr3 =arr.clone();
        //자기가 알아서 메모리까지 생성해서 복사해서 준다.
        arr[0] = 100;

        print(arr);
        System.out.println();
        print(arr2);
        //레퍼런스의 특징 공유하는 개념이라서 하나의 값이 바뀌면 그 값을 공유하고 있는 다른 배열도 바뀐다.
        //new 라는 애는  무조건 가비지 컬렉터가 만들어주고 참조하는 변수가 0이될때 메모리 회수 대상이 됩니다.
        //분리하려면 완벽하게 복제를 하면 분리가 됩니다.
        //스왈로우 카피와 딥카피가 있습니다.
    }
}
