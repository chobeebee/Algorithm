import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            int num = sc.nextInt();
            String msg = sc.nextLine();
            String msg2 = msg.replaceAll(" ", "");

            for (int j = 0; j < msg2.length(); j++) {
                for (int h = 0; h < num; h++) {
                    System.out.print(msg2.charAt(j));
                }
            }
            System.out.println();
        }
    }
}