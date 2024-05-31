import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int count = Integer.parseInt(br.readLine());

        fib(count);
        fibo(count);

        System.out.print(fibCount + " ");
        System.out.print(fiboCount);

        br.close();
    }

    static int fibCount=0, fiboCount=0;

    public static int fib(int count){
        if(count == 1 || count == 2){
            fibCount++;
            return 1;
        }else {
            return fib(count -1) + fib(count-2);
        }
    }

    public static int fibo(int count){
        int[] arr = new int[count];
        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i < count; i++){
            fiboCount++;
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[count-1];
    }
}