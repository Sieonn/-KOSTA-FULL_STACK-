public class MethodTest1 {
    //함수의 정의
    public static int sum(int[] arr) {
        int tot =0;
        for(int i=0; i<arr.length; i++){
            tot += arr[i];
        }
        return  tot;
    }
    public static void main(String[] args) {
        int [] arr1 = {10, 20,30, 40, 50};
        int [] arr2 = {100, 200,300, 400, 500, 600};

        int hap = sum(arr1); //함수의 호출 : 함수는 호출되어야 실행된다. 함수를 선언하는 것과 호춣하여 실행하는 것은 다릅니다.
        System.out.println(hap);
        hap = sum(arr2);
        System.out.println(hap);
    }
}
