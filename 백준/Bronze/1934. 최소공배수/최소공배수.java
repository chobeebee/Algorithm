import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    * <최소공배수>
    * 두 자연수 A,B
    * A의 배수이면서 B의 배수 = A, B의 공배수
    * 공배수 중 가장 작은 수가 최소공배수
    *
    * 1<= 테스트 케이스 개수 T <=1,000
    * 1<= A,B <=45,000
    * --------------------------------------
    * 최대공약수 : 유클리드 호제법
    * - r=a%b
    * - r이 0이 되면 b가 최대공약수
    * - r이 0이 아니면 a=b,b=r로 바꾸고 위 과정을 반복
    * 최소공배수
    * - LCM(a,b)=a×b/GCD(a,b)
    * - 최대공약수를 구한 후, 두 수의 곱을 최대공약수로 나누기
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 최소공배수 출력
            System.out.println(lcm(A, B));
        }
    }
    
    // 최대공약수
    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    // 최소공배수
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}