import pac.Point;

public class ObjectTest5 {

    public static void main(String[] args) {
        Point p1 = new Point(3,5);
        Point p2 = (Point) p1.clone();
        System.out.println(p1);
        System.out.println(p2);
        p1.setX(100);
    }

}
