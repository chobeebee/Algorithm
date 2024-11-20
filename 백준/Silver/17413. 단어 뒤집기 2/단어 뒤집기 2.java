import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 문자열 뒤집기 규칙
         * 1. 알파벳 소문자, 숫자, 공백, 특수문자로만 이루어짐
         * 2. 문자열의 시작과 끝은 공백이 아님
         * 3. <, >가 문자열에 있는 경우 번갈아가면서 등장하고 < 먼저 등장함(두 문자 개수 같음)
         * 태그 '<''>'안에 있는 애들은 뒤집기 X, 단어마다 뒤집기
         *
         * Stack
         * '<'가 나오면 '>'나올 떄 까지
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <S.length(); i++) {
            //'<'를 만났을 경우
            if(S.charAt(i) == '<'){
                //stack에 단어가 들어있을 경우(다음 '<'애를 만나기 전 넣은 단어)
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                //'>'만날 때까지 태그 안의 단어 저장
                while (true){
                    if(S.charAt(i) == '>'){
                        sb.append(S.charAt(i));
                        break;
                    }
                    sb.append(S.charAt(i));
                    i++;
                }
                continue; //'>'를 만난 후 i++이 필요함
            }

            //단어 사이 공백을 발견할 경우
            if(S.charAt(i) == ' '){
                //공백 전 단어를 뒤집어서 builder에 저장
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            }else{
                //스택에 단어 집어 넣음
                stack.add(S.charAt(i));
            }
        }

        //모든 태그가 끝난 후 뒤에 붙은 단어 뒤집기
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
        }

        System.out.println(sb);
    }
}