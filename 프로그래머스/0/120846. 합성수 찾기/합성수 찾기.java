class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            
            int cnt = 0;
            
            for(int j=1; j<=i; j++){
                
                cnt += (i%j==0) ? 1 : 0;
            }
            
            if(cnt >= 3) answer++;
        }
        
        return answer;
    }
}