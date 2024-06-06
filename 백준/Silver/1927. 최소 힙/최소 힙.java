import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value == 0) {
                if (minHeap.isEmpty()) {
                    System.out.println("0");
                }else{
                    System.out.println(minHeap.poll());
                }
            }else{
                minHeap.add(value);
            }
        }
    }
}