class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a){
            
            int trans = (n / a) *b;
            answer += trans;
            
            n = trans + (n % a);
            
        }
        
        return answer;
    }
}