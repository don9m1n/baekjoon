import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        StringBuilder tt = new StringBuilder(t);

        int index = t.length() - 1;
        while(!s.equals(tt.toString())) {
            if (tt.charAt(index) == 'A') {
                tt.deleteCharAt(index--);
            } else {
                tt.deleteCharAt(index--);
                tt.reverse();
            }

            if (tt.length() < s.length()) {
                break;
            }
        }

        System.out.println(tt.toString().equals(s) ? 1 : 0);
    }
}
