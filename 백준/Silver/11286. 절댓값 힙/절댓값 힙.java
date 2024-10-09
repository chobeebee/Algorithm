import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 1. 배열에 정수 x(!0) 넣기
         * 2. 절댓값이 가장 작은 값 출력, 그 값을 배열에서 제거
         *  절댓값이 여러개면 가장 작은 수 출력, 그 값을 배열에서 제거
         *
         * 1<=N<=100,000
         * x가 0이 아니라면 배열에 추가, 0이라면 가장 작은 절댓값 출력,제거
         * 0이 주어진 횟수 만큼 답 출력, 배열이 비어있는데 가장 작은 값 출력하라고 하면 0 출력
         *
         * 우선순위큐 : 정렬
         * 조건 0인지 아닌지 판별
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //연산 개수

        //정렬 재 정의 : 절대값 비교하여 넣기
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());

            //입력 값이 0이면
            if (tmp == 0) {
                //배열이 비어있지 않은 경우
                if (!queue.isEmpty()) {
                    //가장 작은 값 출력
                    System.out.println(queue.poll());
                } else {
                    //비었으면 0 출력
                    System.out.println(0);
                }
            } else {
                //입력 값이 0이 아니면 배열에 해당 값 넣기
                queue.add(tmp);
            }
        }
    }
}