package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    protected String nameTag;
    protected Map<String, String> attributesOfTag;

    public Tag(String nameTag, Map<String, String> attributesOfTag) {
        this.nameTag = nameTag;
        this.attributesOfTag = attributesOfTag;
    }
    public String toString () {
        if (attributesOfTag.size() == 0) return "<" + nameTag + ">";
        else {
            String include = attributesOfTag.entrySet().stream()
                    .map(x -> x.getKey() + "=" + "\"" + x.getValue() + "\"")
                    .collect(Collectors.joining(" "));
            return "<" + nameTag + " " + include + ">" ;
        }
    }
}
// END
