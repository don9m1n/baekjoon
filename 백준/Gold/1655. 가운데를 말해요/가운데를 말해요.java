import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (min.size() == max.size()) {
                min.add(num);
            } else {
                max.add(num);
            }

            if(!min.isEmpty() && !max.isEmpty()){
                if (min.peek() > max.peek()) {
                    max.add(min.poll());
                    min.add(max.poll());
                }
            }

            System.out.println(min.peek());
        }
    }
}
