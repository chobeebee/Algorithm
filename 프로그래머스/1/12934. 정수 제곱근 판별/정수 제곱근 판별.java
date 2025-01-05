class Solution {
    public long solution(long n) {
        
        long answer = 0;
        double sq = Math.sqrt(n);
        
        if(sq == (long)sq){
            
            long ans = (long)sq;
            answer = (ans+1)*(ans+1);
            
        }else{
            return -1;
        }
        
        return answer;
    }
}