import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    /*
    * 스택
    * - push X : 정수 X를 스택에 넣는 연산
    * - pop : 스택에서 가장 위에 있는 정수를 빼고 그 수를 출력 (스택이 비었다면 -1)
    * - size : 스택에 들어있는 정수 개수
    * - empty : 스택이 비어있으면 1, 아니면 0
    * - top : 스택의 가장 위 정수를 출력 (스택에 비었다면 -1)
    *
    * 1 <= 명령 수 <= 10,000 | 1 <= 정수 <= 100,000
    * ---------------
    * 명령어를 switch에 넣어서 활용
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령 수
        Stack<Integer> stack = new Stack<>();

        // 명령 수 만큼 반복
        for(int i=0; i < N; i++) {
            String[] command = br.readLine().split(" "); // 명령
            
            switch (command[0]) {
                case "push" :
                    stack.push(Integer.valueOf(command[1]));
                    break;

                case "pop" :
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;

                case "size" :
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty" :
                    sb.append(stack.isEmpty() ? 1 : 0 ).append("\n");
                    break;

                case "top" :
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}