package array;

public class ArrayRef1 {
    public static void main(String[] args) {
        int[] students; //배열 변수 선언
        students = new int[5];

        //변수 값 대입
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        // 변수 값 사용
        System.out.println("학생1의 점수:" + students[0]);
        System.out.println("학생2의 점수:" + students[1]);
        System.out.println("학생3의 점수:" + students[2]);
        System.out.println("학생4의 점수:" + students[3]);
        System.out.println("학생5의 점수:" + students[4]);
//
//        System.out.println("학생6의 점수:"+ studnets);
    }

}
