package exercise;
import java.lang.CharSequence;
// BEGIN
public class ReversedSequence implements CharSequence {
    private String str;

    public ReversedSequence(String str) {
        String re = "";
        for (int i = 0; i < str.length(); i++) {
            re = str.charAt(i) + re;
        }
        this.str = re;
    }

    @Override
    public int length() {
        return this.str.length();
    }

    @Override
    public char charAt(int index) {
        return this.str.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.str.subSequence(start, end);
    }
    @Override
    public String toString () {
        return this.str;
    }
}
// END
