package test02;

public class TestStudent {
    public static void main(String[] args) {
        Student [] stu = new Student[3];
        stu[0] = new Student("홍", 20, 144, 24, "12", "미술");
        stu[1] = new Student("강", 20, 144, 85, "23", "공연예술");
        stu[2] = new Student("최", 20, 144, 44, "17", "융합화학");

        for(int i=0; i< stu.length; i++){
            System.out.println(stu[i]);
        }

    }
}
