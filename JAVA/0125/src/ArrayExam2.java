public class ArrayExam2 {
    public static void main(String[] args) {
        int[] arr = {10,20, 25, 66, 83, 7, 22, 90, 1, 100};
        int odd =0;
        int even=0;
        for(int i=0; i < arr.length; i++) {
            if(i%2==0) {
                odd += arr[i];
//                System.out.println(even +"\n");
            }else {
                even += arr[i];
//                System.out.println(odd+"\n");
            }
        }System.out.print(odd+"\n"+even);
    }
}


//odd: 141
//even: 283