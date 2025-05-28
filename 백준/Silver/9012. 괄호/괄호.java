import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    /*
    * <괄호>
    * () : 올바른 괄호 문자열(VPS)
    * VPS 인지 아닌지 판단 : YES, NO로 출력
    *
    * T : 테스트 데이터
    * 2<= 괄호 문자열의 길이 <= 50
    * ------------------------------------
    * Stack을 이용해서 '('다음에')' 가 나오면 poll
    * Stack이 비었는데 ')'차례라면 VPS가 아님 > NO
    * Stack이 다 비었다면 YES, 아니면 NO
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 데이터

        // 테스트 수 만큼 반복
        for (int i = 0; i < T; i++) {
            Stack<String> stack = new Stack<>();
            String[] arr = br.readLine().split(""); // 입력된 문자열을 배열로
            
            // 배열 탐색
            for (int j = 0; j < arr.length; j++) {
                // '('이면 stack에 넣기
                if (arr[j].equals("(")) {
                    stack.push(arr[j]);
                }else {
                    // stack이 비었는데 ')'차례면 탐색 종료
                    if(stack.isEmpty()) {
                        stack.push(")");
                        break;
                    }
                    // 아니면 '(' 꺼내기
                    stack.pop();
                }
            }
            
            // stack 크기에 따라 결과 출력
            if(stack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}