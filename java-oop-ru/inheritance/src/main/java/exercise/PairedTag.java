package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    protected String body;
    protected List<Tag> tagList;

    public PairedTag(String nameTag, Map<String, String> attributesOfTag, String body, List<Tag> tagList) {
        super(nameTag, attributesOfTag);
        this.body = body;
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        String includeList = tagList.stream()
                .map(x -> x.toString())
                .collect(Collectors.joining(""));
        return super.toString() + includeList + this.body + "</" + nameTag + ">";
    }
}
// END
