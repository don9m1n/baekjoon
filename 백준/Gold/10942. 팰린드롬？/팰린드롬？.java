import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][n + 1];

        // 길이가 1이면 무조건 팰린드롬 성립
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }

        // 길이가 2인 경우 두 수가 같아야 팰린드롬 성립
        for (int i = 1; i < n; i++) {
            if(arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        for (int i = 3; i <= n; i++) {
            for (int start = 1; start + i - 1 <= n; start++) {
                int end = start + i - 1;

                if (arr[start] == arr[end] && dp[start + 1][end - 1] == 1) {
                    dp[start][end] = 1;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            answer.append(dp[s][e]).append("\n");
        }

        System.out.println(answer);
    }
}
