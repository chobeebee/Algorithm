import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    * <FizzBuzz>
    * i = 1,2,...
    * - i가 3배수 && 5배수 = "FizzBuzz"
    * - i가 3배수인데 5배수가 아니면 = "Fizz"
    * - i가 3배수가 아니고 5배수이면 = "Buzz"
    * - i가 3배수X && 5배수X = i
    * 연속으로 출력된 세 개의 문자열 다음에 올 문자열은?
    * ---------------------------------------
    * 숫자인지 확인 (.matches("\\d+")이용)
    * 숫자가 나온 순서 파악 필요 (처음 나오면 +3, 2번째면 +2, 3번째면 +1)
    * 숫자가 나오면 break 후, 다음 문자열 값을 계산 후 조건에 맞는 값 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = 0; // 입력된 숫자
        int idx = 0; // 숫자가 나온 순서

        for (int i = 0; i < 3; i++) {
            String word = br.readLine();

            if (word.matches("\\d+")) {
                number = Integer.parseInt(word);
                idx = i;
                break;
            }
        }

        int nextNum = number + (3 - idx); // 다음 문자열 값

        // 조건에 따른 출력 값
        if (nextNum % 3 == 0 && nextNum % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (nextNum % 3 == 0) {
            System.out.println("Fizz");
        } else if (nextNum % 5 == 0) {
            System.out.println("Buzz");
        }else {
            System.out.println(nextNum);
        }
    }
}