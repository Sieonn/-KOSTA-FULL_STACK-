package cond;

public class DistanceEx {
    public static void main(String[] args) {
        int distnace = 25;

        if(distnace<=1){
            System.out.println("도보를 이용하세요");
        } else if (distnace <=5) {
            System.out.println("자전거를 이용하세요");

        } else if (distnace<=25) {
            System.out.println("자동차를 이용하세요");

        }else {
            System.out.println("비행기를 이용하세요");
        }

    }

}
