class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int gcd = 0, lcm = 0;
        
        for(int i=1; i<=n && i<=m; i++){
            
            if(n%i == 0 && m%i == 0){
                gcd = i;
            }
        }
        
        lcm = (n * m) / gcd;
        
        answer[0] = gcd;
        answer[1] = lcm;
        
        return answer;
    }
}