package class1;

public class ClassStart4 {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "학생1";
        student1.age = 15;
        student1.grade=80;

        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 16;
        student2.grade=70;

//        Student[] students = new Student[] {student1, student2};
        Student[] students = {student1, student2};//위에의 배열 선언을 최적하 한 것

//        for(int i =0; i<students.length; i++){
//        System.out.println("이름:" +students[i].name+" 나이:"+students[i].age+" 성적:"+students[i].grade);
//        }

        for(int i =0; i<students.length; i++){
            Student s = students[i];
            System.out.println("이름:" +s.name+" 나이:"+s.age+" 성적:"+s.grade);
        }

        for(Student s: students){
            System.out.println("이름:" +s.name+" 나이:"+s.age+" 성적:"+s.grade);
        }
        //단축키 iter하면 자동으로 향상된 for문을 생성해줍니다.
    }
}
