import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int[] nums = new int[2];

        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < nums.length; i++){
            int tmp = 0;

            while (nums[i] != 0) {
                tmp = tmp * 10 + nums[i] % 10;
                nums[i] /= 10;
            }
            nums[i] = tmp;
        }

        if(nums[0] > nums[1]){
            System.out.println(nums[0]);
        } else if (nums[0] < nums[1]) {
            System.out.println(nums[1]);
        }
    }
}