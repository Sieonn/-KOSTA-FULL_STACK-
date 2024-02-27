import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetTest2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(33);
        list.add(6);
        list.add(22);
        list.add(22);
        list.add(7);

        HashSet<Integer> set = new HashSet<>(list);
        System.out.println(set);

        TreeSet <Integer> test = new TreeSet<>();
        test.add(33);
        test.add(6);
        test.add(22);
        test.add(22);
        test.add(7);

        System.out.println(test);
    }
}
