package hotproblems.p1_string;

import org.junit.Test;

public class reverseString {

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }

    @Test
    public void test() {
        char[] s = "123".toCharArray();
        reverseString(s);
        assert "321".equals(new String(s));
    }
}
