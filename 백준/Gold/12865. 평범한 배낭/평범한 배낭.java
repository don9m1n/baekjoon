import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 배낭 개수
        int k = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken()); // 물건의 무게
            int v = Integer.parseInt(st.nextToken()); // 물건의 가치

            items[i][0] = w;
            items[i][1] = v;
        }

        int[] dp = new int[k + 1];
        
        for (int[] item : items) {
            for (int w = k; w >= item[0]; w--) {
                dp[w] = Math.max(dp[w], dp[w - item[0]] + item[1]);
            }
        }
        
        System.out.println(dp[k]);
    }
}
