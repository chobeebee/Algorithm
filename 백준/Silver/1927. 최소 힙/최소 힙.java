import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 배열에 자연수 X를 넣음
         * 배열에서 가장 작은 값 출력, 그 값을 배열에서 제거
         * 연산의 개수 1<=N<=100,000
         * 정수x가 자연수면 배열에 추가, 0이면 배열에서 가장 작은 값 출력 후 배열에서 제거
         * */
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