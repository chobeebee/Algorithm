class Solution {
    public int solution(int balls, int share) {
        int answer = recur(balls, share);
        
        return answer;
    }
    
    public int recur(int b, int s){
        if(b == s || s == 0) {
            return 1;
        }else{
            return recur(b-1, s-1) + recur(b-1, s);
        }
        
    }
}