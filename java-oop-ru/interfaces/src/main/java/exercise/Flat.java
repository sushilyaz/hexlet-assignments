package exercise;

// BEGIN
public class Flat implements Home {

    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }

    @Override
    public short compareTo(Home another) {
        if (getArea() > another.getArea()) return 1;
        else if (getArea() < another.getArea()) return -1;
        else return 0;
    }

    public String toString () {
        return "Квартира площадью " + getArea() + " метров на " + this.floor + " этаже";
    }
}
// END
