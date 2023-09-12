package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables (String conf) {

        String confStream = Arrays.stream(conf.split("\n"))
                .filter(x -> x.contains("environment"))
                .flatMap(x-> Stream.of(x.split("X_FORWARDED")))
                .flatMap(x-> Stream.of(x.split(",")))
                .filter(x -> x.contains("_"))
                .flatMap(x->Stream.of(x.replace('_', ',')))
               // .filter(x->!x.contains("\""))
                .collect(Collectors.joining());
//                .flatMap(x-> Stream.of(x.split(",")))
//                .filter(x->x.contains("\"X_FORWARDED_"))
//                .flatMap(x-> Stream.of(x.split("\"X_FORWARDED_")))
//                .filter(x->!x.isEmpty())
        String str="";
        for (int i = 1; i < confStream.length(); i++) {
            if (confStream.charAt(i) == '\"') continue;
            else str = str + confStream.charAt(i);
        }
        return str;
    }
}
//END
