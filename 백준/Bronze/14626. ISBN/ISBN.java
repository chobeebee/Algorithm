import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    * <ISBN>
    * 도서에 부여된 고유번호, 13자리 숫자
    * 마지막 숫자는 체크 기호
    * 체크기호 m = 10 - (a+3b+c+3d+e+3f+g+3h+i+3j+k+3l) mod 10
    * 훼손된 숫자(*) 찾아내기
    * -----------------------------------
    * 짝수 자리는 3곱하기
    * 전체 합은 10배수(체크기호 포함)
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] isbn = br.readLine().split("");
        int index = 0; // 훼손된 번호 위치
        int sum = 0; // 합계
        
        // 번호 탐색
        for (int i = 1; i <= 13; i++) {
            // * 이면 위치 값 저장 후 다음 번호로
            if(isbn[i-1].equals("*")) {
                index = i;
                continue;
            }

            // 현 숫자의 위치값에 따라 합계
            int num = Integer.parseInt(isbn[i-1]);
            sum += (i % 2 == 0) ? num * 3 : num;
        }

        // 0 ~ 9까지 숫자 대입하여 나머지 값이 0인 숫자 찾기
        for (int i = 0; i < 10; i++) {
            int temp = sum;
            temp += (index % 2 == 0) ? i * 3 : i;
            
            // 나머지가 0이면 체크 번호임으로 출력 후 종료
            if (temp % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}