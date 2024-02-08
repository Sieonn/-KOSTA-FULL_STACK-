import java.util.Comparator;
import java.util.TreeSet;

public class TreeTest2 {
    public static void main(String[] args) {
        Compartor <Student> Comparator = new Compartor<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
//                if(o1.ban>o2.ban) return 1;
//                else if (o1.ban<o2.ban) return -1;
//                else return o1.no-o2.no;
                if(o1.ban==o2.ban) return o1.no-o2.no;
                else return o1.ban-o2.ban;
            }
        };
        TreeSet<Student> tset = new TreeSet<Student>(comparator);
        tset.add(new Student("홍길동", 1, 1, 100, 100, 100));
        tset.add(new Student("임자자", 1, 2, 90, 70, 80));
        tset.add(new Student("김자바", 1, 3, 80, 80, 90));
        tset.add(new Student("최자마", 1, 4, 70, 90, 70));
        tset.add(new Student("한자바", 1, 5, 60, 100, 80));
        for(Student s : tset) {
            System.out.println(s);
        }
    }

}
