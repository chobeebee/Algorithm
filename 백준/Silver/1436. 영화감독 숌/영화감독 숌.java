import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    * <영화감독 숌>
    * 666은 종말을 나타내는 수, 6이 적어도 3개이상 연속
    * 666(1), 1666(2), ...(N)
    * N번째 영화 제목에 들어간 수 출력
    *
    * N <= 10,000
    * -------------------------------
    * 666부터 시작
    * count 변수를 생성해서 N번째가 되면 break
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 1; // 순서
        int num = 666; // 첫번째 제목 666부터 시작

        while (true){
            // N번째가 되면 순서를 출력
            if(count == N) {
                System.out.println(num);
                break;
            }
            
            num++; // 숫자 증가

            // 666이 들어가 있으면 순서 증가
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
    }
}