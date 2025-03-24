import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while((input = br.readLine()) != null) {

            int n = Integer.parseInt(input);

            int remainder = 0;
            int digits = 0;

            while (true) {
                remainder = (remainder * 10 + 1) % n;
                digits++;

                if(remainder == 0) {
                    System.out.println(digits);
                    break;
                }
            }
        }
    }
}
