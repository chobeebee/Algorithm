import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 새로운 언어 AC : 정수 배열에 연산하기 위한
         * R(뒤집기) : 배열 수의 순서 뒤집기 , D(버리기) : 첫 번째 수 버리기
         * 빈 배열에 D를 사용하는 경우 에러 발생
         * 함수는 조합해서 한 번에 사용 가능
         *
         * 1<= 수행할 함수 p <= 100,000
         * 배열에 들어있는 수의 개수 n
         * 전체 테스트 케이스의 p의 길이 합과 n의 합은 70만을 넘지 않음
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); //테스트 수

        for (int i = 0; i < T; i++) {
            String p = br.readLine(); //수행할 함수
            int n = Integer.parseInt(br.readLine()); //배열 안의 수의 개수
            ArrayDeque<Integer> deque = new ArrayDeque<>(); //배열

            //빈 배열인데 D라면 eroor 출력
            if(n == 0) {
                if(p.contains("D")){
                    System.out.println("error");
                }else{
                    System.out.println("[]");
                }
                br.readLine();
                continue;
            }

            //입력받은 배열 deque 넣기
            st = new StringTokenizer(br.readLine(), "[],"); //입력받은 배열
            for (int j = 1; j < (n*2); j+=2) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean error = false;
            boolean reverse = false;

            for (int j = 0; j < p.length(); j++) {
                //R이면 뒤집기, D이면 첫 자리 빼기
                if (p.charAt(j) == 'R') {
                    reverse = !reverse;
                }else{
                    if(deque.isEmpty()){
                        error = true;
                    }
                    if (!reverse) {
                        deque.pollFirst();
                    }else{
                        deque.pollLast();
                    }
                }
            }

            if(error){
                System.out.println("error");
            }else{
                System.out.print("[");

                StringBuilder sb = new StringBuilder();
                if (!reverse) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst()).append(",");
                    }
                }else{
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast()).append(",");
                    }
                }

                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                System.out.print(sb);
                System.out.println("]");
            }
        }
    }
}