package exercise;

// BEGIN
public class App {
    public static void printSquare (Circle circle) throws NegativeRadiusException {
        try {
            System.out.println(String.valueOf((int) circle.getSquare()+1));
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
