import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 최대 힙
         * 1. 배열에 자연수 x
         * 2. 배열에서 가장 큰 값 출력, 그 값을 배열에서 제거
         * 연산의 개수 1<=N<=100,000
         * x가 0이라면 배열에서 가장 큰 값 출력하고 그 값을 제거
         * 0이 주어진 횟수 만큼 출력, 배열이 비었는데 가장 큰 값 출력해야할 경우엔 0 출력
         *
         * 우선 순위 큐 사용, Collections.reverseOrder()정렬해서 큰 값 꺼내기
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); //연산 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.add(value);
            }
        }

        System.out.println(sb);
    }
}