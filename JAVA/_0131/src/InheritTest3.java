import org.w3c.dom.ls.LSOutput;

class Point {
    int x;
    int y;
    Point() {
        System.out.println("Point Default constructor");
    }
    Point(int x, int y) {
        this.x = x;
        this.y =y;
    }


    String getLocation() {
        return "(" + x + "," + y + ")";
    }
}

class Point3D extends Point {
    int z;
    Point3D() {
        System.out.println("Point3D default constructor");
    }
    Point3D(int x, int y, int z) {
        super(x,y);
        this.z = z;
    }
    @Override
    String getLocation() {
        return "(" + x + "," + y + "," + z + ")" ;
    }
}

public class InheritTest3 {
    public static void main(String[] args) {
        Point p2 = new Point(10,20);
//        p2.x = 10;
//        p2.y = 20;
        System.out.println(p2.getLocation());

        Point3D p3 = new Point3D(100, 200, 300);
//        p3.x = 100;
//        p3.y = 200;
//        p3.z = 300;
        System.out.println(p3.getLocation());

    }
}
