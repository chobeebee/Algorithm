import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value == 0) {
                if (minHeap.isEmpty()) {
                    sb.append(0).append("\n");
                }else{
                    sb.append(minHeap.poll()).append("\n");
                }
            }else{
                minHeap.add(value);
            }
        }
        System.out.println(sb);
    }
}