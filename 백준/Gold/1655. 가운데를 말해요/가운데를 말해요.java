import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (left.size() == right.size()) {
                left.add(num);
            } else {
                right.add(num);
            }

            if(!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()){
                right.add(left.poll());
                left.add(right.poll());
            }

            System.out.println(left.peek());
        }
    }
}
