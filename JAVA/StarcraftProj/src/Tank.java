public class Tank  extends GroundUnit{
    Tank() {
        super(150);
        hitPoint = MAX_HP;
    }
    @Override
    public String toString() {
        return "Tank";
    }
}
