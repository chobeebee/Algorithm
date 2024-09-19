import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 양수, +, -, 괄호
         * 괄호를 적절히 쳐서 최소 값 구하기
         * 두개 이상 연속된 연산자 X, 양수는 5자리 이하
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int sum =Integer.MAX_VALUE;

        String str = br.readLine();
        String[] arr = str.split("-");

        for(int i = 0; i < arr.length; i++) {
            String[] arr2 = arr[i].split("\\+");
            int tmp = 0;

            for(int j = 0; j < arr2.length; j++) {
                tmp += Integer.parseInt(arr2[j]);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            }else{
                sum -= tmp;
            }
        }

        System.out.println(sum);
    }
}