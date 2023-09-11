package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class public Sorter{

public static List<String> takeOldestMans (List<Map<String, String>> users) {
        users = users.stream()
        .filter(user -> user.get("gender").equals("male"))
        .collect(Collectors.toList());

        List<LocalDate> localDate = new ArrayList<>();
        for (var name : users) {
        localDate.add(LocalDate.parse(name.get("birthday")));
        }
        localDate.sort(new Comparator<LocalDate>() {
@Override
public int compare(LocalDate o1, LocalDate o2) {
        return o1.compareTo(o2);
        }
        });
        List<String> result = new ArrayList<>();
        for (LocalDate name : localDate) {
        for (var user : users) {
        if (name.toString().equals(user.get("birthday"))) result.add(user.get("name"));
        }
        }
        return result;
        }
        }
// END
