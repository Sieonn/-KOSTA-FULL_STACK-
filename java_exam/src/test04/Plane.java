package test04;

abstract class Plane {
    private String planeName;
    private int fuelSize;

    public Plane() {
        super();
    }

    public Plane(String planeName, int fuelSize) {
        this.planeName = planeName;
        this.fuelSize = fuelSize;
    }

    public void refuel(int fuel) {
        fuelSize += fuel;
    }

    public abstract void flight(int distance);

    public void setName(String planeName) {
        this.planeName = planeName;
    }

    public void setFuelSize(int fuelSize) {
        this.fuelSize = fuelSize;
    }

    String getName() {
        return planeName;
    }

    public int getFuelSize() {
        return fuelSize;
    }

    public void printInfo() {
        System.out.println(planeName+" "+ fuelSize);
    }

}
