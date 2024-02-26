package array;

public class ArrayRef2 {
    public static void main(String[] args) {
        int[] students; //배열 변수 선언
        students = new int[5];
        System.out.println(students.length);

        //변수 값 대입
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        for(int i =0; i<students.length; i++) {
            System.out.println("학생"+ (i+1)+ "의 점수:"+ students[i]);
        }

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
