import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * X, Rev(X): X의 역순
         * ex) X = 100, Rev(X) = 1
         * Rev(Rev(X) + Rev(Y)) 값을 구하시오.
         * X, Y <= 1000
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력 받은 두 숫자를 역순으로 변환
        int revX = reverseNumber(Integer.parseInt(st.nextToken()));
        int revY = reverseNumber(Integer.parseInt(st.nextToken()));
        
        // 두 숫자를 더한 결과를 다시 역순으로 변환
        int result = reverseNumber(revX + revY);
        
        // 결과 출력
        System.out.println(result);
    }

    // 숫자를 역순으로 변환하는 메서드
    private static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}