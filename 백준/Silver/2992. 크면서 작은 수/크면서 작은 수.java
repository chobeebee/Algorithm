import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int X,min;
    static String[] nums;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        /**
         * 정수 X와 구성이 같으면서 X보다 큰 수 중 가장 작은 수 출력
         * 구성 : 각 자리수가 같음 ex) 123, 321
         * 1<= X <= 999999
         * 그런 수가 없다면 0 출력
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine()); //정수 X
        nums = Integer.toString(X).split(""); //각 자리수
        min = Integer.MAX_VALUE; //가장 작은 수
        used = new boolean[nums.length]; //사용한 숫자 체크

        recur(0, new StringBuilder());

        //조건에 맞는 수가 없다면 0 출력, 있다면 가장 작은 수 출력
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    private static void recur(int depth, StringBuilder seq) {

        //정수 X 길이가 될 경우
        if (depth == nums.length) {
            int current = Integer.parseInt(seq.toString());
            //X보다 큰 수일 때만 최소값을 갱신
            if (current > X) {
                min = Math.min(min, current);
            }
            return;
        }

        //자리수 조합
        for (int i = 0; i < nums.length; i++) {
            //사용한 자리수가 아닐 경우
            if (!used[i]) {
                used[i] = true;
                seq.append(nums[i]);
                recur(depth + 1, seq);
                seq.setLength(seq.length() - 1);
                used[i] = false;
            }
        }
    }
}