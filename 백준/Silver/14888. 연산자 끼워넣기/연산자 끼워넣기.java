import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] nums;
    static int[] op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int index, int current) {
        if (index == n) {
            max = Math.max(max, current);
            min = Math.min(min, current);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자가 남아 있으면 계산

            int next = 0;

            if(op[i] > 0) {
                if (i == 0) {
                    next = current + nums[index];
                } else if (i == 1) {
                    next = current - nums[index];
                } else if (i == 2) {
                    next = current * nums[index];
                } else {
                    next = current / nums[index];
                }

                op[i]--;
                dfs(index + 1, next);
                op[i]++;
            }
        }
    }
}
