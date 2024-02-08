import java.sql.SQLOutput;
import java.util.TreeSet;
import java.util.SortedSet;

public class TreeSetTest3 {
    public static void main(String[] args) {
        TreeSet<Integer> tset = new TreeSet<>();
        tset.add(56);
        tset.add(78);
        tset.add(98);
        tset.add(65);
        tset.add(69);
        tset.add(77);
        tset.add(95);
        tset.add(87);

        System.out.println(tset);
//        tset.hashCode(90);
        SortedSet<Integer> hset = tset.headSet(60);
        System.out.println(hset);
        SortedSet<Integer> tailSet = tset.tailSet(90);
        System.out.println(tailSet);
        SortedSet<Integer> subSet = tset.subSet(80,90);
        System.out.println(subSet);
    }
}
