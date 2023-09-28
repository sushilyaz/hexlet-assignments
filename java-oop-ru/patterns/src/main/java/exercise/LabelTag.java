package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private TagInterface tagInterface;
    private String tag;

    public LabelTag(String tag, TagInterface tagInterface) {
        this.tag = tag;
        this.tagInterface = tagInterface;
    }

    @Override
    public String render() {
        return "<label>" + this.tag + this.tagInterface.render() + "</label>";
    }
}
// END
