import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static boolean[] visited = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        recursive(0, "");

    }

    static void recursive(int index, String sequence) {
        if (index == m) {
            System.out.println(sequence.trim());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (sequence.isEmpty()) {
                    recursive(index + 1, sequence + " " + i);
                } else {
                    int prev = Integer.parseInt(String.valueOf(sequence.charAt(sequence.length() - 1)));

                    if (i > prev) {
                        visited[i] = true;
                        recursive(index + 1, sequence + " " + i);
                        visited[i] = false;
                    }
                }
            }
        }
    }
}
