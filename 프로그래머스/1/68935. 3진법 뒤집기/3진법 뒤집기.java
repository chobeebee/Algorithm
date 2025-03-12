class Solution {
    public int solution(int n) {
        int answer = 0;
        int power = 1;
        String tmp = "";
        
        while(n > 0){
            tmp += n % 3;
            n /= 3;
        }
        
        for (int i = tmp.length()-1; i >= 0; i--) {
            answer += (tmp.charAt(i) - '0') * power;
            power *= 3;
        }
        
        return answer;
    }
}