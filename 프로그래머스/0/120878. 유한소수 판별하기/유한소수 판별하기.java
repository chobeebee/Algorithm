class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int deno = b;
        
        while(a%b != 0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        
        deno/=b;
        
        while(deno%2 == 0) deno /= 2;
        while(deno%5 == 0) deno /= 5;
        
        answer = (deno == 1) ? 1 : 2;
        
        return answer;
    }
}