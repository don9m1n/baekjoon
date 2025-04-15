import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R;
    static int C;
    static List<int[]> swan = new ArrayList<>();
    static Queue<int[]> waterQueue = new LinkedList<>();
    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> nextQueue = new LinkedList<>();
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);

                if(arr[i][j] == 'L') {
                    swan.add(new int[]{i, j});
                    waterQueue.add(new int[]{i, j});
                } else if(arr[i][j] == '.') {
                    waterQueue.add(new int[]{i, j});
                }
            }
        }

        queue.add(swan.get(0));
        visited[swan.get(0)[0]][swan.get(0)[1]] = true;

        int day = 0;
        while (true) {
            if (search(swan.get(1))) {
                System.out.println(day);
                break;
            }

            melt();
            queue = nextQueue;
            nextQueue = new LinkedList<>();
            day++;
        }
    }

    private static boolean search(int[] end) {
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            if(curr[0] == end[0] && curr[1] == end[1]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;

                if(arr[nx][ny] == 'X') {
                    nextQueue.add(new int[]{nx, ny});
                } else {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    private static void melt() {
        int size = waterQueue.size();

        for (int i = 0; i < size; i++) {
            int[] curr = waterQueue.poll();

            for (int j = 0; j < 4; j++) {
                int nx = curr[0] + dx[j];
                int ny = curr[1] + dy[j];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if(arr[nx][ny] == 'X') {
                    arr[nx][ny] = '.';
                    waterQueue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
