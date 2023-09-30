package exercise;
import java.lang.Math;
// BEGIN
public class Circle {
    private Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }
    public double getSquare() throws NegativeRadiusException {
        if (this.radius<0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        else {
            double square = 0;
            square = (Math.PI * Math.pow(this.radius, 2));
            return square;
        }
    }
}
// END
