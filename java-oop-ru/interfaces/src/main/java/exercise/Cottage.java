package exercise;

// BEGIN
public class Cottage implements Home{
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
    @Override
    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.area + " метров";
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Home another) {
        if (getArea() > another.getArea()) return 1;
        else if (getArea() < another.getArea()) return -1;
        return 0;
    }
}
// END
