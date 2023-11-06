package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {

    private String str;

    public ReversedSequence(String str) {
        String resultString = "";
        int i = str.length() - 1;
        while (i >= 0) {
            resultString = resultString + str.charAt(i);
            i--;
        }
        this.str = resultString.toString();
    }


    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        return str.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return str.subSequence(start, end);
    }

    public String toString() {
        return str;
    }
}
// END
