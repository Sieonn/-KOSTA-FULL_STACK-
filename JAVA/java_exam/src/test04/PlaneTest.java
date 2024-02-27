package test04;

public class PlaneTest {
    public static void main(String[] args) {
        Plane airplane = new Airplane("L777",1000);
        Plane cargoplane = new Cargoplane("C50",1000);

        System.out.println("Plan fuelSize");
        System.out.println("------------------");
        airplane.printInfo();
        cargoplane.printInfo();

        airplane.flight(100);
        cargoplane.flight(100);

        System.out.println("100 운항\nPlane fuelSize");
        System.out.println("------------------");
        airplane.printInfo();
        cargoplane.printInfo();

        airplane.flight(200);
        cargoplane.flight(200);

        System.out.println("200 주유\nPlane fuelSize");
        System.out.println("------------------");
        airplane.printInfo();
        cargoplane.printInfo();

    }
}
