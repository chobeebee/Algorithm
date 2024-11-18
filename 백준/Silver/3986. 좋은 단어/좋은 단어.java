import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 단어 위로 아치형 곡선을 그어 같은 글자끼리(A는 A, B는 B) 쌍을 짓기
         * 선끼리 교차하지 않으면서 각 글자를 짝 지으면 '좋은 단어'
         * '좋은 단어'개수는?
         *
         * A와 B가 섞이지 않아야 될 것 같은데..!
         * 단어의 글자를 차례로 비교
         * Stack 사용
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //단어 개수
        int count = 0; //좋은 단어 수

        //단어 개수 만큼 반복
        for (int i = 0; i < N; i++) {
            String input = br.readLine(); //입력 단어
            Stack<Character> stk = new Stack<>(); //단어 체크할 stack

            //단어 길이 만큼 탐색
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j); //단어의 j에 위치한 글자

                //스택이 비었거나 스택에서 뽑은 글자가 단어의 현 위치 글자와 다를 경우
                if(stk.isEmpty() || stk.peek() != c){
                    stk.push(c);
                }else{
                    //같은 글자면 빼기
                    stk.pop();
                }
            }

            //비어 있다면 좋은 단어이니까 +1
            if(stk.isEmpty()) count++;
        }
        System.out.println(count);
    }
}