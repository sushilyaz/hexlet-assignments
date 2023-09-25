package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList (List<Home> homes, int n) {
         var hi = homes.stream()
                .sorted(Home::compareTo)
                .limit(n)
                .collect(Collectors.toList());
         ArrayList<String> resultList = new ArrayList<>();
         for (var line : hi) {
             resultList.add(line.toString());
         }
         return resultList;
    }
}
// END
