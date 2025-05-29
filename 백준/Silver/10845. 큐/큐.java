import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    /*
    * <큐>
    * 정수를 저장하는 큐 구현
    * - push X : 정수 X를 큐에 넣는 연산
    * - pop : 큐에서 가장 앞에 있는 정수 빼고, 그 수 출력 (큐가 비었다면 -1 출력)
    * - size : 큐에 들어있는 정수 개수 출력
    * - empty : 큐가 비었으면 1, 아니면 0 출력
    * - front : 큐 가장 앞 정수 출력 (큐가 비었다면 -1 출력)
    * - back : 큐 가장 뒤 정수 출력 (큐가 비었다면 -1 출력)
    *
    * 1<= 명령 수 N <=10,000
    * 1<= 정수 <= 100,000
    *
    * -----------------------
    * switch를 사용해서 명령어 조건에 따라 처리
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]){
                case "push":
                    queue.add(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    System.out.println(queue.isEmpty() ? -1: queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? -1: queue.peek());
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
            }
        }
    }
}